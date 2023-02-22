package one.zpq.springbootdemo.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import one.zpq.springbootdemo.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {

    @Override
    @Async
    public void export() {
        System.out.println("ReportServiceImpl:"+Thread.currentThread());
    }

}
