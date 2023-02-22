package one.zpq.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean("restTemplate")
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    @Bean("restTemplateLb")
    @LoadBalanced
    public RestTemplate initRestTemplateLb() {
        return new RestTemplate();
    }
}
