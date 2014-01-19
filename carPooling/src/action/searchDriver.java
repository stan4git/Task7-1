package action;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.postasdriver;

import com.opensymphony.xwork2.ActionSupport;

public class searchDriver extends ActionSupport{
private String departure;
private String destination;
private String departuredate;
private String availableseats;
private postasdriver p;

public postasdriver getP() {
	return p;
}

public void setP(postasdriver p) {
	this.p = p;
}

public List<postasdriver> searchlist() throws IOException{
	//connect database
	String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
	try{
		
		System.out.println("departure in searchDriver="+departure);
		System.out.println("destination in searchDriver="+destination);
		System.out.println("departuredate in searchDriver="+departuredate);
		System.out.println("availableseats in searchDriver="+availableseats);
		p=new postasdriver();
		p.setAvailableseats(availableseats);
		p.setDeparture(departure);
		p.setDeparturedate(departuredate);
		p.setDestination(destination);
		
		postlist=session.selectList("searchDriver",p);
		System.out.println("postlist size="+postlist.size());
		
		return postlist;

	}finally{
		session.close();
	}
	
}

public String search() throws IOException{
	if(departuredate.equals("")){
        JOptionPane.showMessageDialog(null,"Please choose departure date","Message",JOptionPane.WARNING_MESSAGE);
        return "rechoose";
	}
	if(departure.equals(destination)){
		 JOptionPane.showMessageDialog(null,"Departure and Destination can not be the same city!","Message",JOptionPane.ERROR_MESSAGE);
	        return "rechoose";
	}
	else{
		searchlist();
	}
	return SUCCESS;
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

public String getAvailableseats() {
	return availableseats;
}

public void setAvailableseats(String availableseats) {
	this.availableseats = availableseats;
}

public List<postasdriver> getPostlist() {
	return postlist;
}

public void setPostlist(List<postasdriver> postlist) {
	this.postlist = postlist;
}

	private List<postasdriver> postlist;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
