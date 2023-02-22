package one.zpq.springbootdemo;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import one.zpq.service.TestService;

@SpringBootApplication
@RestController
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("one.zpq.springbootdemo.dao");
        return mapperScannerConfigurer;
    }

    @Bean
    public CommandLineRunner commandLineRunner(TestService testService) {
        return (args) -> {
            System.out.println(testService.getServiceName());
        };
    }

}
