package one.zpq;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Account {
    private String userId;
    private Date repayDate;
    private BigDecimal repayAmount;
}

