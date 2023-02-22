package one.zpq.dicmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("view")
@Api("视图跳转")
@Controller
public class ViewController {

    @GetMapping("to")
    @ApiOperation("根页面跳转")
    public String toIndex(String viewName) {
        return StringUtils.isBlank(viewName) ? "index" : viewName;
    }

    @GetMapping("toDic")
    @ApiOperation("字典页面跳转")
    public String to(String viewName) {
        return "dic/" + viewName;
    }
}
