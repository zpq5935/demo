package one.zpq.dicmanager.dao.po;

import lombok.Data;

@Data
public class DicRelaDao {
    /**
     * 主关联词
     */
    private Integer dicIdMain;
    /**
     * 被关联词
     */
    private Integer dicIdSlave;
}
