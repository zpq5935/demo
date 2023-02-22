package one.zpq.springbootdemo;

import freemarker.template.TemplateException;
import one.zpq.springbootdemo.domain.User;
import one.zpq.springbootdemo.util.FreeMarkerUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-12-16 13:14
 */
public class FreeMarkerUtilTest {
    @Test
    public  void t1() throws IOException, TemplateException {
        Map dataMap = new HashMap<>();
        dataMap.put("name", "itdragon博客");
        dataMap.put("dateTime", new Date());

        List<User> users = new ArrayList<User>();
        users.add(new User(1, "ITDragon 博客"));
        users.add(new User(2, "欢迎"));
        users.add(new User(3, "You！"));
        dataMap.put("users", users);
        FreeMarkerUtil.process(System.out,"src/main/resources/templates","stringFreeMarker.ftl",dataMap);
    }
}
