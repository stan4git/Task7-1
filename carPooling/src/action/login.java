package action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import model.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class login extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private List<user> userlist;



	public String userlogin() throws IOException{
		System.out.println("email in login="+email);
		System.out.println("pw in login="+password);

		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		try{
			//select related email from database, if it exists, you can enter successfully. If it doesn't exist, please regsiter first.
			userlist = session.selectList("selectuserbyemail", email);
			if(userlist.isEmpty())
			{ 
				JOptionPane.showMessageDialog(null,"Register first please","Message",JOptionPane.WARNING_MESSAGE);
			}
			else{

				for (user a: userlist) {
					if(password.toString().equals(a.getPassword()))
					{    ActionContext.getContext().getSession().put("email",email);   
					// ActionContext.getContext().getSession().put("password",password);   
					writeUser(email);

					return SUCCESS;
					}
					else{
						JOptionPane.showMessageDialog(null,"Wrong Password!","Message",JOptionPane.ERROR_MESSAGE);
						return "loginfalse";
					}

				} 
			}
		}  finally{
			session.close();
		} 

		return "loginfalse";
	}



	public static void writeUser(String c) throws IOException {
		String email = c;
		BufferedWriter bf = null;
		try {
			System.out.println("write email="+email);

			FileWriter output = new FileWriter(
					"E:\\carpoolinguser.txt");
			bf = new BufferedWriter(output);
			bf.write(email);
			bf.flush();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			bf.close();
		}
	}



	///test login
	public String testLogin() throws IOException{
		File file= new File("E:\\carpoolinguser.txt");
		if(!file.exists()){  
			return "needlogin";
		}

		else{
			return "noneedlogin";
		}

	}

	//if user file exists, login directly.
	public String directlogin() throws IOException{
		BufferedReader br=null;

		try{

			FileReader fr=new FileReader("E:\\carpoolinguser.txt");
			br=new BufferedReader(fr); 
			String email=br.readLine();

			ActionContext.getContext().getSession().put("email",email);   


			return "success";

		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}finally{
			br.close();  

		}
		return "needlogin";
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
