package one.zpq.router;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.cluster.Router;
import org.apache.dubbo.rpc.cluster.RouterFactory;

public class CustomRouterFactory implements RouterFactory {


    @Override
    public Router getRouter(URL url) {
        return new CustomRouter();
    }
}
