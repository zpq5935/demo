package one.zpq.dicmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.zpq.dicmanager.dao.DicDao;
import one.zpq.dicmanager.dao.po.DicPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test")
@Api(tags = "测试用接口")
public class TestController {

    @Autowired
    private DicDao dicDao;

    @GetMapping("hello")
    public String hello(String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }



    @ApiOperation("获取全部英语字典")
    @ResponseBody
    @GetMapping("getAllDic")
    public ResponseEntity getAllDic() {
        List<DicPo> dicPoList = dicDao.listAll();
        return ResponseEntity.ok(dicPoList);
    }


}
