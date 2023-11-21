package one.zpq.dubbodemo.dubbo.service;

import com.alibaba.fastjson2.JSON;
import one.zpq.dubbodemo.dubbo.api.DemoService;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.Map;

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        Map<String, Object> serverAttachments = RpcContext.getServerAttachment().getObjectAttachments();
        System.out.println("ContextService serverAttachments:" + JSON.toJSONString(serverAttachments));
        return "Hello " + name;
    }
}