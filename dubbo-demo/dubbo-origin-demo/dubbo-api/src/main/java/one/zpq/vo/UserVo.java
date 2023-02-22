package one.zpq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserVo
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 14:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable {
    private static final long serialVersionUID = 6133351843272288475L;
    private String id;
    private String name;
    private Integer age;
    private String address;
    private Character sex;
    private String city;


}
