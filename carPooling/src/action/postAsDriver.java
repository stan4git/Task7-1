package action;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.postasdriver;
import model.postaspassenger;
import model.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class postAsDriver extends ActionSupport{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String postID;
	private String email;
	private String departure;
	private String destination;
	private String departuredate;
	private String estimatedleavingtime;
	private String availableseats;
	private String cartype;
	private String estimatedtotalcost;
	private String estimatedcostperpassenger;
	private String phone;
	private String memo;
	private String numberofappliedpassengers;
	private postasdriver newpost;
	private List<postasdriver> postlist;
	private List<user> driverlist;
	private int i;
	private String driverlicense;
	
	public String post() throws IOException{
		
		//connect database
		String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
		
		try{	
			email=(String)(ActionContext.getContext().getSession().get("email"));
			numberofappliedpassengers="0";
			System.out.println("email in pad="+email);
			System.out.println("departure in pad="+departure);
			System.out.println("destination in pad="+destination);
			System.out.println("ddate in pad="+departuredate);
			System.out.println("time in pad="+estimatedleavingtime);
			System.out.println("seats in pad="+availableseats);
			System.out.println("car in pad="+cartype);
			System.out.println("estimatedtotalcost in pad="+estimatedtotalcost);
			System.out.println("estimatedcostperpassenger in pad="+estimatedcostperpassenger);
			System.out.println("phone in pad="+phone);
			System.out.println("memo in pad="+memo);
			
			//check whether this driver has entered his driver license when registering. If not, forbid posting as driver!
			driverlist=session.selectList("selectuserbyemail", email);
			driverlicense=driverlist.get(0).getDriverlicense();
			
			if(driverlicense.equals("")){
			    JOptionPane.showMessageDialog(null,"As a driver, you didn't type your driver license when you registered. Please complete information fristly and then come back to post as driver. Thanks for your understanding!","Message",JOptionPane.ERROR_MESSAGE);
			    return "nopost";
			}
			
			else{
				//check estimated total cost
				String checkcost = "[0-9]+";
				Pattern regex = Pattern.compile(checkcost);
				java.util.regex.Matcher matcher = regex.matcher(estimatedtotalcost);
				boolean isMatched = matcher.matches();	
				
				//check estimated cost per passengre
				java.util.regex.Matcher matcher2 = regex.matcher(estimatedcostperpassenger);
				boolean isMatched2 = matcher2.matches();	
				
				//check phone number
				String checkphone = "[1-9][0-9]{9}";
				Pattern regex2 = Pattern.compile(checkphone);
				java.util.regex.Matcher matcher3 = regex2.matcher(phone);
				boolean isMatched3 = matcher3.matches();
				
				if(departuredate.equals("")||estimatedtotalcost.equals("")||estimatedcostperpassenger.equals("")){
					 JOptionPane.showMessageDialog(null,"Please fill required information!","Message",JOptionPane.ERROR_MESSAGE);
				}
				else if(departure.equals(destination)){
			    JOptionPane.showMessageDialog(null,"Departure and Destination can't be the same city!","Message",JOptionPane.ERROR_MESSAGE);
				}
			
				
				else if(!isMatched){
				    JOptionPane.showMessageDialog(null,"Estimated Total Cost should be numbers!","Message",JOptionPane.ERROR_MESSAGE);
			
				}
				
				else if(!isMatched2){
				    JOptionPane.showMessageDialog(null,"Estimated cost per passenger should be numbers!","Message",JOptionPane.ERROR_MESSAGE);
				   
				}
				
				else if(!phone.equals("")){
					if(!isMatched3){
						JOptionPane.showMessageDialog(null,"Phone Number should be 10 numeric digits!","Message",JOptionPane.ERROR_MESSAGE);		   
						 return "retype";
					}
					else {
						int res;
						res=JOptionPane.showConfirmDialog(null,"Are you sure you want to post this message?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(res==JOptionPane.YES_OPTION){
						
							//search table of postasdriver to set postID
							 postlist=new ArrayList<postasdriver>();
							 postlist=session.selectList("selectAllPostAsDriver");
							 if(postlist.size()==0){
								 i=0;
							 }
							 else{
								String s=postlist.get(postlist.size()-1).getPostID();
					            i=Integer.parseInt(s); 
							 }
							
							//insert new post as driver
							newpost=new postasdriver();
							newpost.setPostID(String.valueOf(i+1));;
							newpost.setEmail(email);
							newpost.setAvailableseats(availableseats);
							newpost.setCartype(cartype);
							newpost.setDeparture(departure);
							newpost.setDestination(destination);
							newpost.setDeparturedate(departuredate);
							newpost.setEstimatedcostperpassenger(estimatedcostperpassenger);
							newpost.setEstimatedtotalcost(estimatedtotalcost);
							newpost.setPhone(phone);
							newpost.setMemo(memo);
							newpost.setEstimatedleavingtime(estimatedleavingtime);
							newpost.setNumberofappliedpassengers(numberofappliedpassengers);
							
							 session.insert("insertpostasdriver",newpost);
						 	    session.commit();	
						 	   JOptionPane.showMessageDialog(null,"Posted Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
						return SUCCESS;
						}
						else{
							return "nopost";
						}
					}				   
				}
				
				
				
				
				else{
				//insert new post as driver
					int res;
					res=JOptionPane.showConfirmDialog(null,"Are you sure you want to post this message?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(res==JOptionPane.YES_OPTION){
					
						//search table of postasdriver to set postID
						 postlist=new ArrayList<postasdriver>();
						 postlist=session.selectList("selectAllPostAsDriver");
						 if(postlist.size()==0){
							 i=0;
						 }
						 else{
							String s=postlist.get(postlist.size()-1).getPostID();
				            i=Integer.parseInt(s); 
						 }
						
						//insert new post as driver
						newpost=new postasdriver();
						newpost.setPostID(String.valueOf(i+1));;
						newpost.setEmail(email);
						newpost.setAvailableseats(availableseats);
						newpost.setCartype(cartype);
						newpost.setDeparture(departure);
						newpost.setDestination(destination);
						newpost.setDeparturedate(departuredate);
						newpost.setEstimatedcostperpassenger(estimatedcostperpassenger);
						newpost.setEstimatedtotalcost(estimatedtotalcost);
						newpost.setPhone(phone);
						newpost.setMemo(memo);
						newpost.setEstimatedleavingtime(estimatedleavingtime);
						
						 session.insert("insertpostasdriver",newpost);
					 	    session.commit();	
					 	   JOptionPane.showMessageDialog(null,"Posted Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
					return SUCCESS;
					}
					else{
						return "nopost";
					}
				}
					return "retype";
			}
			
		}finally{
			session.close();
		}
		
	}
	
	public String cancel(){
		return "cancel";
	}
	
	
	
	
	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNumberofappliedpassengers() {
		return numberofappliedpassengers;
	}

	public void setNumberofappliedpassengers(String numberofappliedpassengers) {
		this.numberofappliedpassengers = numberofappliedpassengers;
	}
	public String getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(String availableseats) {
		this.availableseats = availableseats;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
