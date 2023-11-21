package one.zpq.service;

import com.alibaba.fastjson2.JSON;
import org.apache.dubbo.common.config.ReferenceCache;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.utils.SimpleReferenceCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GenericTask implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        GenericService genericService = buildGenericService("one.zpq.dubbodemo.dubbo.api.DemoService","","");
        //传入需要调用的方法，参数类型列表，参数列表
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"g1"});
        System.out.println("GenericTask Response: " + JSON.toJSONString(result));
    }

    private GenericService buildGenericService(String interfaceClass, String group, String version) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface(interfaceClass);
        reference.setVersion(version);
        //开启泛化调用
        reference.setGeneric("true");
        reference.setTimeout(30000);
        reference.setGroup(group);
        ReferenceCache cache = SimpleReferenceCache.getCache();
        try {
            return cache.get(reference);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
