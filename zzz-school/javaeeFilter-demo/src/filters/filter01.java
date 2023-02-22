package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class filter01 implements Filter {

		FilterConfig filterConfig = null;
   
    public filter01() {
    	System.out.println("filter0->1构造");
    }

	
	public void destroy() {
		System.out.println("filter01->destroy");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter01->doFilter");
		
		String initUserName = filterConfig.getInitParameter("username");
		String userName = request.getParameter("username");
		System.out.println(initUserName+" || "+userName);
		if(! initUserName.equals(userName)){
			request.setAttribute("errorMsg", "登录名有误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter01->init");
		filterConfig = fConfig;
	}

}
