package action;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import model.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePassword extends ActionSupport{
	private String username;
	private List<User> userlist;
	private User newuser;
	private String password;
	private String originalpassword;
    private String confirmpassword;
    
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
				username=ActionContext.getContext().getSession().get("username").toString();
				userlist=session.selectList("selectuserbyusername", username);
				if(!userlist.get(0).getPassword().equals(originalpassword)){
					JOptionPane.showMessageDialog(null,"Your original password is incorrect!","Message",JOptionPane.INFORMATION_MESSAGE);
					return "fail";
				}
				else if(!password.equals(confirmpassword)){
					JOptionPane.showMessageDialog(null,"Two passwords don't match, please type it agian!","Message",JOptionPane.INFORMATION_MESSAGE);
					return "fail";
				}
				else{
					newuser=new User();
					newuser.setUsername(username);
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

}
