

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 1. right click on this file
 * 2. Run As
 * 3. Run on server
 * 
 * */
public class ValidationApplicationStarter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidationApplicationStarter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("customer/login.jsp?action=login");
	}

}
