package getTest;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {
	
	//Getメソッド
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException, ServletException{
		
		String value = request.getParameter("args");
		
		
		response.setContentType("text/html; charset=windows-31J");
		PrintWriter out = response.getWriter();
		out.println("<body>"
        		+ "<p>入力された内容は</p>"
        		+ "<p>"+value+"</p>"
        		+ "<p>です。</p>"
        		+ "</body>");
    }
}
	

