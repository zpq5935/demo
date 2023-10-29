package one.zpq.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;


@Component
public class ResponseFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
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
        String uuid = RequestContext.getCurrentContext().getZuulRequestHeaders().get("uuid");
        RequestContext.getCurrentContext().addZuulResponseHeader("uuid", uuid);
        return null;
    }
}
