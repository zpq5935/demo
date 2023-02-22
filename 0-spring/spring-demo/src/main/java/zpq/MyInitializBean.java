package zpq;

import org.springframework.beans.factory.InitializingBean;

public class MyInitializBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
