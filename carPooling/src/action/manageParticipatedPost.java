package action;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.detailsofdriverpost;
import model.detailsofpassengerpost;
import model.driverapply;
import model.passengerapply;
import model.postasdriver;
import model.postaspassenger;
import model.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class manageParticipatedPost extends ActionSupport{
private String email;
private List<driverapply> dlist;
private List<passengerapply> plist;
private List<postaspassenger> paplist;
private List<postasdriver> padlist;
private postaspassenger pap;
private postasdriver pad;
private String passengerpostID;
private String driverpostID;

private String passengeremail;
private String passengername;
private String departure;
private String destination;
private String departuredate;
private String estimatedleavingtime;
private String needseats;
private String expectedcartype;
private String expectedcost;
private String phone;
private String memo;
private String numberofapplieddrivers;
private String sex;
private String dob;

private String driveremail;
private String drivername;
private String availableseats;
private String cartype;
private String estimatedtotalcost;
private String estimatedcostperpassenger;
private String driverlicense;
private String numberofappliedpassengers;
	
private detailsofpassengerpost detailpassengerpost;
private detailsofdriverpost detaildriverpost;
private List<detailsofpassengerpost> detaillist;
private List<detailsofdriverpost> detaillist2;
private List<user> passengerinfolist;
private List<user> driverinfolist;

private String postID;

private driverapply da;
private passengerapply pa;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//passengers selected by me, now I am a driver
	public String asDriver() throws IOException{
		
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
		try{
			//user's email as a driver
			email=ActionContext.getContext().getSession().get("email").toString();
			dlist=session.selectList("selectdriverapplybydriveremail",email);
			System.out.println("selected passengers as a driver="+dlist.size());
			
			detaillist=new ArrayList<detailsofpassengerpost>();
			
			for(int i=0;i<dlist.size();++i){
				passengerpostID=dlist.get(i).getPassengerpostID();
				passengeremail=dlist.get(i).getPassengeremail();
				
				//get passenger's basic information like sex, name,dob
				passengerinfolist=session.selectList("selectuserbyemail",passengeremail);

				//get passenger's post detailed information
				paplist=session.selectList("selectPassengerPostByID", passengerpostID);
				
				detailpassengerpost=new detailsofpassengerpost();
				
				passengername=passengerinfolist.get(0).getName();
				sex=passengerinfolist.get(0).getSex();
				dob=passengerinfolist.get(0).getDob();
				departure=paplist.get(0).getDeparture();
				destination=paplist.get(0).getDestination();
				departuredate=paplist.get(0).getDeparturedate();
				estimatedleavingtime=paplist.get(0).getEstimatedleavingtime();
				needseats=paplist.get(0).getNeedseats();
				expectedcartype=paplist.get(0).getExpectedcartype();
				expectedcost=paplist.get(0).getExpectedcost();
				phone=paplist.get(0).getPhone();
				memo=paplist.get(0).getMemo();
				numberofapplieddrivers=paplist.get(0).getNumberofapplieddrivers();
				
				detailpassengerpost.setDeparture(departure);
				detailpassengerpost.setDeparturedate(departuredate);
				detailpassengerpost.setDestination(destination);
				detailpassengerpost.setDob(dob);
				detailpassengerpost.setEmail(passengeremail);
				detailpassengerpost.setEstimatedleavingtime(estimatedleavingtime);
				detailpassengerpost.setExpectedcartype(expectedcartype);
				detailpassengerpost.setExpectedcost(expectedcost);
				detailpassengerpost.setMemo(memo);
				detailpassengerpost.setName(passengername);
				detailpassengerpost.setNeedseats(needseats);
				detailpassengerpost.setNumberofapplieddrivers(numberofapplieddrivers);
				detailpassengerpost.setPhone(phone);
				detailpassengerpost.setPostID(passengerpostID);
				detailpassengerpost.setSex(sex);
				detaillist.add(detailpassengerpost);	
			}
			return SUCCESS;
			
		}finally{
			session.close();
		}
	
	}
	//see selected post's detailed information
	public String seedetails() throws IOException{
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		try{
			
			System.out.println("selected passenger's postID in see details="+postID);
			paplist=session.selectList("selectPassengerPostByID", postID);
			detaillist=new ArrayList<detailsofpassengerpost>();
			
			detailpassengerpost=new detailsofpassengerpost();
			passengeremail=paplist.get(0).getEmail();

			passengerinfolist=session.selectList("selectuserbyemail",passengeremail);
			
			passengername=passengerinfolist.get(0).getName();
			sex=passengerinfolist.get(0).getSex();
			dob=passengerinfolist.get(0).getDob();
			departure=paplist.get(0).getDeparture();
			destination=paplist.get(0).getDestination();
			departuredate=paplist.get(0).getDeparturedate();
			estimatedleavingtime=paplist.get(0).getEstimatedleavingtime();
			needseats=paplist.get(0).getNeedseats();
			expectedcartype=paplist.get(0).getExpectedcartype();
			expectedcost=paplist.get(0).getExpectedcost();
			phone=paplist.get(0).getPhone();
			memo=paplist.get(0).getMemo();
			numberofapplieddrivers=paplist.get(0).getNumberofapplieddrivers();
			
			detailpassengerpost.setDeparture(departure);
			detailpassengerpost.setDeparturedate(departuredate);
			detailpassengerpost.setDestination(destination);
			detailpassengerpost.setDob(dob);
			detailpassengerpost.setEmail(passengeremail);
			detailpassengerpost.setEstimatedleavingtime(estimatedleavingtime);
			detailpassengerpost.setExpectedcartype(expectedcartype);
			detailpassengerpost.setExpectedcost(expectedcost);
			detailpassengerpost.setMemo(memo);
			detailpassengerpost.setName(passengername);
			detailpassengerpost.setNeedseats(needseats);
			detailpassengerpost.setNumberofapplieddrivers(numberofapplieddrivers);
			detailpassengerpost.setPhone(phone);
			detailpassengerpost.setPostID(postID);
			detailpassengerpost.setSex(sex);
			detaillist.add(detailpassengerpost);	
			return "seedetailsok";
		}finally{
			session.close();
		}
		
		
	}
	public String exitparticipation() throws IOException{
		
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
        da=new driverapply();
		
		System.out.println("selected passenger's postID in exit="+postID);
		System.out.println("Driver's email in exit="+postID);
		
		
		try{
			//user's email as a driver
			email=ActionContext.getContext().getSession().get("email").toString();
		int res;
		res=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the participation?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(res==JOptionPane.YES_OPTION){
			//select record from postaspassenger table, get its numberofapplieddrivers
			paplist=session.selectList("selectPassengerPostByID",postID);
			numberofapplieddrivers=paplist.get(0).getNumberofapplieddrivers();
			
			//delete participation record from driverapply table
			da.setDriveremail(email);
			da.setPassengerpostID(postID);
			session.delete("deleteparticipation",da);
			session.commit();
			
			//update attribute of numberofapplieddrivers in postaspassenger table 
			pap=new postaspassenger();
			pap.setPostID(postID);
			pap.setNumberofapplieddrivers(String.valueOf(Integer.parseInt(numberofapplieddrivers)-1));
			session.update("updatenumberofapplieddrivers",pap);
			session.commit();
			
			return "deleteandupdateok";
		}
		else{
			return "nodeleteandupdate";
		}
		}finally{
			session.close();
		}
			
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////
	//as passenger, see drivers' posts that I have paid attention to
	
public String asPassenger() throws IOException{
		
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
		try{
			//user's email as a driver
			email=ActionContext.getContext().getSession().get("email").toString();
			//find drivers' post that I have paid attention to from passengerapply table
			plist=session.selectList("selectpassengerapplybypassengeremail",email);
			System.out.println("selected drivers as a passenger="+plist.size());
			
			detaillist2=new ArrayList<detailsofdriverpost>();
			
			for(int i=0;i<plist.size();++i){
				driverpostID=plist.get(i).getDriverpostID();
				driveremail=plist.get(i).getDriveremail();
				
				//get driver's basic information like sex, name,dob
				driverinfolist=session.selectList("selectuserbyemail",driveremail);

				//get driver's post detailed information
				padlist=session.selectList("selectPostByID", driverpostID);
				
				detaildriverpost=new detailsofdriverpost();
				
				drivername=driverinfolist.get(0).getName();
				sex=driverinfolist.get(0).getSex();
				dob=driverinfolist.get(0).getDob();
				driverlicense=driverinfolist.get(0).getDriverlicense();
				departure=padlist.get(0).getDeparture();
				destination=padlist.get(0).getDestination();
				departuredate=padlist.get(0).getDeparturedate();
				estimatedleavingtime=padlist.get(0).getEstimatedleavingtime();
				availableseats=padlist.get(0).getAvailableseats();
				cartype=padlist.get(0).getCartype();
				estimatedtotalcost=padlist.get(0).getEstimatedtotalcost();
				estimatedcostperpassenger=padlist.get(0).getEstimatedcostperpassenger();
				phone=padlist.get(0).getPhone();
				memo=padlist.get(0).getMemo();
				numberofappliedpassengers=padlist.get(0).getNumberofappliedpassengers();
				
				
				detaildriverpost.setDeparture(departure);
				detaildriverpost.setDeparturedate(departuredate);
				detaildriverpost.setDestination(destination);
				detaildriverpost.setDob(dob);
				detaildriverpost.setEmail(passengeremail);
				detaildriverpost.setEstimatedleavingtime(estimatedleavingtime);
				detaildriverpost.setCartype(cartype);
				detaildriverpost.setEstimatedcostperpassenger(estimatedcostperpassenger);
				detaildriverpost.setEstimatedtotalcost(estimatedtotalcost);
				detaildriverpost.setMemo(memo);
				detaildriverpost.setName(passengername);
				detaildriverpost.setAvailableseats(availableseats);
				detaildriverpost.setNumberofappliedpassengers(numberofappliedpassengers);
				detaildriverpost.setPhone(phone);
				detaildriverpost.setPostID(driverpostID);
				detaildriverpost.setSex(sex);
				detaildriverpost.setDriverlicense(driverlicense);
				detaillist2.add(detaildriverpost);	
			}
			return "success2";
			
		}finally{
			session.close();
		}
	
	}
	


//see selected post's detailed information---driver's post
	public String seedetails2() throws IOException{
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
try{
			
			System.out.println("selected driver's postID in see details2="+postID);
			padlist=session.selectList("selectPostByID", postID);
			detaillist2=new ArrayList<detailsofdriverpost>();
			
			detaildriverpost=new detailsofdriverpost();
			driveremail=padlist.get(0).getEmail();

			driverinfolist=session.selectList("selectuserbyemail",driveremail);
			
			drivername=driverinfolist.get(0).getName();
			sex=driverinfolist.get(0).getSex();
			dob=driverinfolist.get(0).getDob();
			driverlicense=driverinfolist.get(0).getDriverlicense();
			departure=padlist.get(0).getDeparture();
			destination=padlist.get(0).getDestination();
			departuredate=padlist.get(0).getDeparturedate();
			estimatedleavingtime=padlist.get(0).getEstimatedleavingtime();
			availableseats=padlist.get(0).getAvailableseats();
			cartype=padlist.get(0).getCartype();
			estimatedtotalcost=padlist.get(0).getEstimatedtotalcost();
			estimatedcostperpassenger=padlist.get(0).getEstimatedcostperpassenger();
			phone=padlist.get(0).getPhone();
			memo=padlist.get(0).getMemo();
			numberofappliedpassengers=padlist.get(0).getNumberofappliedpassengers();
			
			detaildriverpost.setDeparture(departure);
			detaildriverpost.setDeparturedate(departuredate);
			detaildriverpost.setDestination(destination);
			detaildriverpost.setDob(dob);
			detaildriverpost.setEmail(driveremail);
			detaildriverpost.setEstimatedleavingtime(estimatedleavingtime);
			detaildriverpost.setCartype(cartype);
			detaildriverpost.setEstimatedtotalcost(estimatedtotalcost);
			detaildriverpost.setEstimatedcostperpassenger(estimatedcostperpassenger);
			detaildriverpost.setMemo(memo);
			detaildriverpost.setName(drivername);
			detaildriverpost.setAvailableseats(availableseats);
			detaildriverpost.setNumberofappliedpassengers(numberofappliedpassengers);
			detaildriverpost.setPhone(phone);
			detaildriverpost.setPostID(postID);
			detaildriverpost.setSex(sex);
			detaildriverpost.setDriverlicense(driverlicense);
			detaillist2.add(detaildriverpost);	
			return "seedetailsok2";
		}finally{
			session.close();
		}
		
	}
	
	//exit the participation---you are a passenger
public String exitparticipation2() throws IOException{
		
		String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
        pa=new passengerapply();
		
		System.out.println("selected driver's postID in exit2="+postID);
		System.out.println("passenger's email in exit2="+postID);
		
		
		try{
			//user's email as a passenger
			email=ActionContext.getContext().getSession().get("email").toString();
		int res;
		res=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the participation?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(res==JOptionPane.YES_OPTION){
			//select record from postasdriver table, get its numberofappliedpassengers
			padlist=session.selectList("selectPostByID",postID);
			numberofappliedpassengers=padlist.get(0).getNumberofappliedpassengers();
			
			//delete participation record from passengerapply table
			pa.setPassengeremail(email);
			pa.setDriverpostID(postID);;
			session.delete("deleteparticipation2",pa);
			session.commit();
			
			//update attribute of numberofapplieddrivers in postaspassenger table 
			pad=new postasdriver();
			pad.setPostID(postID);
			pad.setNumberofappliedpassengers(String.valueOf(Integer.parseInt(numberofappliedpassengers)-1));
			session.update("updatenumberofappliedpassengers",pad);
			session.commit();
		    
			JOptionPane.showMessageDialog(null,"You have exited the participation successfully!","Message",JOptionPane.INFORMATION_MESSAGE);

			return "deleteandupdateok2";
		}
		else{
			
			return "nodeleteandupdate2";
		}
		}finally{
			session.close();
		}
			
	}


	public List<passengerapply> getPlist() {
	return plist;
}
public void setPlist(List<passengerapply> plist) {
	this.plist = plist;
}
public List<postasdriver> getPadlist() {
	return padlist;
}
public void setPadlist(List<postasdriver> padlist) {
	this.padlist = padlist;
}
public postaspassenger getPap() {
	return pap;
}
public void setPap(postaspassenger pap) {
	this.pap = pap;
}
public String getDriverpostID() {
	return driverpostID;
}
public void setDriverpostID(String driverpostID) {
	this.driverpostID = driverpostID;
}
public String getDriveremail() {
	return driveremail;
}
public void setDriveremail(String driveremail) {
	this.driveremail = driveremail;
}
public String getDrivername() {
	return drivername;
}
public void setDrivername(String drivername) {
	this.drivername = drivername;
}
public String getAvailableseats() {
	return availableseats;
}
public void setAvailableseats(String availableseats) {
	this.availableseats = availableseats;
}
public String getCartype() {
	return cartype;
}
public void setCartype(String cartype) {
	this.cartype = cartype;
}
public String getEstimatedtotalcost() {
	return estimatedtotalcost;
}
public void setEstimatedtotalcost(String estimatedtotalcost) {
	this.estimatedtotalcost = estimatedtotalcost;
}
public String getEstimatedcostperpassenger() {
	return estimatedcostperpassenger;
}
public void setEstimatedcostperpassenger(String estimatedcostperpassenger) {
	this.estimatedcostperpassenger = estimatedcostperpassenger;
}
public String getDriverlicense() {
	return driverlicense;
}
public void setDriverlicense(String driverlicense) {
	this.driverlicense = driverlicense;
}
public String getNumberofappliedpassengers() {
	return numberofappliedpassengers;
}
public void setNumberofappliedpassengers(String numberofappliedpassengers) {
	this.numberofappliedpassengers = numberofappliedpassengers;
}
public detailsofdriverpost getDetaildriverpost() {
	return detaildriverpost;
}
public void setDetaildriverpost(detailsofdriverpost detaildriverpost) {
	this.detaildriverpost = detaildriverpost;
}
public List<detailsofdriverpost> getDetaillist2() {
	return detaillist2;
}
public void setDetaillist2(List<detailsofdriverpost> detaillist2) {
	this.detaillist2 = detaillist2;
}
public List<user> getDriverinfolist() {
	return driverinfolist;
}
public void setDriverinfolist(List<user> driverinfolist) {
	this.driverinfolist = driverinfolist;
}
public driverapply getDa() {
	return da;
}
public void setDa(driverapply da) {
	this.da = da;
}
public passengerapply getPa() {
	return pa;
}
public void setPa(passengerapply pa) {
	this.pa = pa;
}
	public List<detailsofpassengerpost> getDetaillist() {
		return detaillist;
	}

	public void setDetaillist(List<detailsofpassengerpost> detaillist) {
		this.detaillist = detaillist;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<driverapply> getDlist() {
		return dlist;
	}

	public void setDlist(List<driverapply> dlist) {
		this.dlist = dlist;
	}

	public List<postaspassenger> getPaplist() {
		return paplist;
	}

	public void setPaplist(List<postaspassenger> paplist) {
		this.paplist = paplist;
	}

	public String getPassengerpostID() {
		return passengerpostID;
	}

	public void setPassengerpostID(String passengerpostID) {
		this.passengerpostID = passengerpostID;
	}

	public String getPassengeremail() {
		return passengeremail;
	}

	public void setPassengeremail(String passengeremail) {
		this.passengeremail = passengeremail;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	public String getEstimatedleavingtime() {
		return estimatedleavingtime;
	}

	public void setEstimatedleavingtime(String estimatedleavingtime) {
		this.estimatedleavingtime = estimatedleavingtime;
	}

	public String getNeedseats() {
		return needseats;
	}

	public void setNeedseats(String needseats) {
		this.needseats = needseats;
	}

	public String getExpectedcartype() {
		return expectedcartype;
	}

	public void setExpectedcartype(String expectedcartype) {
		this.expectedcartype = expectedcartype;
	}

	public String getExpectedcost() {
		return expectedcost;
	}

	public void setExpectedcost(String expectedcost) {
		this.expectedcost = expectedcost;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNumberofapplieddrivers() {
		return numberofapplieddrivers;
	}

	public void setNumberofapplieddrivers(String numberofapplieddrivers) {
		this.numberofapplieddrivers = numberofapplieddrivers;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public detailsofpassengerpost getDetailpassengerpost() {
		return detailpassengerpost;
	}

	public void setDetailpassengerpost(detailsofpassengerpost detailpassengerpost) {
		this.detailpassengerpost = detailpassengerpost;
	}

	public List<user> getPassengerinfolist() {
		return passengerinfolist;
	}

	public void setPassengerinfolist(List<user> passengerinfolist) {
		this.passengerinfolist = passengerinfolist;
	}
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}

}
