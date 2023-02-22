package one.zpq.springbootdemo;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

public class DistributeLockTest {
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 测试重发接口，会不会触发唯一索引；为分布式锁做准备<br>
     * 1、1
     */
    @Test
    public void test2() throws InterruptedException {
//        String url = "http://localhost:8082/cusWeb/product/addProduct?isdeleted=false&model=%7B%7D&para1=1&para2=2&para3=3&para4=4&prodname=productname\n";

        String url = "http://localhost:8080/cus-web/product/addProduct?isdeleted=false&model=%7B%7D&para1=1&para2=2&para3=3&para4=4&prodname=productname\n";
//        String url = "http://localhost:38080/cusWeb/product/addProduct?isdeleted=false&model=%7B%7D&para1=1&para2=2&para3=3&para4=4&prodname=productname\n";
        CountDownLatch countDownLatch1 = new CountDownLatch(1);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    countDownLatch1.await();
                    Object result = restTemplate.getForEntity(url, String.class);
                    System.out.println(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        countDownLatch1.countDown();
        while (Thread.activeCount() > 0) {
        }
        System.err.println("over");
    }
}
