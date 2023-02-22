package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import  org.springframework.web.servlet.mvc.Controller;
	

public class helloController implements Controller {

	private static final Log logger = LogFactory.getLog(helloController.class);
	
	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.info("handle被调用");
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","Hello World!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
