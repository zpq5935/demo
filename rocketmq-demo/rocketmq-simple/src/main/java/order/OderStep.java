package order;

import java.util.ArrayList;
import java.util.List;

public class OderStep {
    private String name;
    private String orderId;


    public List getOder() {
        List<OderStep> list = new ArrayList<>();

        OderStep  order = new OderStep();
        order.setName("创建订单");
        order.setOrderId("1001L");
        list.add(order);

        return list;
    }

    public String getName() {
        return name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
