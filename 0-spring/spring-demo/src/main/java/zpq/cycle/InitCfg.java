package zpq.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import javax.annotation.PostConstruct;

public class InitCfg implements InitializingBean, BeanPostProcessor {

    public void init() {
        System.out.println("init");

    }

    @PostConstruct
    public void PostConstruct() {
        System.out.println("PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("[-->before]%s==%s", beanName, bean.getClass()));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("[<--after]%s==%s", beanName, bean.getClass()));

        return bean;
    }

}
