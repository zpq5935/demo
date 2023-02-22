package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import domain.*;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static List<User> userList;

	private UserController() {
		super();
		userList = new ArrayList<User>();
	}

	private static final Log logger = LogFactory.getLog(helloController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		logger.info("register GET方法被调用。。。");
		return "/WEB-INF/jsp/registerForm.jsp";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
			@RequestParam("userName") String userName) {
		logger.info("register POST方法被调用。。。" + "登录名：" + loginName + "密码：" + password);
		User user = new User();
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setUserName(userName);
		userList.add(user);
		return "/WEB-INF/jsp/loginForm.jsp";
	}

	/*
	 * @RequestMapping(value="/login") public String login(
	 * 
	 * @RequestParam("loginName") String loginName,
	 * 
	 * @RequestParam("password") String password, Model model){
	 * logger.info("method:login()	"+"登录名："+loginName+"密码："+password); for(User
	 * user:userList){
	 * if(user.getLoginName().equals(loginName)&&user.getPassword().equals(
	 * password)){ model.addAttribute("user", user); return
	 * "/WEB-INF/jsp/welcome_RequestParam.jsp"; } } return
	 * "/WEB-INF/jsp/registerForm.jsp"; }
	 */
	@RequestMapping(value = "/login")
	public String login(User user1, Model model) {
		String loginName = user1.getLoginName();
		String password = user1.getPassword();
		Date date = user1.getBirthday();
		logger.info("method:login()	" + "登录名：" + loginName + "密码：" + password + "日期：" + date);
		for (User user : userList) {
			if (user.getLoginName().equals(loginName) && user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "/WEB-INF/jsp/welcome_RequestParam.jsp";
			}
		}
		return "/WEB-INF/jsp/registerForm.jsp";
	}

	@RequestMapping(value = "/login2")
	public String login2(@RequestParam("str") String[] items, Model model) {

		logger.info("method:login2()	" + "item：" + items);
		if (items != null)
			model.addAttribute("items", items);
		return "/WEB-INF/jsp/converter.jsp";
	}
	
	@RequestMapping(value="/test_format",method=RequestMethod.POST)
	public String login3(
			 User_format user,
			Model model){
		System.out.println("formatt_login");
		logger.info(user);
		model.addAttribute("user", user);
		return "/WEB-INF/jsp/formatter_success.jsp";
		
	}
	
	@RequestMapping(value="/test_format02",method=RequestMethod.POST)
	public String login3(
			String discount,String total,String money,String birthday,
			Model model){
		System.out.println("formatt_login2");
		//logger.info(user);
		//model.addAttribute("user", user);
		return "/WEB-INF/jsp/formatter_success.jsp";
		
	}

}
