package one.zpq.springsecurity.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("testAuthorize")
    @PreAuthorize("hasRole('ADMIN')")
    public String testAuthorize() {
        System.out.println("testAuthorize");
        return "testAuthorize";
    }
}
