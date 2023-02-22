package one.zpq.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import one.zpq.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 14:01
 */
@Slf4j
public class UserServiceImpl implements IUserService {

    @Override
    public UserVo selectById() {
        return null;
    }

    @Override
    public List<UserVo> listUser() {
        System.out.println("userService in");
        List<UserVo> userVoList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            UserVo userVo = new UserVo();
            userVo.setId(String.valueOf(i));
            userVo.setName("name" + i);
            userVo.setAge(i);
            userVo.setSex((i % 2 == 0) ? 'M' : 'W');
            userVo.setCity("");
            userVoList.add(userVo);
        }
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("userService out");

        return userVoList;
    }

    @Override
    public void addUsers(List<UserVo> users) {
        log.info("入参:{}", JSON.toJSONString(users));
        users.forEach(System.out::println);
    }
}
