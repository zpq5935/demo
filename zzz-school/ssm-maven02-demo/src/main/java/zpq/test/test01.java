package zpq.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import zpq.dao.MySqlSession;
import zpq.domain.Student;

public class test01 {
	
	@Test
	public void test01(){
		SqlSession sqlSession = MySqlSession.getSqlSession();
		Student stu = sqlSession.selectOne("mapper.StudentMapper.selectStudent");
		if( stu!=null)
			System.out.println(stu);
		else System.out.println("查无此人！！！");
	}
}
