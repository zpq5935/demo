package one.zpq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import one.zpq.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {


    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("restTemplateLb")
    private RestTemplate restTemplateLb;

    // 测试feign
    @Autowired
    private HelloService helloService;

    // 服务地址
    private String url = "http://localhost:8081/";
    // 测试ribbon客户端负载均衡
    private String urlLb = "http://provider/";

    /**
     * 简单测试
     *
     * @return
     */
    @GetMapping("hello")
    public String hello() {
        String result = "def";
        try {
            result = restTemplate.getForObject(url + "hello", String.class).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 测试负载均衡
     *
     * @return
     */
    @GetMapping("testLb")
    public String testLb() {
        String result = "def";
        try {
            result = restTemplateLb.getForObject(urlLb + "hello", String.class).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 测试feign
     *
     * @return
     */
    @GetMapping("testFeign")
    public String testFeign(String name) {
        String result = "def";
        try {
            result = helloService.hello(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("test_hystrix")
    public String testHystrix(Integer secondeCount) throws InterruptedException {
        Thread.sleep(secondeCount);
        String result = "def";
        try {
            result = "receive time:" + secondeCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public String fallback(Integer secondeCount) throws InterruptedException {
        String result = "已执行fallback 后备策略";
        System.out.println(result);
        return result;
    }
}
