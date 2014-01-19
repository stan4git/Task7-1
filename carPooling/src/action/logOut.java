package action;

import java.io.File;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class logOut extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public String out(){
	  File file= new File("E:\\carpoolinguser.txt");
	  file.delete();
	//  ActionContext.getContext().getSession().put("email", "");
	  return "out";
	 
}	
}
