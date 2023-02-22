package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dataBindingTest {

	private static final Log logger = LogFactory.getLog(helloController.class);
	
	@RequestMapping(value="/pathVariable/{userId}")
	public void pathVariableTest(@PathVariable Integer userId){
		logger.info("pathVariableTest:"+userId);
	}
	
	@RequestMapping(value="/requestHeaderTest")
	public void requestHeaderTest(
				@RequestHeader("User-Agent") String userAcent,
				@RequestHeader(value="Accept") String[] accepts){
		logger.info("requestHeaderTest:"+userAcent);
		for(String accept:accepts)
			logger.info(accept);
	}
	@RequestMapping(value="/cookieValueTest")
	public void cookieValueTest(
			@CookieValue(value="JSESSIOND",defaultValue="") String sessionId){
		logger.info("cookieValueTest:"+sessionId);
	}
}
