package one.zpq.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TraceFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        RequestContext.getCurrentContext().addZuulRequestHeader("uuid", uuid);
        return null;
    }
}
