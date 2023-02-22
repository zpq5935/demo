package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zpq.dao.UserDao;
import zpq.domain.User;
import zpq.domain.pNameSpace;
import zpq.service.UserService;

public class TestIoc {
    @Test
    public void tt() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao bean = context.getBean(UserDao.class);
		bean.add();
    }

    @Test
    public void tt2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServic = context.getBean(UserService.class);
        userServic.add();

    }

    @Test
    public void tt3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(((pNameSpace) context.getBean("demo2")).getName());
    }
}
