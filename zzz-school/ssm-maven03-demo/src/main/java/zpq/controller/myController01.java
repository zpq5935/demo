package zpq.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class myController01 {
	
	@RequestMapping("/page1")
	public String v1(){
		return "NewFile";
	}
	
	@ResponseBody
	@RequestMapping(value="/test_get",method=RequestMethod.GET)
	public String test_get(String data){
		System.out.println("接收数据:"+data);
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/my_test_post",method=RequestMethod.POST)
	public Map test_post(String data,@RequestBody Map<String,String> map){
		System.out.print("接收数据:"+data);
		for(Map.Entry<String, String> entry:map.entrySet()){
			System.out.print(entry.getKey()+":"+entry.getValue()+",");
		}
		System.out.println();
		return map;
	}
}
