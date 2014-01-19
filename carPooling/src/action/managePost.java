package action;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.driverapply;
import model.passengerapply;
import model.postasdriver;
import model.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class managePost extends ActionSupport{
private String email;
private String postID;
private List<postasdriver> postlist;
private List<passengerapply> passengerapplylist;
private List<driverapply> driverapplylist;
private user u;
private List<user> ulist;
private List<user> finduserlist;
private int size;
private String passengeremail;
private String passengername;  
private String passengersex;
private String dob;
private String passengerdriverlicense;

private String driveremail;
private String drivername;  
private String driversex;
private String driverdob;
private String driverlicense;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//manage post as driver
	public String asDriver() throws IOException{
		//connect database
				String resource = "orm/configuration.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
		
				try{
					email=ActionContext.getContext().getSession().get("email").toString();
					System.out.println("driver email in manage="+email);
					postlist=session.selectList("selectpostbydriveremail", email);
					return SUCCESS;
				}finally{
					session.close();
				}

	}
	public String seepassengers() throws IOException{
		//connect database
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
		try{
			System.out.println("driver postID in manage="+postID);
			passengerapplylist=session.selectList("selectpassengerapplybypostID", postID);
			System.out.println("passengerapplylist size in manage="+passengerapplylist.size());
			size=passengerapplylist.size();
			
			ulist=new ArrayList<user>();
			for(int i=0;i<size;++i){
				u=new user();
				passengeremail=passengerapplylist.get(i).getPassengeremail();
				finduserlist=session.selectList("selectuserbyemail", passengeremail);
				 
				 passengername=finduserlist.get(0).getName();  
				 passengersex=finduserlist.get(0).getSex();
				 dob=finduserlist.get(0).getDob();
				 passengerdriverlicense=finduserlist.get(0).getDriverlicense();
				 
				 u.setDob(dob);
				 u.setDriverlicense(passengerdriverlicense);
				 u.setEmail(passengeremail);
				 u.setName(passengername);
				 u.setSex(passengersex);
				 
				 ulist.add(u);
			}
			
			return "ok";
			
		}finally{
			session.close();
		}
		
	}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//manage post as passenger
	
	public String asPassenger() throws IOException{
		//connect database
				String resource = "orm/configuration.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
		
				try{
					email=ActionContext.getContext().getSession().get("email").toString();
					System.out.println("passenger email in manage as passenger="+email);
					
					//select all your posts when you post them as passengers
					postlist=session.selectList("selectpostbypassengeremail", email);
					return "managepostaspassengerok";
				}finally{
					session.close();
				}
	}
	
	public String seedrivers() throws IOException{
		//connect database
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
		try{
			System.out.println("passenger postID in manage="+postID);
			driverapplylist=session.selectList("selectdriverapplybypostID", postID);
			System.out.println("driverapplylist size in manage="+driverapplylist.size());
			size=driverapplylist.size();
			
			ulist=new ArrayList<user>();
			for(int i=0;i<size;++i){
				u=new user();
				driveremail=driverapplylist.get(i).getDriveremail();
				finduserlist=session.selectList("selectuserbyemail", driveremail);
				 
				 drivername=finduserlist.get(0).getName();  
				 driversex=finduserlist.get(0).getSex();
				 driverdob=finduserlist.get(0).getDob();
				 driverlicense=finduserlist.get(0).getDriverlicense();
				 
				 u.setDob(driverdob);
				 u.setDriverlicense(driverlicense);
				 u.setEmail(driveremail);
				 u.setName(drivername);
				 u.setSex(driversex);
				 
				 ulist.add(u);
			}
			
			return "seedriverok";
			
		}finally{
			session.close();
		}
		
	}
	
	
	///////////////////////delete post as driver
	public String deletepost() throws IOException{
		//connect database
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
		try{
			System.out.println("postID in delete as driver="+postID);
			passengerapplylist=session.selectList("selectpassengerapplybypostID",postID);
			int res=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this post?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	     	if(res==JOptionPane.YES_OPTION){
	     		if(passengerapplylist.size()>0){
					session.delete("deletepost",postID);
					session.commit();
					
					session.delete("deletedriverpost",postID);
					session.commit();
					 JOptionPane.showMessageDialog(null,"Post is deleted!","Message",JOptionPane.INFORMATION_MESSAGE);
	                 return "deletepostok";
				}
				
				else{
					session.delete("deletedriverpost",postID);
					session.commit();
					 JOptionPane.showMessageDialog(null,"Post is deleted!","Message",JOptionPane.INFORMATION_MESSAGE);
	                 return "deletepostok";
				}
	     	}
	     	else{
	     		return "nodeletepost";
	     	}
		}finally{
			session.close();
		}
	}
	
	public String deletepostaspassenger() throws IOException{
		//connect database
				String resource = "orm/configuration.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
				SqlSession session = sessionFactory.openSession();
				
				try{
					System.out.println("postID in delete as passenger="+postID);
					driverapplylist=session.selectList("selectdriverapplybypostID",postID);
					int res=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this post?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			     	if(res==JOptionPane.YES_OPTION){
			     		if(driverapplylist.size()>0){
							session.delete("deletepostindriverapply",postID);
							session.commit();
							
							session.delete("deletepassengerpost",postID);
							session.commit();
							 JOptionPane.showMessageDialog(null,"Post is deleted!","Message",JOptionPane.INFORMATION_MESSAGE);
			                 return "deletepostok2";
						}
						
						else{
							session.delete("deletepassengerpost",postID);
							session.commit();
							 JOptionPane.showMessageDialog(null,"Post is deleted!","Message",JOptionPane.INFORMATION_MESSAGE);
			                 return "deletepostok2";
						}
			     	}
			     	else{
			     		return "nodeletepost2";
			     	}
				}finally{
					session.close();
				}
	}

	public List<driverapply> getDriverapplylist() {
		return driverapplylist;
	}
	public void setDriverapplylist(List<driverapply> driverapplylist) {
		this.driverapplylist = driverapplylist;
	}
	public String getDriveremail() {
		return driveremail;
	}
	public void setDriveremail(String driveremail) {
		this.driveremail = driveremail;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getDriversex() {
		return driversex;
	}
	public void setDriversex(String driversex) {
		this.driversex = driversex;
	}
	public String getDriverdob() {
		return driverdob;
	}
	public void setDriverdob(String driverdob) {
		this.driverdob = driverdob;
	}
	public String getDriverlicense() {
		return driverlicense;
	}
	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
	}
	public List<user> getFinduserlist() {
		return finduserlist;
	}
	public void setFinduserlist(List<user> finduserlist) {
		this.finduserlist = finduserlist;
	}
	public List<postasdriver> getPostlist() {
		return postlist;
	}

	public void setPostlist(List<postasdriver> postlist) {
		this.postlist = postlist;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public List<passengerapply> getPassengerapplylist() {
		return passengerapplylist;
	}
	public void setPassengerapplylist(List<passengerapply> passengerapplylist) {
		this.passengerapplylist = passengerapplylist;
	}
	public List<user> getUlist() {
		return ulist;
	}
	public void setUlist(List<user> ulist) {
		this.ulist = ulist;
	}
	public user getU() {
		return u;
	}
	public void setU(user u) {
		this.u = u;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassengername() {
		return passengername;
	}
	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}
	public String getPassengeremail() {
		return passengeremail;
	}
	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}
	public String getPassengersex() {
		return passengersex;
	}
	public void setPassengersex(String passengersex) {
		this.passengersex = passengersex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassengerdriverlicense() {
		return passengerdriverlicense;
	}
	public void setPassengerdriverlicense(String passengerdriverlicense) {
		this.passengerdriverlicense = passengerdriverlicense;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
