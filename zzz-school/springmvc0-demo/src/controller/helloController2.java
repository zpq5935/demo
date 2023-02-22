package controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController2 {

private static final Log logger = LogFactory.getLog(helloController.class);
	
	@RequestMapping(value="/hello2")
	public ModelAndView hello2(){
		logger.info("注解方法被调用");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","Hello World!<br>This is 注解！！！");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
