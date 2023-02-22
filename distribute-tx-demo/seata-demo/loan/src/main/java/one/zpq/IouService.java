package one.zpq;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IouService {
    @Autowired
    IouMapper loanMapper;

    @Autowired
    AccountFeign accountFeign;

    @GlobalTransactional
    public BigDecimal updateBalance(String userId, BigDecimal repayAmount, boolean error) {
        Iou iou = loanMapper.selectByUserId(userId);
        BigDecimal balance = iou.getBalance().subtract(repayAmount);//还款后，借据余额减少
        iou.setBalance(balance);
        loanMapper.updateBalance(iou);
        //
        accountFeign.test(repayAmount, userId, error);
        return balance;
    }
}
