package rule;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class RuleContinu {
    Integer day;
    Integer point;

    public static void main(String[] args) {
        String jsonStr = JSONUtil.toJsonStr(Arrays.asList(new RuleContinu(3, 10), new RuleContinu(5, 30), new RuleContinu(7, 50)));
        System.out.println();
    }
}
