package zpq.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import zpq.domain.Student;

public class test_mybatis {
	
	@Test
	public void test01(){
		SqlSession session = MySqlsessionFactory.getSqlSession();
		Student student = session.selectOne("zpq.dao.StudentMapper.selectStudent");
		if(student!=null)
				System.out.println(student);
		else {
			System.out.println("无纪律");
		}
	}
}
