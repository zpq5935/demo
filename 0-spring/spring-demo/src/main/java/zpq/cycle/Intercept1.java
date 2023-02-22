package zpq.cycle;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

//@Component
public class Intercept1 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("intercept-before");
        Object proceed = invocation.proceed();
        System.out.println("\t" + invocation);
        System.out.println("intercept-after");

        return proceed;
    }
}
