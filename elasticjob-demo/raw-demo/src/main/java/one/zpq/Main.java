package one.zpq;

import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

public class Main {
    public static void main(String[] args) {
        new ScheduleJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration()).schedule();
        //


//        OneOffJobBootstrap jobBootstrap = new OneOffJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration());
//        // 可多次调用一次性调度
//        jobBootstrap.execute();
//        jobBootstrap.execute();
//        jobBootstrap.execute();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2182", "my-job"));
        regCenter.init();
        return regCenter;
    }

    private static JobConfiguration createJobConfiguration() {
        JobConfiguration jobConfig = JobConfiguration.newBuilder("MyJob", 1).cron("0/5 * * * * ?").overwrite(true).build();
//        JobConfiguration jobConfig = JobConfiguration.newBuilder("MyJob", 3).build();
        return jobConfig;
        // 创建作业配置
        // ...
    }
}
