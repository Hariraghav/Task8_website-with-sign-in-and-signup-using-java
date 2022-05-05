

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema","root","root");  
			PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?)"); 
			ps.setString(1,request.getParameter("name"));  
			ps.setString(2,request.getParameter("email"));  
			ps.setString(3,BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt()));
			ps.setString(4,request.getParameter("date"));
			ps.executeUpdate();  ;  
			con.close(); 
			request.getRequestDispatcher("postsignUp.jsp").forward(request, response);;
			}catch(Exception e){ System.out.println(e);}  
	
	}


}
