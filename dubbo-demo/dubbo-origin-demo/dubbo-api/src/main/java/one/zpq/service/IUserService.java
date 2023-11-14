package one.zpq.service;

import one.zpq.request.UserListReq;
import one.zpq.vo.UserVo;

import java.util.List;

/**
 * 用户服务
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 14:01
 */
public interface IUserService {
    UserVo selectById();

    List<UserVo> listUser(UserListReq userListReq);

    void addUsers(List<UserVo> users);
}
