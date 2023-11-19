package one.zpq.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.zpq.request.UserListReq;
import one.zpq.vo.UserVo;

@RequiredArgsConstructor
@Slf4j
public class UserServiceStub implements IUserService{

    private final IUserService userService;

    @Override
    public UserVo selectById() {
        log.info("stub");
        return userService.selectById();
    }

    @Override
    public List<UserVo> listUser(UserListReq userListReq) {
        log.info("stub");
        return userService.listUser(userListReq);
    }

    @Override
    public void addUsers(List<UserVo> users) {
        log.info("stub");
        userService.addUsers(users);
    }
}
