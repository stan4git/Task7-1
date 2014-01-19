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

public class postAsPassenger extends ActionSupport{
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
	private String needseats;
	private String expectedcartype;
	private String expectedcost;
	private String phone;
	private String memo;
	private String numberofapplieddrivers;
	private postaspassenger newpost;
	private List<postaspassenger> postlist;
	private int i;
	
	
	public String post() throws IOException{
	
		//connect database
		 String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
		
	
			try{
				//get user's email	
				email=(String)(ActionContext.getContext().getSession().get("email"));
				numberofapplieddrivers="0";
				System.out.println("email in pap="+email);
				System.out.println("departure in pap="+departure);
				System.out.println("destination in pap="+destination);
				System.out.println("date in pap="+departuredate);
				System.out.println("time in pap="+estimatedleavingtime);
				System.out.println("seats in pap="+needseats);
				System.out.println("expectedcartype in pap="+expectedcartype);
				System.out.println("expectedcost in pap="+expectedcost);
				System.out.println("phone in pad="+phone);
				System.out.println("memo in pad="+memo);
				
				
				
				//check expected cost
				String checkcost = "[0-9]+";
				Pattern regex = Pattern.compile(checkcost);
				java.util.regex.Matcher matcher = regex.matcher(expectedcost);
				boolean isMatched = matcher.matches();	
				
				//check phone number
				String checkphone = "[1-9][0-9]{9}";
				Pattern regex2 = Pattern.compile(checkphone);
				java.util.regex.Matcher matcher2 = regex2.matcher(phone);
				boolean isMatched2 = matcher2.matches();
				
				if(departuredate.equals("")||expectedcost.equals("")){
					 JOptionPane.showMessageDialog(null,"Please fill required information!","Message",JOptionPane.ERROR_MESSAGE);
					 return "retype";
				}
				else if(departure.equals(destination)){
			    JOptionPane.showMessageDialog(null,"Departure and Destination can't be the same city!","Message",JOptionPane.ERROR_MESSAGE);
			    return "retype";
				}

				else if(!isMatched){
				    JOptionPane.showMessageDialog(null,"Expected Cost should be numbers!","Message",JOptionPane.ERROR_MESSAGE);
				    return "retype";
				}
				
				//if the phone number is not null, insert new post
				else if(!phone.equals("")){
					if(!isMatched2){
						JOptionPane.showMessageDialog(null,"Phone Number should be 10 numeric digits!","Message",JOptionPane.ERROR_MESSAGE);		   
						 return "retype";
					}
					else {
						int res;
						res=JOptionPane.showConfirmDialog(null,"Are you sure you want to post this message?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(res==JOptionPane.YES_OPTION){
						
							//search table of postaspassenger to set postID
							 postlist=new ArrayList<postaspassenger>();
							 postlist=session.selectList("selectAllPostAsPassenger");
							 if(postlist.size()==0){
								 i=0;
							 }
							 else{
								String s=postlist.get(postlist.size()-1).getPostID();
					            i=Integer.parseInt(s); 
							 }
							
							//insert new post as driver
							newpost=new postaspassenger();
							newpost.setPostID(String.valueOf(i+1));;
							newpost.setEmail(email);
							newpost.setNeedseats(needseats);
							newpost.setExpectedcartype(expectedcartype);
							newpost.setDeparture(departure);
							newpost.setDestination(destination);
							newpost.setDeparturedate(departuredate);
							newpost.setExpectedcost(expectedcost);
							newpost.setPhone(phone);
							newpost.setMemo(memo);
							newpost.setEstimatedleavingtime(estimatedleavingtime);
						    newpost.setNumberofapplieddrivers(numberofapplieddrivers);

							
							 session.insert("insertpostaspassenger",newpost);
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
					//insert new post
					int res;
					res=JOptionPane.showConfirmDialog(null,"Are you sure you want to post this message?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(res==JOptionPane.YES_OPTION){
					
						//search table of postasdriver to set postID
						 postlist=new ArrayList<postaspassenger>();
						 postlist=session.selectList("selectAllPostAsPassenger");
						 if(postlist.size()==0){
							 i=0;
						 }
						 else{
							String s=postlist.get(postlist.size()-1).getPostID();
				            i=Integer.parseInt(s); 
						 }
						
						//insert new post as driver
						newpost=new postaspassenger();
						newpost.setPostID(String.valueOf(i+1));;
						newpost.setEmail(email);
						newpost.setNeedseats(needseats);
						newpost.setExpectedcartype(expectedcartype);
						newpost.setDeparture(departure);
						newpost.setDestination(destination);
						newpost.setDeparturedate(departuredate);
						newpost.setExpectedcost(expectedcost);
						newpost.setPhone(phone);
						newpost.setMemo(memo);
						newpost.setEstimatedleavingtime(estimatedleavingtime);
						
						 session.insert("insertpostaspassenger",newpost);
					 	    session.commit();	
					 	   JOptionPane.showMessageDialog(null,"Posted Successfully!","Message",JOptionPane.INFORMATION_MESSAGE);
					return SUCCESS;
					}
					else{
						return "nopost";
					}
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
	public postaspassenger getNewpost() {
		return newpost;
	}
	public void setNewpost(postaspassenger newpost) {
		this.newpost = newpost;
	}
	
	
	
}
