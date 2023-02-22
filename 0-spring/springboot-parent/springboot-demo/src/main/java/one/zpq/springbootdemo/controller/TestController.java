package one.zpq.springbootdemo.controller;

import java.io.*;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.zpq.springbootdemo.domain.Customer;
import one.zpq.springbootdemo.service.ICustomerSerice;
import one.zpq.springbootdemo.service.IReportService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@Api("TestController")
@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IReportService reportServiceImpl;

    @Autowired
    ICustomerSerice customerService;

    @RequestMapping("customer/list")
    public List<Customer> listCustomer(Customer customer) {
        List<Customer> customerList = customerService.selectCustomer(customer);
        System.out.println(customerList);
        return customerList;
    }

    @RequestMapping("customer/list2")
    public List<Customer> listCustomerByMybatis() {
        System.out.println("mybatis");
        List<Customer> customerList = customerService.listCustomerByMybatis();
        System.out.println(customerList);
        return customerList;
    }

    @RequestMapping("testRedisPipeLine")
    public void testRedisPipeLine() throws InterruptedException {
        long startTime = System.currentTimeMillis();
//        redisTemplate.execute((RedisOperations redisOperations) -> {
//            for (int i = 0; i < 1000 * 100; i++) {
//                redisOperations.opsForValue().set("pipeline_" + i, "value_" + i);
//            }
//            return null;
//        });
        long endTime = System.currentTimeMillis();
        System.err.println("cost time:" + (endTime - startTime));
    }

    /**
     * 测试Spring对异步线程池的支持
     *
     * @return
     */
    @RequestMapping("async/testAsyncExecutor")
    public void testAsyncExecutor() {
        System.out.println("testAsyncExecutor:" + Thread.currentThread());
        reportServiceImpl.export();
    }

    @GetMapping
    @ApiOperation("获取指定文件")
    public void getFile(String path, HttpServletResponse httpServletResponse) throws Exception {
        File file = new File(path);
        if (file.isFile()) {
            InputStream inputStream = new FileInputStream(file);
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            int len = 0;
            byte[] data = new byte[1024];
            while ((len = inputStream.read(data)) > 0)
                servletOutputStream.write(data, 0, len);
        } else {
            throw new Exception("非文件");
        }
    }
}
