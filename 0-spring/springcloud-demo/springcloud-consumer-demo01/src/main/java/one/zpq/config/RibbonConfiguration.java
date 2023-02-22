package one.zpq.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {
    @Bean
    public IRule initRibbonRule(){
        return new RandomRule();
    }
}
