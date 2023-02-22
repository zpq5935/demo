package one.zpq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 15:17
 */
public class UserApplication {
    public static void main(String[] args) {

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("dubbo.xml");
            System.out.println("Started");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
