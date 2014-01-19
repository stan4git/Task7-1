package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import model.driverapply;
import model.postaspassenger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class driverApplyParticipation extends ActionSupport{

	private String driveremail;
	private List<driverapply> dapplylist;
	private driverapply dapply;
    private String postID;
    private String passengeremail;
	private List<postaspassenger> paplist;
	private postaspassenger pap;
	private String numberofapplieddrivers;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String apply() throws IOException{
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		SqlSession session2 = sessionFactory.openSession();
		BufferedReader br=null;
		try{
			
			  File file= new File("E:\\carpoolinguser.txt");
			  if(!file.exists()){
				  JOptionPane.showMessageDialog(null,"You have to log in first to do this operation!","Message",JOptionPane.WARNING_MESSAGE);
		          return "needlogin";
			  }
			  else{
				  FileReader fr=new FileReader("E:\\carpoolinguser.txt");
			        br=new BufferedReader(fr); 
			         String email=br.readLine();
			      driveremail=email;  
			      
//			  	driveremail=(String) ActionContext.getContext().getSession().get("email");
					System.out.println("driver email in apply="+driveremail);
					System.out.println("postID in apply="+postID);
					System.out.println(driveremail==null);
					
					//find passenger's email and number of applied drivers
		    		 paplist=session.selectList("selectPassengerPostByID",postID);
					 numberofapplieddrivers=paplist.get(0).getNumberofapplieddrivers();
					 passengeremail=paplist.get(0).getEmail();
					System.out.println("passenger email in apply="+passengeremail);
					 System.out.println("numberofapplieddrivers in apply="+numberofapplieddrivers);
					
					if(driveremail==null){
			              JOptionPane.showMessageDialog(null,"You have to log in first to do this operation!","Message",JOptionPane.WARNING_MESSAGE);
				          return "fail";
					}
					if(driveremail.equals(passengeremail)){
						 JOptionPane.showMessageDialog(null,"You can't follow your own post!","Message",JOptionPane.ERROR_MESSAGE);
				          return "fail";
					}
				
					//check whether this driver has already applied this post
					else{
						dapply=new driverapply();
						dapply.setPassengerpostID(postID);
					    dapply.setDriveremail(driveremail);
						dapplylist=session.selectList("check",dapply);
						
						if(dapplylist.size()>0){
							 JOptionPane.showMessageDialog(null,"You have already applied participation of this post before!","Message",JOptionPane.WARNING_MESSAGE);
					          return "duplicate";
						}
						
						else{
							int res;
							int num=0;
							res=JOptionPane.showConfirmDialog(null,"Are you sure you want to apply this participation?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					     	if(res==JOptionPane.YES_OPTION)	 {
					     		
								 
							dapply.setPassengerpostID(postID);
							 dapply.setPassengeremail(passengeremail);
							 dapply.setDriveremail(driveremail);
							 session.insert("insertnewdriverapply", dapply);
							 session.commit();
							 
					//update attribute of numberofapplieddrivers in postaspassenger
							
							 if(numberofapplieddrivers==null){
								 num=1;
							 }
							 else{
								 num=Integer.parseInt(numberofapplieddrivers)+1;
								 numberofapplieddrivers=String.valueOf(num);
							 }
							 
							 //update attributes of numberofapplieddrivers in postaspassenger
							 pap=new postaspassenger();
							 pap.setPostID(postID);
							 pap.setNumberofapplieddrivers(String.valueOf(num));
							 
							 session2.update("updatenumberofapplieddrivers",pap);
							 session2.commit();
					         JOptionPane.showMessageDialog(null,"You have participated the post successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
							 return SUCCESS;
						}
					     	
					    	else{
					    		 return "duplicate";
						}						
				}			
					}
			  }
		
				
		}finally{
			session.close();
			session2.close();
			
		}
	}

	public String getDriveremail() {
		return driveremail;
	}

	public void setDriveremail(String driveremail) {
		this.driveremail = driveremail;
	}

	public List<driverapply> getDapplylist() {
		return dapplylist;
	}

	public void setDapplylist(List<driverapply> dapplylist) {
		this.dapplylist = dapplylist;
	}

	public driverapply getDapply() {
		return dapply;
	}

	public void setDapply(driverapply dapply) {
		this.dapply = dapply;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getPassengeremail() {
		return passengeremail;
	}

	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}

	public List<postaspassenger> getPaplist() {
		return paplist;
	}

	public void setPaplist(List<postaspassenger> paplist) {
		this.paplist = paplist;
	}

	public postaspassenger getPap() {
		return pap;
	}

	public void setPap(postaspassenger pap) {
		this.pap = pap;
	}

	public String getNumberofapplieddrivers() {
		return numberofapplieddrivers;
	}

	public void setNumberofapplieddrivers(String numberofapplieddrivers) {
		this.numberofapplieddrivers = numberofapplieddrivers;
	}
	
}