//package one.zpq.service;
//
//import one.zpq.vo.UserVo;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 用户服务
// *
// * @author zhangchaopei
// * @version 1.0
// * @date 2020-9-19 14:01
// */
//@Path("user")
//public class UserServiceRestImpl implements IUserService {
//
//    @Override
//    public UserVo selectById() {
//        return null;
//    }
//
//    @Path("list")
//    @GET
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//    @Override
//    public List<UserVo> listUser() {
//        System.out.println("userService in");
//        List<UserVo> userVoList = new ArrayList<>(10);
//        for (int i = 0; i < 10; i++) {
//            UserVo userVo = new UserVo(String.valueOf(i), "name" + i, i, "address" + i, (i % 2 == 0) ? 'M' : 'W');
//            userVoList.add(userVo);
//        }
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("userService out");
//
//        return userVoList;
//    }
//}
