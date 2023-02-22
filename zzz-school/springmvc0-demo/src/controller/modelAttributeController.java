package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.User;

@Controller
public class modelAttributeController {

	private static final Log logger = LogFactory.getLog(helloController.class);
	
	@ModelAttribute("user2")
	public User testModelAttribte01(){
		User user = new User();
		user.setLoginName("222");
		user.setPassword("222");
		user.setUserName("222");
		return user;
		
	}
	
	@ModelAttribute
	public void testModelAttribte02(Model model){
		User user = new User();
		user.setLoginName("333");
		user.setPassword("333");
		user.setUserName("333");
		model.addAttribute("user3", user);
		//return user;
	}
	
	@ModelAttribute()
	public String testModelAttribte03(){
		/*User user = new User();
		user.setLoginName("333");
		user.setPassword("333");
		user.setUserName("333");*/
		return "string_abc";
		
	}
	
	@RequestMapping(value="/login_MA")
	public String login(@ModelAttribute("user3") User user,
			@ModelAttribute("user2") User user2){
		user2.setUserName("篡改生效");
		user.setUserName("篡改生效");
		return "result";
	}
}
