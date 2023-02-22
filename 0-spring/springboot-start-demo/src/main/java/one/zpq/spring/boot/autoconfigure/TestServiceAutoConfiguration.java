package one.zpq.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import one.zpq.service.TestService;

@Configuration
@ConditionalOnProperty(prefix = "javastack.starter", name = "enabled", havingValue = "true")
public class TestServiceAutoConfiguration {

    @Bean
    public TestService testService() {
        return new TestService();
    }
}
