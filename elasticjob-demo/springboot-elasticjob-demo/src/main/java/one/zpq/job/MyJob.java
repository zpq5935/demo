package one.zpq.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

public class MyJob implements SimpleJob {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-YY-DD hh:mm:ss");
    Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info(String.format("Thread ID: %s, 作业分片总数: %s, " +
                        "当前分片项: %s.当前参数: %s," +
                        "作业名称: %s.作业自定义参数: %s"
                ,
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        ));

    }
//    @Override
//    public void execute(ShardingContext context) {
//        System.out.println("Job start " + sdf.format(new Date()));
//        switch (context.getShardingItem()) {
//            case 0:
//                // do something by sharding item 0
//                break;
//            case 1:
//                // do something by sharding item 1
//                break;
//            case 2:
//                // do something by sharding item 2
//                break;
//            // case n: ...
//        }
//        System.out.println("Job End " + sdf.format(new Date()));
//    }
}
