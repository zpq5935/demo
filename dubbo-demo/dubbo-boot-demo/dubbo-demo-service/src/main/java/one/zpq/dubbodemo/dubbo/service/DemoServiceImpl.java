package one.zpq.dubbodemo.dubbo.service;

import com.alibaba.fastjson2.JSON;
import one.zpq.dubbodemo.dubbo.api.DemoService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.Map;

@DubboService
public class DemoServiceImpl implements DemoService {

    private final Log log = LogFactory.getLog(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        Map<String, Object> serverAttachments = RpcContext.getServerAttachment().getObjectAttachments();
        log.info("ContextService serverAttachments:" + JSON.toJSONString(serverAttachments));
        return "Hello " + name;
    }
}