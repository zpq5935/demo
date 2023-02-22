package one.zpq.simple;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;


public class App {
    public static void main(String[] args) throws SchedulerException {

        Date endTime = new Date();
        endTime.setTime(endTime.getTime()+1000*10);
        //调度器
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        // Job实例
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).usingJobData("message", "datailMsg1").build();

        // 触发器
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().startNow()
                .withIdentity("trigger1", "group1")
                .startNow()
                .endAt(endTime)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(3).withRepeatCount(10))
                .build();
        // 开始执行
        defaultScheduler.scheduleJob(jobDetail, simpleTrigger);
        defaultScheduler.start();
    }
}
