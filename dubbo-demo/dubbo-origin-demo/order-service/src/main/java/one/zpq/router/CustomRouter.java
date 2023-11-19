package one.zpq.router;

import java.util.List;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.router.AbstractRouter;
import org.springframework.util.CollectionUtils;

public class CustomRouter extends AbstractRouter {

    @Override
    public <T> List<Invoker<T>> route(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        if(CollectionUtils.isEmpty(invokers))
            return invokers;

        return invokers.subList(0,1);
    }

}
