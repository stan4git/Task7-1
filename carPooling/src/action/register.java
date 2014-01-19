package action;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.Matcher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class register extends ActionSupport{
	private String name;  
    private String email;
    private String sex;
    private String password;
    private String confirmpassword;
    private String driverlicense;
    private String dob;
    private List<user> userlist;
    private user newuser;
    private String originalpassword;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String userregistration() throws IOException {
		System.out.println("name in reg="+name);
		System.out.println("email in reg="+email);
		System.out.println("sex in reg="+sex);
		System.out.println("pw in reg="+password);
		System.out.println("cpw in reg="+confirmpassword);
		System.out.println("dob in reg="+dob);
		System.out.println("dl in reg="+driverlicense);
		
		 String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
      
			try{     
               
      		String check = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
			Pattern regex = Pattern.compile(check);
			java.util.regex.Matcher matcher = regex.matcher(email);
			boolean isMatched = matcher.matches();
			
			String checkdl = "[0-9]{8}";
			Pattern regex2 = Pattern.compile(checkdl);
			java.util.regex.Matcher matcher2 = regex2.matcher(driverlicense);
			boolean isMatched2 = matcher2.matches();
			
            userlist = session.selectList("selectuserbyemail", email);
	
                 
//check whether the email address is valid
                 	
      if(email.equals("")||name.equals("")||password.equals("")||confirmpassword.equals("")||sex.equals("")||dob.equals(""))
     {
        
        JOptionPane.showMessageDialog(null,"Please fill required information!","Message",JOptionPane.WARNING_MESSAGE);
     }
     else if(!confirmpassword.equals(password))
     {
     JOptionPane.showMessageDialog(null,"Two passwords don't match, please type again!","Message",JOptionPane.WARNING_MESSAGE);
     }
     else if(!isMatched)
     {
    	 JOptionPane.showMessageDialog(null,"This email address is invalid!","Message",JOptionPane.WARNING_MESSAGE);
     }
     
     else if(!(userlist.isEmpty()))
     {
    	 JOptionPane.showMessageDialog(null,"This email address has been registered!","Message",JOptionPane.WARNING_MESSAGE);
			      }
      
     else if (!driverlicense.equals(""))
     {
    	 if(!isMatched2)
    	 {
    		 JOptionPane.showMessageDialog(null,"Driver License should only be 8 numeric numbers!","Message",JOptionPane.WARNING_MESSAGE);
    	 }
    	 
    	 else{
    		 //insert new user
    		 newuser=new user();
        	 newuser.setEmail(email);
        	 newuser.setName(name);
        	 newuser.setPassword(password);
        	 newuser.setDob(dob);
        	 newuser.setDriverlicense(driverlicense);
        	 newuser.setSex(sex);
             session.insert("insertuserinfo",newuser);
     	    session.commit();	
            JOptionPane.showMessageDialog(null,"Registered Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
                return SUCCESS;
    	 }
     }
         
     else {
    	 //insert new user
    	 newuser=new user();
    	 newuser.setEmail(email);
    	 newuser.setName(name);
    	 newuser.setPassword(password);
    	 newuser.setDob(dob);
    	 newuser.setDriverlicense(driverlicense);
    	 newuser.setSex(sex);
         session.insert("insertuserinfo",newuser);
 	    session.commit();	
        JOptionPane.showMessageDialog(null,"Registered Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
            return SUCCESS;
     }

             }finally{
                 session.close();
             }
             
             return "registerfail";
		
			}
	
	
	
	public String change() throws IOException{
		
		 String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			System.out.println("original pw="+originalpassword);
			System.out.println("pw="+password);
			System.out.println("confirm pw="+confirmpassword);

			
			try{
				if(originalpassword.equals("")||password.equals("")||confirmpassword.equals("")){
		            JOptionPane.showMessageDialog(null,"No Empty!","Message",JOptionPane.INFORMATION_MESSAGE);
                  return "fail";
				}
				else{
					//get user's email address
					email=ActionContext.getContext().getSession().get("email").toString();
					userlist=session.selectList("selectuserbyemail", email);
					if(!userlist.get(0).getPassword().equals(originalpassword)){
						 JOptionPane.showMessageDialog(null,"Your original password is incorrect!","Message",JOptionPane.INFORMATION_MESSAGE);
		                  return "fail";
					}
					else if(!password.equals(confirmpassword)){
						 JOptionPane.showMessageDialog(null,"Two passwords don't match, please type it agian!","Message",JOptionPane.INFORMATION_MESSAGE);
		                  return "fail";
					}
					else{
						newuser=new user();
						newuser.setEmail(email);
						newuser.setPassword(password);
						session.update("updatepassword",newuser);
						session.commit();
						JOptionPane.showMessageDialog(null,"Updated Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
                        return SUCCESS;

					}
				}
			
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverlicense() {
		return driverlicense;
	}


	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
	}
	
	public String getConfirmpassword() {
		return confirmpassword;
	}



	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
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



	public user getNewuser() {
		return newuser;
	}

	public void setNewuser(user newuser) {
		this.newuser = newuser;
	}


	public String getOriginalpassword() {
		return originalpassword;
	}

	public void setOriginalpassword(String originalpassword) {
		this.originalpassword = originalpassword;
	}

}
