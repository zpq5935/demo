package one.zpq.springbootdemo.snsmgmt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public class SnsMgmtTest {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testDeviceBatchInsert() {
        String url = "http://127.0.0.1:8099/webcast-mgmt/DeviceMgmtAdd.do";

        List<Device> deviceList = new ArrayList<Device>();
        for (int i = 0; i < 10; i++) {
            Device device = new Device();
            device.setBizSequenceId(i + "");
            device.setMerNo("001");
            device.setMerNameJc("谁吃");
            device.setDeviceBrand("小吃牌");
            device.setDeviceModel("PP-II");
            device.setDeviceLocation("2365,5664");
            device.setDeviceMac(UUID.randomUUID().toString().replace("-", "").substring(0, 24));
            device.setDeviceOs("CTR");
            device.setDeviceIpAddr("56.89.1.65");
            device.setDeviceMroName("小明");
            // device.setDeviceState("01");
            device.setAuthorizeBizId("6987544");
            deviceList.add(device);
        }
        JSONObject request = new JSONObject();
        request.put("deviceList", deviceList);
        // Object request = JSONObject.toJSON(deviceList);
        ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, request, String.class);
        System.out.println(postForEntity.getBody());
    }

    @Test
    public void testFileDownload() {
//        String url = "http://127.0.0.1:8099/webcast-mgmt/DeviceMgmtExcelDownload.do";
//        ResponseEntity<String> postForEntity = restTemplate.postForEntity(url, null, String.class);
//        System.out.println(postForEntity.getBody().getBytes().length);
        //
        String httpsUrl = "https://127.0.0.1:8099/webcast-mgmt/DeviceMgmtExcelDownload.do";
        ResponseEntity<String> postForEntity2 = restTemplate.postForEntity(httpsUrl, null, String.class);
        System.out.println(postForEntity2.getBody().getBytes().length);
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());

    }
}
