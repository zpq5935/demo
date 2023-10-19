package one.zpq.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthFilter extends ZuulFilter {
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
        RequestContext ctx = RequestContext.getCurrentContext();
        String authorization = ctx.getRequest().getHeader("Authorization");
        if (StringUtils.isBlank(authorization)) {
            rsp(ctx, 401, "need auth");
            ctx.setSendZuulResponse(false);
        }
        return null;
    }

    private void rsp(RequestContext ctx, int code, String message) {
        Map<String, Object> rsp = new HashMap<>();
        rsp.put("code", code);
        rsp.put("message", message);
        HttpServletResponse response = ctx.getResponse();
        response.setContentType("application/json;charset=utf-8");
        try {
            ctx.setResponseBody(new ObjectMapper().writeValueAsString(rsp));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            ctx.setResponseBody("internal error");
        }
    }

}
