package one.zpq.dicmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("hello")
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping
    public String zpq() {
        return "hello zpq;";
    }
}
