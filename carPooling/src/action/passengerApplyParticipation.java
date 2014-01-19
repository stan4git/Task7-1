package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import model.passengerapply;
import model.postasdriver;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class passengerApplyParticipation extends ActionSupport{

	private String passengeremail;
	private List<passengerapply> papplylist;
	private passengerapply papply;
    private String postID;
    private String driveremail;
	private List<postasdriver> padlist;
	private postasdriver pad;
	private String numberofappliedpassengers;
	private String driverpostID;
	
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
		//	driverpostID=postID;
			  File file= new File("E:\\carpoolinguser.txt");
			  if(!file.exists()){
				  JOptionPane.showMessageDialog(null,"You have to log in first to do this operation!","Message",JOptionPane.WARNING_MESSAGE);
		          return "needlogin";
			  }
			  else{
				  FileReader fr=new FileReader("E:\\carpoolinguser.txt");
			        br=new BufferedReader(fr); 
			         String email=br.readLine();
			      passengeremail=email;   
			       
			//	passengeremail=(String) ActionContext.getContext().getSession().get("email");
				System.out.println("passenger email in apply="+passengeremail);
				System.out.println("postID in apply="+postID);
				System.out.println(passengeremail==null);
				
				//find driver's email and number of applied passengers
	    		 padlist=session.selectList("selectPostByID",postID);
				 numberofappliedpassengers=padlist.get(0).getNumberofappliedpassengers();
				 driveremail=padlist.get(0).getEmail();
				System.out.println("driver email in apply="+driveremail);
				 System.out.println("numberofappliedpassengers in apply="+numberofappliedpassengers);
				
				/*if(passengeremail==null){
		              JOptionPane.showMessageDialog(null,"You have to log in first to do this operation!","Message",JOptionPane.WARNING_MESSAGE);
			          return "fail";
				}*/
				if(driveremail.equals(passengeremail)){
					 JOptionPane.showMessageDialog(null,"You can't follow your own post!","Message",JOptionPane.ERROR_MESSAGE);
			          return "fail";
				}
			
				//check whether this passenger has already applied this post
				else{
					papply=new passengerapply();
				    papply.setDriverpostID(postID);
				    papply.setPassengeremail(passengeremail);
					papplylist=session.selectList("selectpassengerapply",papply);
	 
					if(papplylist.size()>0){
						 JOptionPane.showMessageDialog(null,"You have already applied participation of this post before!","Message",JOptionPane.WARNING_MESSAGE);
				          return "duplicate";
					}
					
					else{
						int res;
						int num=0;
						res=JOptionPane.showConfirmDialog(null,"Are you sure you want to apply this participation?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				     	if(res==JOptionPane.YES_OPTION)	 {
				     		
							 
						papply.setDriverpostID(postID);
						 papply.setPassengeremail(passengeremail);
						 papply.setDriveremail(driveremail);
						 session.insert("insertnewpassengerapply", papply);
						 session.commit();
						 
				//update attribute of numberofappliedpassengers in postasdriver
						
						 if(numberofappliedpassengers==null){
							 num=1;
						 }
						 else{
							 num=Integer.parseInt(numberofappliedpassengers)+1;
							 numberofappliedpassengers=String.valueOf(num);
						 }
						 
						 //update attributes of numberofappliedpassengers in postasdriver 
						 pad=new postasdriver();
						 pad.setPostID(postID);
						 pad.setNumberofappliedpassengers(String.valueOf(num));
						 
						 session2.update("updatenumberofappliedpassengers",pad);
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

	public postasdriver getPad() {
		return pad;
	}

	public void setPad(postasdriver pad) {
		this.pad = pad;
	}

	public String getDriverpostID() {
		return driverpostID;
	}

	public void setDriverpostID(String driverpostID) {
		this.driverpostID = driverpostID;
	}

	public List<passengerapply> getPapplylist() {
		return papplylist;
	}

	public void setPapplylist(List<passengerapply> papplylist) {
		this.papplylist = papplylist;
	}
	
	public String getPassengeremail() {
		return passengeremail;
	}

	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}

	public passengerapply getPapply() {
		return papply;
	}

	public void setPapply(passengerapply papply) {
		this.papply = papply;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getNumberofappliedpassengers() {
		return numberofappliedpassengers;
	}

	public void setNumberofappliedpassengers(String numberofappliedpassengers) {
		this.numberofappliedpassengers = numberofappliedpassengers;
	}
	public List<postasdriver> getPadlist() {
		return padlist;
	}

	public void setPadlist(List<postasdriver> padlist) {
		this.padlist = padlist;
	}


	public String getDriveremail() {
		return driveremail;
	}

	public void setDriveremail(String driveremail) {
		this.driveremail = driveremail;
	}


}
