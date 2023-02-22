package one.zpq;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Iou {
    private int id;
    private String userId;
    private BigDecimal balance;
}

