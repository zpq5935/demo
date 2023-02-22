package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import domain.Employee;
import factory.MySqlSessionFactory;
import mapper2.EmployeeMapper;

public class testDynaAnnotation {
	private SqlSession sqlSession;
	
	@Test
	public void test01() {
		sqlSession = MySqlSessionFactory.getSqlSession();
		EmployeeMapper employeeMapper= sqlSession.getMapper(EmployeeMapper.class);
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("loginname","jack");
		param.put("password", "123");
		List<Employee> list = employeeMapper.selectWhitParam(param);
		System.out.println(list);
		sqlSession.close();
		
	}
}
