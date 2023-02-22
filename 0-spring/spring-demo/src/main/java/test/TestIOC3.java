package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;
import org.xml.sax.InputSource;
import zpq.cycle.A;
import zpq.cycle.C;
import zpq.cycle.E;
import zpq.ref.Ref;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

public class TestIOC3 {
    @Test
    public void ttCycle() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextCycle.xml");
        A beanA = context.getBean(A.class);
        //
        System.out.println("用代理直接调");
        beanA.say();
        System.out.println("反射调，是否过代理对象");
        Method say = beanA.getClass().getDeclaredMethod("sayInner");
        say.setAccessible(true);
        say.invoke(beanA);

    }

    @Test
    public void testLoadSpringHandlers() throws IOException {
        String resourceName = "META-INF/spring.handlers";
        Properties props = new Properties();
        // 多个
//        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(resourceName);
//        while (urls.hasMoreElements()) {
//            URL url = urls.nextElement();
//            URLConnection con = url.openConnection();
//            InputStream is = con.getInputStream();
//            try {
//                if (resourceName.endsWith(".xml")) {
//                    props.loadFromXML(is);
//                } else {
//                    props.load(is);
//                }
//            } finally {
//                is.close();
//            }
//        }
        // 单个
        URL resource = Thread.currentThread().getContextClassLoader().getResource(resourceName);
        props.load(resource.openStream());
        // print
        props.list(System.out);
    }

}
