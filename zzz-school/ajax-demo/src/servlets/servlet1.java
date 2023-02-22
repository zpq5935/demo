package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class servlet1
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告知浏览器使用utf-8解析字符
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String nameString = null;
		nameString = request.getParameter("empName");
		PrintWriter out = response.getWriter();
//		response.sendRedirect(request.getContextPath()+"/a.jsp");
		if(nameString=="") {
			out.print("name参数未传输");
			return ;
		}
		
		if(nameString.equals("zpq")){
			out.print("已存在，不可使用");
		}else{
			out.print("不存在，可使用");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
