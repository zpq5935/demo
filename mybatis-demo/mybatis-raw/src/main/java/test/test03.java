package test;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import domain.Employee;
import factory.MySqlSessionFactory;
import mapper.EmployeeMapper;

public class test03 {

	private SqlSession sqlSession;

	@Test
	public void test01() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		HashMap<String, Object> params = new HashMap<String, Object>();
		 params.put("id", 1);
		List<Employee> list = employeeMapper.selectEmployeeByIdLike(params);
		list.forEach(employee -> System.out.println(employee));
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void test02() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		HashMap<String, Object> params = new HashMap<String, Object>();
		//params.put("id", 1);
		params.put("loginname", "jack");
		params.put("password", "123");
		List<Employee> list = employeeMapper.selectEmployeeChoose(params);
		list.forEach(employee -> System.out.println(employee));
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test033() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);
		//params.put("loginname", "jack");
		//params.put("password", "123");
		List<Employee> list = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee -> System.out.println(employee));
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
