package one.zpq.dicmanager.dao.po;

import lombok.Data;

@Data
public class DicExplainPo {
    private Integer n_dic_id;
    /**
     * 解释类型，eg: n、vi、vt、adj、adv
     */
    private String type;
    /**
     * 解释描述
     */
    private String desc;
}
