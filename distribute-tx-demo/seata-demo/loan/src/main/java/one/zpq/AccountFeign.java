package one.zpq;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-demo-account")
public interface AccountFeign {

    @GetMapping("/account/repayment/add")
    public String test(@RequestParam BigDecimal money, @RequestParam String userId,@RequestParam  boolean error);
}
