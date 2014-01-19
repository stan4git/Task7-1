package action;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class reviseProfile extends ActionSupport{

	private String name;  
    private String email;
    private String sex;
    private String driverlicense;
    private String dob;
    private List<user> userlist;
   private user u;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String revise() throws IOException{
		
		 String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
   
			try{     
				email=ActionContext.getContext().getSession().get("email").toString();

			//validate driverlicense
			String checkdl = "[0-9]{8}";
			Pattern regex = Pattern.compile(checkdl);
			java.util.regex.Matcher matcher = regex.matcher(driverlicense);
			boolean isMatched = matcher.matches();
			              
//check whether the email address is valid
              	
   if(name.equals("")||sex.equals("")||dob.equals(""))
  {
     
     JOptionPane.showMessageDialog(null,"Please fill required information!","Message",JOptionPane.WARNING_MESSAGE);
  	return "fail";

  }  
  else if (!driverlicense.equals(""))
  {
 	 if(!isMatched)
 	 {
 		 JOptionPane.showMessageDialog(null,"Driver License should only be 8 numeric numbers!","Message",JOptionPane.ERROR_MESSAGE);
 	return "fail";
 	 }
 	 
 	 else{
 		 //update user info
 		 u=new user();
 		 u.setEmail(email);
     	 u.setName(name);
     	 u.setDob(dob);
     	 u.setDriverlicense(driverlicense);
     	 u.setSex(sex);
          session.update("updateuserinfo",u);
  	    session.commit();	
         JOptionPane.showMessageDialog(null,"Updated Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
             return "updatedsuccessfully";
 	 }
  }
      
  else {
 	 //update user's info
	  System.out.println("email in revise="+email);
	  System.out.println("name in revise="+name);
	  System.out.println("dob in revise="+dob);
	  System.out.println("driverlicense in revise="+driverlicense);

	  u=new user();
	 u.setEmail(email);
  	 u.setName(name);
  	 u.setDob(dob);
  	 u.setDriverlicense(driverlicense);
  	 u.setSex(sex);
       session.update("updateuserinfo",u);
	    session.commit();	
      JOptionPane.showMessageDialog(null,"Updated Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
          return SUCCESS;
  }

          }finally{
              session.close();
          }
	
	
	}

	public String getInfo() throws IOException{
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		try{
			email=ActionContext.getContext().getSession().get("email").toString();
            userlist=session.selectList("selectuserbyemail",email);
            name=userlist.get(0).getName();
            sex=userlist.get(0).getSex();
            dob=userlist.get(0).getDob();
            driverlicense=userlist.get(0).getDriverlicense();
 return SUCCESS;
		}finally{
			session.close();
		}
	}
	
	public String cancel(){
		return "cancel";
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDriverlicense() {
		return driverlicense;
	}

	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<user> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<user> userlist) {
		this.userlist = userlist;
	}

}
