package test;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import model.postaspassenger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
public class testPostAsPassenger {
@Test
    public void testMybatis() throws IOException{
		
    	String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		try{
			List<postaspassenger> posts = session.selectList("selectAllPostAsPassenger");
			 for (postaspassenger u: posts) {  
				 	System.out.println("Email:"+u.getEmail());
				 	
			 	System.out.println("===================");  
		        }  
		}finally{
			session.close();
		}
    }	

}