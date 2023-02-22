package one.zpq.controller;

import one.zpq.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 15:29
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;


    @GetMapping
    public String addOrder() {
        orderService.listUsers();
        return "ok";
    }
}
