package test;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import domain.Person;
import factory.MySqlSessionFactory;
import mapper.CardMapperAnnotation;
import mapper.ClazzMapperAnnotation;
import mapper.PersonMapperAnnotation;
import mapper.UserMapperAnnotation;
import pojo.Clazz;
import pojo.User;

public class testAnnotation {

	private SqlSession sqlSession;
	
	@Test
	public void testSelectAll() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		UserMapperAnnotation userMapper2 = sqlSession.getMapper(UserMapperAnnotation.class);
		List<User> list = userMapper2.selectAll();
		list.forEach(user->System.out.println(user));
		//
		sqlSession.close();
	}
	
	@Test
	public void testSelectOne() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		UserMapperAnnotation userMapper2 = sqlSession.getMapper(UserMapperAnnotation.class);
		User user = userMapper2.selectOneUser(40);
		//
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void testInsert(){
		sqlSession = MySqlSessionFactory.getSqlSession();
		UserMapperAnnotation userMapper2 = sqlSession.getMapper(UserMapperAnnotation.class);
		User user =  new User("tomaa","男",16);
		userMapper2.saveUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	/*
	 * 测试一对一
	 */
	@Test
	public void testOneToOne(){
		sqlSession = MySqlSessionFactory.getSqlSession();
		PersonMapperAnnotation personMapperAnnotation = sqlSession.getMapper(PersonMapperAnnotation.class);
		Person person = personMapperAnnotation.selectPersonById(1);
		System.out.println(person);
		System.out.println(person.getCard_id());
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testOneToMany(){
		sqlSession = MySqlSessionFactory.getSqlSession();
		ClazzMapperAnnotation clazzMapperAnnotation = sqlSession.getMapper(ClazzMapperAnnotation.class);
		Clazz clazz = clazzMapperAnnotation.selectById(1);
		System.out.println(clazz);
		clazz.getStudents().forEach(stu->System.out.println(stu));
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}