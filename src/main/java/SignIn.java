

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");  
			PreparedStatement ps=con.prepareStatement(  "select password from users where email=?" ); 
			ps.setString(1,email);    			      
			ResultSet rs=ps.executeQuery();  
		    boolean status = rs.next();

		    if(status) {
		    	String hashedpassword = rs.getString(1);
		    	System.out.println(hashedpassword);
		    	if (BCrypt.checkpw(password, hashedpassword)) {
		    		Cookie emailcookie =new Cookie("email",email);
					response.addCookie(emailcookie);
			    	request.getRequestDispatcher("postsignedIn.jsp").forward(request, response);;
		    	}
		    	else {
		    		pw.print("Incorrect Password");
		    	}
		    	
		    }
		    else {
		    	
		    	pw.print("Email and Password does not match or the account is invalid");
		    }
		    	
			}catch(Exception e){ System.out.println(e);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		 
			}  
	}


