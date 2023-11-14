package one.zpq.lb;

import one.zpq.request.BaseRequest;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class CustomLoadBalance implements LoadBalance {
    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {

        Object[] arguments = invocation.getArguments();
        if (Objects.isNull(arguments) || arguments.length != 1 || !(arguments[0] instanceof BaseRequest))
            return invokers.get(0);

        BaseRequest baseRequest = (BaseRequest) arguments[0];
        if(StringUtils.isEmpty(baseRequest.getGroupId()))
            return invokers.get(0);


        return invokers.get(baseRequest.getGroupId().hashCode() % invokers.size());
    }
}
