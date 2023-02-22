package one.zpq.simple;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution
public class SimpleJob implements Job {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println((sdf.format(new Date())));
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println(jobDataMap.getString("message"));
    }
}
