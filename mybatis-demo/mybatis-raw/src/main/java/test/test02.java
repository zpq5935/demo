package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import domain.Person;
import factory.MySqlSessionFactory;
import mapper.PersonMapper;

public class test02 {

	private SqlSession sqlSession ;
	
	@Test
	public void test01(){
		try{
			sqlSession = MySqlSessionFactory.getSqlSession();
			PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
//			Person person = sqlSession.selectOne("mapper.PersonMapper.selectPersonById",1);
			Person person = personMapper.selectPersonById(1);
			System.out.println(person);
			System.out.println(person.getCard_id());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.commit();
			sqlSession.close();
		}				
	}
	
	
	
	
	
	
	
	
	
}
