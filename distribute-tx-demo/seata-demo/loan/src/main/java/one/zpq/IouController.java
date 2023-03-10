package one.zpq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class IouController {
    @Autowired
    IouService iouService;



    @RequestMapping("/loan/iou/test")
    public String test(String name,boolean error) {
        String userId = "1001";
        BigDecimal amount = new BigDecimal(1234.1234);
        iouService.updateBalance(userId, amount,error);

        return "hello, " + name;
    }
}