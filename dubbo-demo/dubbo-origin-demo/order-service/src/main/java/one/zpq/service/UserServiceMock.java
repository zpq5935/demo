package one.zpq.service;

import lombok.extern.slf4j.Slf4j;
import one.zpq.request.UserListReq;
import one.zpq.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserServiceMock implements IUserService{
    @Override
    public UserVo selectById() {
        log.info("mock");
        return null;
    }

    @Override
    public List<UserVo> listUser(UserListReq userListReq) {
        log.info("mock");
        return new ArrayList<>();
    }

    @Override
    public void addUsers(List<UserVo> users) {
        log.info("mock");
    }
}
