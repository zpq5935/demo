package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zpq.domain.User;
import zpq.service.UserService;

public class TestIoc2 {
	@Test
	public void tt1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		User user = (User) context.getBean("user2");
		System.out.println(user);
		user.add();
	}

	@Test
	public void tt2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		UserService userService = context.getBean(UserService.class);
		userService.add();
	}

	
}
