package one.zpq.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @HystrixCommand(
            fallbackMethod = "error",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),// 执行超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 检测断路的窗口内最低请求数，超过此数值的请求才会检测失败百分比以及后续的断路
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),// 达到断路的失败百分比
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7"),// 达到断路后 单位时间内允许单个请求检测服务是否恢复正常的周期（秒）
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),// 检测问题的窗口大小（毫秒）
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5"),// 单个窗口内的统计次数
            }
    )
    @GetMapping("hello")
    public String hello(@RequestParam(required = false) Long time) throws InterruptedException {
        System.out.println("in");
        if (time != null) Thread.sleep(time);
        return "hello1";
    }

    /**
     * 测试Feign接口
     *
     * @return
     */
    @HystrixCommand
    @GetMapping("testFeign")
    public String testFeign(String name) throws InterruptedException {
        Thread.sleep(RandomUtils.nextInt());
        return "this is port" + port + "testFeign," + name;
    }

    public String error(Long time) {
        return new String("异常，自定义");
    }
}
