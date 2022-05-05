

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		
		Cookie cookie[]=request.getCookies();
		Map<String, Cookie> cookieMap = new HashMap<>();
		for (Cookie c : cookie) {
		    cookieMap.put(c.getName(), c);
		}

		Cookie ck = cookieMap.get("email");
		if(ck!=null){
		 String email=ck.getValue();
		if(!email.equals("")||email!=null){
			boolean loggedin = true;
			request.setAttribute("loggedin", loggedin);
			request.setAttribute("email", email);
			request.getRequestDispatcher("profile.jsp").forward(request, response);;
		}
		}else{
			boolean loggedin = false;
			request.setAttribute("loggedin", loggedin);
			request.getRequestDispatcher("profile.jsp").forward(request, response);;
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
