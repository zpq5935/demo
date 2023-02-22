package zpq.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSession {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static{
		try{
			InputStream in = Resources.getResourceAsStream("mybatis-config2.xml");
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession(){
		if(sqlSessionFactory!=null)
		return sqlSessionFactory.openSession();
		return null;
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory!=null)
		return sqlSessionFactory;
		return null;
	}
	
}
