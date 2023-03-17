package rule;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class RulePeriod {
    Integer amount;// 数额
    Integer interval;// 阶段
    Integer point;

    public static void main(String[] args) {
        String jsonStr = JSONUtil.toJsonStr(Arrays.asList(new RulePeriod(100, 10, 10), new RulePeriod(500, 20, 30), new RulePeriod(1000, 30, 100)));
        System.out.println(jsonStr);
    }
}
