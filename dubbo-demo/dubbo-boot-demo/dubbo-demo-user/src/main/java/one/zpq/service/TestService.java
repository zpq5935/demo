package one.zpq.service;


import one.zpq.dubbodemo.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestService implements CommandLineRunner {

    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        RpcContext.getClientAttachment().setAttachment("clientKey1","clientValue1");
        String result = demoService.sayHello("world");
        System.out.println("Receive result ======> " + result);
    }
}
