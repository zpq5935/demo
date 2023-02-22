package zpq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class LineController {

    @Autowired
    LineMapper lineMapper;

    @RequestMapping("/credit/line/add")
    public String test(BigDecimal money) {
        Line re = new Line();
        lineMapper.add(re);
        return "hello, " + money;
    }
}