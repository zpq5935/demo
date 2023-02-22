package one.zpq.dicmanager.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import one.zpq.dicmanager.dao.po.DicExplainPo;

import java.util.List;

@Data
@ApiModel("字典展示视图")
public class DicShowVo {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Integer id;
    /**
     * 单词拼写
     */
    @ApiModelProperty("单词拼写")
    private String spell;
    /**
     * 发音
     */
    @ApiModelProperty("发音")
    private String speak;
    /**
     * 例句
     */
    @ApiModelProperty("例句")
    private String example;
    /**
     * 关联单词id
     */
    @ApiModelProperty("关联单词id")
    private List<Integer> relaIds;
    /**
     * 单词释义
     */
    @ApiModelProperty("单词释义")
    private List<DicExplainPo> explains;

}
