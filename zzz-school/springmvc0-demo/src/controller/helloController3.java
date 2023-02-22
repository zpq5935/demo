package controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController3 {

private static final Log logger = LogFactory.getLog(helloController.class);
	
	@RequestMapping(value="/hello3")
	public String hello3(Model mv){
		logger.info("注解方法2被调用");
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("message","Hello World!<br>This is 注解！！！");
		//mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		mv.addAttribute("message","Hello World!<br>This is 注解2！！！");
		return "welcome";
	}
}
