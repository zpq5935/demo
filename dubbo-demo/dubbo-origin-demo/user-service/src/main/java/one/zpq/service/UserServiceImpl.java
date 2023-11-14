package one.zpq.service;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import one.zpq.request.UserListReq;
import one.zpq.vo.UserVo;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @SneakyThrows
    @Override
    public List<UserVo> listUser(UserListReq userListReq) {
        log.info("userService in");
        Thread.sleep(1000);
        List<UserVo> userVoList = new ArrayList<>(10);
        loadUsers(userVoList);

        userVoList = filter(userListReq, userVoList);

        log.info("userService out");

        return userVoList;
    }

    private List<UserVo> filter(UserListReq userListReq, List<UserVo> userVoList) {
        if(Objects.isNull(userListReq) || StringUtils.isEmpty(userListReq.getName()) || CollectionUtils.isEmpty(userVoList))
            return userVoList;

        return userVoList.stream().filter(userVo -> !StringUtils.isEmpty(userVo.getName()) && userVo.getName().contains(userListReq.getName()))
                .collect(Collectors.toList());

    }

    private static void loadUsers(List<UserVo> userVoList) {
        for (int i = 0; i < 10; i++) {
            UserVo userVo = new UserVo();
            userVo.setId(String.valueOf(i));
            userVo.setName("name" + i);
            userVo.setAge(i);
            userVo.setSex((i % 2 == 0) ? 'M' : 'W');
            userVo.setCity("");
            userVoList.add(userVo);
        }
    }

    @Override
    public void addUsers(List<UserVo> users) {
        log.info("入参:{}", JSON.toJSONString(users));
        users.forEach(System.out::println);
    }
}
