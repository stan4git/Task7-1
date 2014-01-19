package model;
import java.io.Serializable;  
  
public class user implements Serializable {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 3133010767409313642L;
	private String name;  
    private String email;
    private String sex;
    private String password;
    private String dob;
    private String driverlicense;


	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDriverlicense() {
		return driverlicense;
	}
	public void setDriverlicense(String driverlicense) {
		this.driverlicense = driverlicense;
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
	
} 