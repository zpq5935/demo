package controller;


import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.User_Validatior;



@Controller
public class UserController_Validator {
	
	private static final Log logger = LogFactory.getLog(helloController.class);
	
	@RequestMapping(value="/loginForm")
	public String loginForm(
			 String forName,
			Model model){
		System.out.println("UserController_Validator-->loginForm");
		User_Validatior user = new User_Validatior();
		model.addAttribute("user", user);
		return "/WEB-INF/jsp/loginForm.jsp";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(
			@Valid @ModelAttribute("user") User_Validatior user,
			BindingResult bindingResult,
			Model model){
		System.out.println("validator_login()");
		logger.info(user);
		if(bindingResult.hasErrors()){
			return "/WEB-INF/jsp/register_validator.jsp";
		}
		return "/WEB-INF/jsp/register_validator.jsp";
//		model.addAttribute("user",user);
//		return "/WEB-INF/jsp/success_validator.jsp";
	}
}
