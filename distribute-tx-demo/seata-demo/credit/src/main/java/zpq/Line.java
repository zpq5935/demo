package zpq;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Line {
    private String userId;
    private BigDecimal limitAccount;
    private BigDecimal balance;
}

