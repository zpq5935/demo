package test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import domain.Employee;
import factory.MySqlSessionFactory;
import mapper.EmployeeMapper;

public class testCache {
	
	private SqlSession sqlSession;
	
	@Test
	public void test033() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);
//		params.put("loginname", "jack");
//		params.put("password", "123");
		List<Employee> list = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee -> System.out.println(employee));
		//
		Employee employee = new Employee("nace","3312","ad","da",21,"dad",221.2,"dad");
		employeeMapper.insertEmployee(employee);
		//
		List<Employee> list2 = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee2 -> System.out.println(employee2));
		//
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void test02(){
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		//
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);
		List<Employee> list = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee -> System.out.println(employee));
		sqlSession.commit();
		//
		Employee employee = new Employee("nace","3312","ad","da",21,"dad",221.2,"dad");
		employeeMapper.insertEmployee(employee);
		//
		List<Employee> list2 = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee2 -> System.out.println(employee2));
		//
		
		sqlSession.close();
	}
	
	@Test
	public void test03(){
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		//
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);
		List<Employee> list = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee -> System.out.println(employee));
		sqlSession.close();
		//
		sqlSession = MySqlSessionFactory.getSqlSession();
		employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		List<Employee> list2 = employeeMapper.selectEmployeeLike(params);
		list.forEach(employee2 -> System.out.println(employee2));
		//
		
		sqlSession.close();
	}
}
