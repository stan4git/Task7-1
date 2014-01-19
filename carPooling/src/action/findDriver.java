package action;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import model.detailsofdriverpost;
import model.postasdriver;
import model.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class findDriver extends ActionSupport{
    private String postID;
	private postasdriver pdrive;
	private List<postasdriver> postlist;
	private String passengeremail;
	private List<user> driverlist;	
	private String driveremail;
	private String drivername;
	private String driversex;
	private String driverdob;
	private String driverlicense;
	private detailsofdriverpost dd;
	private List<detailsofdriverpost> detaillist;	
	private String numberofappliedpassengers;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<postasdriver> findlist() throws IOException{
		
		//connect database
				String resource = "orm/configuration.xml";
					Reader reader = Resources.getResourceAsReader(resource);
					SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					SqlSession session = sessionFactory.openSession();
		
		try{
			
			postlist=session.selectList("selectAllPostAsDriver");
			System.out.println("postlist size="+postlist.size());
			 return postlist;

		}finally{
			session.close();
		}
		
	}
	
	public String find() throws IOException{
		findlist();
		return SUCCESS;		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//see details of driver's post
	public List<detailsofdriverpost> seedetailslist() throws IOException{
		//connect database
		String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();

try{
	
	postlist=session.selectList("selectPostByID",postID);
	System.out.println("postlist size in seeDetails="+postlist.size());
	
	//find driver's name through his email address
	numberofappliedpassengers=postlist.get(0).getNumberofappliedpassengers();
	driveremail=postlist.get(0).getEmail();
	driverlist=session.selectList("selectuserbyemail", driveremail);
	
	drivername=driverlist.get(0).getName();
	driversex=driverlist.get(0).getSex();
	driverdob=driverlist.get(0).getDob();
	driverlicense=driverlist.get(0).getDriverlicense();
	
	
	dd=new detailsofdriverpost();
	detaillist=new ArrayList<detailsofdriverpost>();
	
	dd.setAvailableseats(postlist.get(0).getAvailableseats());
	dd.setCartype(postlist.get(0).getCartype());
	dd.setDeparture(postlist.get(0).getDeparture());
	dd.setDeparturedate(postlist.get(0).getDeparturedate());
	dd.setDestination(postlist.get(0).getDestination());
	dd.setDob(driverdob);
	dd.setDriverlicense(driverlicense);
	dd.setEmail(driveremail);
	dd.setEstimatedcostperpassenger(postlist.get(0).getEstimatedcostperpassenger());
	dd.setEstimatedleavingtime(postlist.get(0).getEstimatedleavingtime());
	dd.setEstimatedtotalcost(postlist.get(0).getEstimatedtotalcost());
	dd.setMemo(postlist.get(0).getMemo());
	dd.setName(drivername);
	dd.setPostID(postID);
	dd.setSex(driversex);
	dd.setPhone(postlist.get(0).getPhone());
	dd.setNumberofappliedpassengers(numberofappliedpassengers);
	detaillist.add(dd);

	 return detaillist;

}finally{
	session.close();
}
	}
	
	
	public String seedetails() throws IOException{
		seedetailslist();
		passengeremail=(String) ActionContext.getContext().getSession().get("email");
		System.out.println("passengeremail in seeDetails="+passengeremail);
		System.out.println("postID in seeDetails="+postID);
		
		return "seedetailsok";
		
	}
	
	public postasdriver getPdrive() {
		return pdrive;
	}

	public void setPdrive(postasdriver pdrive) {
		this.pdrive = pdrive;
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

	public String getPassengeremail() {
		return passengeremail;
	}

	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}

	public List<detailsofdriverpost> getDetaillist() {
		return detaillist;
	}

	public void setDetaillist(List<detailsofdriverpost> detaillist) {
		this.detaillist = detaillist;
	}

	public String getDriveremail() {
		return driveremail;
	}

	public void setDriveremail(String driveremail) {
		this.driveremail = driveremail;
	}

	public List<user> getDriverlist() {
		return driverlist;
	}

	public void setDriverlist(List<user> driverlist) {
		this.driverlist = driverlist;
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

	public detailsofdriverpost getDd() {
		return dd;
	}

	public void setDd(detailsofdriverpost dd) {
		this.dd = dd;
	}
	public String getNumberofappliedpassengers() {
		return numberofappliedpassengers;
	}

	public void setNumberofappliedpassengers(String numberofappliedpassengers) {
		this.numberofappliedpassengers = numberofappliedpassengers;
	}

}
