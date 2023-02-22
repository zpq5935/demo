package one.zpq;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements SimpleJob {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-YY-DD hh:mm:ss");

    @Override
    public void execute(ShardingContext context) {
        System.out.println("Job start " + sdf.format(new Date()));
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                break;
            case 1:
                // do something by sharding item 1
                break;
            case 2:
                // do something by sharding item 2
                break;
            // case n: ...
        }
        System.out.println("Job End " + sdf.format(new Date()));
    }
}
