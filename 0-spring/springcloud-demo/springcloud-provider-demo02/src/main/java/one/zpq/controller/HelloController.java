package one.zpq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hello")
    public String hello() {
        return "hello2";
    }

    @GetMapping("testFeign")
    public String testFeign(String name) {
        return "this is port" + port + "testFeign," + name;
    }
}
