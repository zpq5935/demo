package one.zpq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
public class AccountController {

    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("/account/repayment/add")
    public String test(BigDecimal money,String userId,boolean error) {
        if(error){
            throw new RuntimeException("err");
        }
        Account account = new Account();
        account.setUserId(userId);
        account.setRepayAmount(money);
        account.setRepayDate(new Date());
        accountMapper.addRepayment(account);
        return "hello, " + money;
    }
}