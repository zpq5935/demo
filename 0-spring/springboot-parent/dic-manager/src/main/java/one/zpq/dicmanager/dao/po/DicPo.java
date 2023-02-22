package one.zpq.dicmanager.dao.po;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import java.util.List;

@Data
public class DicPo {
    /**
     * '主键'
     */
    private Integer id;
    /**
     * 单词拼写
     */
    private String spell;
    /**
     * 发音
     */
    private String speak;
    /**
     * 例句
     */
    private String example;

}
