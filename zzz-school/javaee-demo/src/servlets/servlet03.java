package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet03")
public class servlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    
    public servlet03() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String str1 = request.getParameter("inter");
		System.out.println("兴趣："+str1);
		String strs[] = request.getParameterValues("inter");
		for(String s: strs){
			System.out.print(s+" ");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
