package zpq.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zpq.dao.StudentMapper;
import zpq.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class testService {
	
	@Autowired
	StudentMapper stuMapper;
	
	
	@Test
	public void test02(){
		
		if( stuMapper == null){
			System.out.println("stuMapper 为空！");
			return;
		}
		Student stu = stuMapper.selectStudent();
		if( stu!=null)
			System.out.println(stu);
		else 
			System.out.println("查无此人！！！");
	}
	
	@Test
	public void test023() {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentMapper stuMapper2 = ioc.getBean(StudentMapper.class);
		System.out.println(stuMapper2);
		if( stuMapper2 == null){
			System.out.println("stuMapper2 为空！");
			return;
		}
		Student stu = stuMapper2.selectStudent();
		if( stu!=null)
			System.out.println(stu);
		else 
			System.out.println("查无此人！！！");
	}
}
