package one.zpq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("hello")
    public String hello() {
        return "hello1";
    }

    /**
     * 测试Feign接口
     *
     * @return
     */
    @GetMapping("testFeign")
    public String testFeign(String name) {
        return "this is port" + port + "testFeign," + name;
    }

    public String error() {
        return new String("异常，自定义");
    }
}
