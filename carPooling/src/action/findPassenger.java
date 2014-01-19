package action;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import model.detailsofdriverpost;
import model.detailsofpassengerpost;
import model.postaspassenger;
import model.user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class findPassenger extends ActionSupport{
	 private String postID;
		private postaspassenger ppassenger;
		private List<postaspassenger> postlist;
		private String passengeremail;
		private String driveremail;
		private List<user> passengerlist;	
		private String passengername;
		private String passengersex;
		private String passengerdob;
		private detailsofpassengerpost dd;
		private List<detailsofpassengerpost> detaillist;	
		private String numberofapplieddrivers;

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public List<postaspassenger> findlist() throws IOException{
			
			//connect database
					String resource = "orm/configuration.xml";
						Reader reader = Resources.getResourceAsReader(resource);
						SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
						SqlSession session = sessionFactory.openSession();
			
			try{
				
				postlist=session.selectList("selectAllPostAsPassenger");
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
		
//see details of passenger's post
public List<detailsofpassengerpost> seedetailslist() throws IOException{
//connect database
String resource = "orm/configuration.xml";
Reader reader = Resources.getResourceAsReader(resource);
SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
SqlSession session = sessionFactory.openSession();

try{
	System.out.println("postID in seeDetails="+postID);
postlist=session.selectList("selectPassengerPostByID",postID);
System.out.println("postlist size in seeDetails="+postlist.size());

//find passenger's name through his email address
numberofapplieddrivers=postlist.get(0).getNumberofapplieddrivers();
passengeremail=postlist.get(0).getEmail();
passengerlist=session.selectList("selectuserbyemail", passengeremail);

passengername=passengerlist.get(0).getName();
passengersex=passengerlist.get(0).getSex();
passengerdob=passengerlist.get(0).getDob();

dd=new detailsofpassengerpost();
detaillist=new ArrayList<detailsofpassengerpost>();

dd.setNeedseats(postlist.get(0).getNeedseats());
dd.setExpectedcartype(postlist.get(0).getExpectedcartype());
dd.setDeparture(postlist.get(0).getDeparture());
dd.setDeparturedate(postlist.get(0).getDeparturedate());
dd.setDestination(postlist.get(0).getDestination());
dd.setDob(passengerdob);
dd.setEmail(passengeremail);
dd.setEstimatedleavingtime(postlist.get(0).getEstimatedleavingtime());
dd.setExpectedcost(postlist.get(0).getExpectedcost());
dd.setMemo(postlist.get(0).getMemo());
dd.setName(passengername);
dd.setPostID(postID);
dd.setSex(passengersex);
dd.setPhone(postlist.get(0).getPhone());
dd.setNumberofapplieddrivers(numberofapplieddrivers);
detaillist.add(dd);

return detaillist;

}finally{
session.close();
}
}


public String seedetails() throws IOException{
seedetailslist();
driveremail=(String) ActionContext.getContext().getSession().get("email");
System.out.println("driveremail in seeDetails="+driveremail);
System.out.println("postID in seeDetails="+postID);

return "seedetailsok";

}
		
		
		public String getPostID() {
			return postID;
		}

		public void setPostID(String postID) {
			this.postID = postID;
		}

		public postaspassenger getPpassenger() {
			return ppassenger;
		}

		public void setPpassenger(postaspassenger ppassenger) {
			this.ppassenger = ppassenger;
		}

		public List<postaspassenger> getPostlist() {
			return postlist;
		}

		public void setPostlist(List<postaspassenger> postlist) {
			this.postlist = postlist;
		}

		public String getPassengeremail() {
			return passengeremail;
		}

		public void setPassengeremail(String passengeremail) {
			this.passengeremail = passengeremail;
		}

		public List<user> getPassengerlist() {
			return passengerlist;
		}

		public void setPassengerlist(List<user> passengerlist) {
			this.passengerlist = passengerlist;
		}

		public String getPassengername() {
			return passengername;
		}

		public void setPassengername(String passengername) {
			this.passengername = passengername;
		}

		public String getPassengersex() {
			return passengersex;
		}

		public void setPassengersex(String passengersex) {
			this.passengersex = passengersex;
		}

		public String getPassengerdob() {
			return passengerdob;
		}

		public void setPassengerdob(String passengerdob) {
			this.passengerdob = passengerdob;
		}

		public detailsofpassengerpost getDd() {
			return dd;
		}

		public void setDd(detailsofpassengerpost dd) {
			this.dd = dd;
		}

		public List<detailsofpassengerpost> getDetaillist() {
			return detaillist;
		}

		public void setDetaillist(List<detailsofpassengerpost> detaillist) {
			this.detaillist = detaillist;
		}
		public String getDriveremail() {
			return driveremail;
		}

		public void setDriveremail(String driveremail) {
			this.driveremail = driveremail;
		}

		public String getNumberofapplieddrivers() {
			return numberofapplieddrivers;
		}

		public void setNumberofapplieddrivers(String numberofapplieddrivers) {
			this.numberofapplieddrivers = numberofapplieddrivers;
		}

		
}
		
