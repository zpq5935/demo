package one.zpq.springbootdemo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

import one.zpq.springbootdemo.domain.Customer;

public class HttpTest {

    private RestTemplate restTemplate = new RestTemplate();



    @Test
    public void test1() {
        String url = "http://127.0.0.1:8080/customer/list";
        Object result = restTemplate.getForEntity(url, String.class);
        System.out.println(result);
    }

    @Test
    public void testSendMvcArray() {
        String url = "http://127.0.0.1:8080/mvc/array?intArr={1}";
        int[] intArr = {1, 2, 3, 999, 2323};
        Object result = restTemplate.getForEntity(url, String.class, intArr);
        System.out.println(result);
    }

    @Test
    public void testSendMvcJson() {
        String url = "http://127.0.0.1:8080/mvc/json";
        Customer customer = new Customer();
        customer.setAccount("22514");
        customer.setEmail("465487@qq.com");
        Object request = JSONObject.toJSON(customer);
        Object result = restTemplate.postForEntity(url, request, String.class);
        System.out.println(result);
    }

    /**
     * 对比下面的testMvcFormat2
     */
    @Test
    public void testMvcFormat() {
        String url = "http://127.0.0.1:8080/mvc/format";
        String date = "2019-10-22";
        String money = "6789.58";
        //
        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("date", date);
        reqMap.put("money", money);
        //
        HttpEntity<Object> entity = new HttpEntity<>(reqMap);
        Object result = restTemplate.postForObject(url, entity, String.class);
        System.out.println(result);

    }

    /**
     * postForEntity请求体得用LinkedMultiValueMap
     */
    @Test
    public void testMvcFormat2() {
        String url = "http://127.0.0.1:8080/mvc/format";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        // map.add("date", "2019-10-22 11:21:11");
        map.add("date", new Date());
        map.add("money", "126789.58");

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void testMvcConverter() {
        String url = "http://127.0.0.1:8080/mvc/testConverter?customer={1}";
        String cuString = "2251zpq-2251@qq.com.cn";
        Object result = restTemplate.getForEntity(url, String.class, cuString);
        System.out.println(result);
    }

    /**
     * 利用httpHead发送消息及其注解@RequestHeader
     */
    @Test
    public void testHttpHead() {
        String url = "http://127.0.0.1:8080/head/page";
        String cuString = "2251zpq-2251@qq.com.cn";
        Object result = restTemplate.getForEntity(url, String.class, cuString);
        System.out.println(result);
    }
}
