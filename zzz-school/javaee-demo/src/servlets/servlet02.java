package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet02")
public class servlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    
    public servlet02() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext servletContext = request.getServletContext();
		String name = servletContext.getContextPath();
		String name2 = request.getContextPath();
		System.out.println("路径1，ServletContext："+name);
		System.out.println("路径1，Request："+name2);
		System.out.println("-----------------");
//		ClassLoader classLoader = getClass().getClassLoader();
//		InputStream in = classLoader.getResourceAsStream("jdbc.properties");
		InputStream in = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
		System.out.println(in);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
