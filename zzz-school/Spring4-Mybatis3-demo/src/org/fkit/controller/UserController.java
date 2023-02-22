package org.fkit.controller;

import javax.servlet.http.HttpSession;

import org.fkit.domain.User;
import org.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(
			String loginname,String password,
			ModelAndView mv,
			HttpSession session){
		System.out.println("UserController"+"->login()");
		User user = userService.login(loginname, password);
		if(user!=null){
			session.setAttribute("user", user);
			mv.setView(new RedirectView("/test_Spring4_Mybatis3/main"));
		}else{
			mv.addObject("message", "登录名或密码错误，请重新输入！");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	
}
