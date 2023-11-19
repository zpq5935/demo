package one.zpq.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import one.zpq.request.UserListReq;
import one.zpq.vo.AccountInput;
import one.zpq.vo.UserVo;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.rpc.Constants;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhangchaopei
 * @version 1.0
 * @date 2020-9-19 15:23
 */
@Service
@Slf4j
public class OrderServiceImpl {
//    @DubboReference
    @Autowired
    private IUserService userService;
    @Autowired
    private AccountService accountService;

    /**
     * 223
     *
     * @explain:123
     */
    public void listUsers() {
        UserListReq userListReq = new UserListReq();
        userListReq.setGroupId("test");


        RpcContext.getContext().setAttachment(Constants.FORCE_USE_TAG,"true");
        RpcContext.getContext().setAttachment(CommonConstants.TAG_KEY,"test");
        List<UserVo> userVoList = userService.listUser(userListReq);
        userVoList.forEach(System.out::println);

        accountService.listAccount(new AccountInput());
    }

    public void addUsers() {
        List<UserVo> userVoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserVo userVo = new UserVo();
            userVo.setId(String.valueOf(i));
            userVo.setName("name" + i);
            userVo.setAge(i);
            userVo.setSex((i % 2 == 0) ? 'M' : 'W');
            userVo.setCity("");
            userVoList.add(userVo);
        }
        log.info("入参:{}", JSON.toJSONString(userVoList));
        userService.addUsers(userVoList);
    }
}
