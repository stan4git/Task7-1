package action;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import javax.swing.JOptionPane;
import model.postaspassenger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class searchPassenger extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String departure;
	private String destination;
	private String departuredate;
	private String needseats;
	private postaspassenger p;
	private List<postaspassenger> postlist;



	public List<postaspassenger> searchlist() throws IOException{
		//connect database
		String resource = "orm/configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
		try{
			
			System.out.println("departure in searchPassenger="+departure);
			System.out.println("destination in searchPassenger="+destination);
			System.out.println("departuredate in searchPassenger="+departuredate);
			System.out.println("needseats in searchPassenger="+needseats);
			p=new postaspassenger();
			p.setNeedseats(needseats);
			p.setDeparture(departure);
			p.setDeparturedate(departuredate);
			p.setDestination(destination);
			
			postlist=session.selectList("searchPassenger",p);
			System.out.println("postlist size in searchPassenger="+postlist.size());
			
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
	
	public List<postaspassenger> getPostlist() {
		return postlist;
	}

	public void setPostlist(List<postaspassenger> postlist) {
		this.postlist = postlist;
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

	public String getNeedseats() {
		return needseats;
	}

	public void setNeedseats(String needseats) {
		this.needseats = needseats;
	}

	public postaspassenger getP() {
		return p;
	}

	public void setP(postaspassenger p) {
		this.p = p;
	}

	
}