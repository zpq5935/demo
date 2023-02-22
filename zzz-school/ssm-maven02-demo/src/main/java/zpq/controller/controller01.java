package zpq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller01 {
	
	@RequestMapping(value="page1")
	public String page1()
	{
		return "page111.jsp";
	}
	
	@RequestMapping(value="page2")
	public String page2()
	{
		return "page2";
	}

}
