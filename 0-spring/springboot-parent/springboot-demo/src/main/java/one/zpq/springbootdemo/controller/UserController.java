package one.zpq.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import one.zpq.springbootdemo.domain.Customer;
import one.zpq.springbootdemo.exception.NotFoundException;

@Controller
public class UserController {

    /**
     * 跳转页面
     * 
     * @return
     */
    @RequestMapping("head/page")
    public String page() {
        return "testHttpHead";
    }

    /**
     * 
     * @param id
     * @return
     */
    @PostMapping("head/getCustomer")
    @ResponseBody
    public Customer getCustomer(@RequestHeader("id") Integer id) {
        Customer customer = new Customer();
        customer.setId(Integer.valueOf(id));
        customer.setNickname("zpq");
        return customer;
    }
    
    @GetMapping("controller/advice")
    public String testControllerAdvice(){
        throw new NotFoundException("500", "测试testControllerAdvice");
    }
}
