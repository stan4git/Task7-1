package test;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import model.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
public class testUser {
@Test
    public void testMybatis() throws IOException{
		
    	String resource = "orm/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		try{
			//List<Employee> employees = session.selectList("selectAllEmployee");
			List<user> users = session.selectList("selectAllUser");
			 for (user u: users) {  
				 	System.out.println("Email:"+u.getEmail());
				 	System.out.println("Name:"+u.getName());
				 	System.out.println("PW:"+u.getPassword());
				 	System.out.println("Sex:"+u.getSex());
			 	System.out.println("===================");  
		        }  
		}finally{
			session.close();
		}
    }	

}