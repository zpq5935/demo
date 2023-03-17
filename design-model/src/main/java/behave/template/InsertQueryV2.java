package behave.template;

/**
 * 模板方法模式<br>
 * 对于一个功能，其历程骨架已经定下来了，但其中某些步骤需要具体环境具体分析，这些方法需要延迟到子类实现
 * 
 * @author 22517
 *
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * 指定位置插入查询 v2
 */
@NoArgsConstructor
public abstract class InsertQueryV2<Entity>  {

    /**
     * 返回分页信息及改页的ids
     *
     */
    public Page<String> query(Page<Entity> page) {

        int strictLimit = getStrictLimit();

        // 本次分页开始位置
        long beginPos = (page.getCurrent()-1) * page.getSize()+1;
        long endPos = page.getSize() * page.getCurrent();

        // 1、根据分页查出原数据
        Page<String> rawPage = getRawPageData(page);
        List<String> rawRecords = rawPage.getRecords();
        rawRecords = Lists.newLinkedList(rawRecords);
        if (beginPos <= strictLimit) {// 补数据
            // 0、挤出的数据
            List<String> extrudedIds = getExtrudedIds(page);
            // 补充数据
            rawRecords.addAll(0, extrudedIds);
        }

        // 2、查询该范围的广告数据
        List<Advertise> advertiseData = getAdvertiseData(page);

        // 3、插入广告
        BiConsumer<List<String>, List<Advertise>> advertiseInsert = advertiseInsert();
        if (null != advertiseInsert) {
            advertiseInsert.accept(rawRecords, advertiseData);
        } else {
            for (Advertise advertise : advertiseData) {
                int insertIndex = (int) (advertise.getSort() % page.getSize()) ;
                insertIndex = (insertIndex == 0) ? (int)(page.getSize() - 1) : insertIndex;// 整除
                insertIndex = Math.min(insertIndex, rawRecords.size());// 大于size
                insertIndex = rawRecords.size() == 0 ? 1 : insertIndex;// size==0
                rawRecords.add(insertIndex-1, advertise.getId());
            }
        }

        // 4、多出每页数据，丢弃（若直接返回存在往后的数据占了位置的情况）（反馈到步骤1，若仅查询该范围数据存在往后排的数据被丢弃且后续不再查询他的情况----补数据）
        // 严格限制处于分页内或 分页最后位置大于严格限制 均不截断：故补数据只针对分页开始位置大于严格限制的才补数据
        if (!(endPos >= strictLimit)) {
            rawRecords = rawRecords.subList(0, Math.min((int)page.getSize(), rawRecords.size()));
        }

        // 4.2==0、补数据：查询前面整体被占了位置的数据（查询前面分页的全部id，及前面分页全部的广告数据，非处于该范围内的广告的个数即为被排挤出位置的数据）【】
        rawPage.setRecords(rawRecords);

        return rawPage;
    }

    /**
     * 查询前面被挤出的数据
     *
     * @return
     */
    protected abstract List<String> getExtrudedIds(Page<Entity> page);

    /**
     * 查询原本分页数据
     *
     * @return
     */
    protected abstract Page<String> getRawPageData(Page<Entity> page);

    /**
     * 查询当前分页内的广告页数据<br>
     * <font color="orange">需要返回自己保证顺序排序</orange>
     *
     * @return
     */
    protected abstract List<Advertise> getAdvertiseData(Page<Entity> page);

    /**
     * 广告数据严格正确的位置限制，超过这个限制不再进行截断（故不需要补数据）
     *
     * @return
     */
    protected int getStrictLimit() {
        return 50;
    };

    /**
     * 广告
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Advertise {
        String id;
        // 排序
        Integer sort;
    }

    /**
     * 广告插入自定义实现
     * @return
     */
    protected BiConsumer<List<String>, List<Advertise>> advertiseInsert() {
        return null;
    }

}

