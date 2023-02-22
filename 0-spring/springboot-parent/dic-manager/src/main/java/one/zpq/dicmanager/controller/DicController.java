package one.zpq.dicmanager.controller;

import io.swagger.annotations.Api;
import one.zpq.dicmanager.controller.vo.DicShowVo;
import one.zpq.dicmanager.dao.DicDao;
import one.zpq.dicmanager.dao.po.DicPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dic")
@Api("字典管理接口")
public class DicController {

    @Autowired
    private DicDao dicDao;

    @GetMapping("listDics")
    public List<DicShowVo> listDics(DicShowVo dicShowVo){
        List<DicPo> dicPoList = dicDao.listAll();
        List<DicShowVo> dicShowVoList = new ArrayList<>();
        return dicShowVoList;
    }




}
