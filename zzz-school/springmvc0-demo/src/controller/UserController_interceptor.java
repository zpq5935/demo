package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.User;

@Controller
public class UserController_interceptor {

	@RequestMapping(value="/loginForm_interceptor")
	public String loginForm(
			 String forName){
		System.out.println("UserController_interceptor-->loginForm");
		return "/WEB-INF/jsp/interceptor_loginForm.jsp";
		
	}
	
	@RequestMapping(value="/login_interceptor")
	public ModelAndView login(
			String loginname,String password,
			ModelAndView mv,
			HttpSession session){
		if(loginname!=null && loginname.equals("zpq")
				&& password!=null && password.equals("12345678910")){
			User user = new User();
			user.setLoginName(loginname);
			user.setPassword(password);
			user.setUserName("超级管理员");
			session.setAttribute("user", user);
			mv.setViewName("redirect:main");
		}else{
			mv.addObject("message", "error,重新输入！！！");
			mv.setViewName("/WEB-INF/jsp/interceptor_loginForm.jsp");
		}
		return mv;
	}
	
	
	
	
	
	
	
	
	
}
