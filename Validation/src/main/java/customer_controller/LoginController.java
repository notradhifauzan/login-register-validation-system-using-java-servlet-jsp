package customer_controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.CustomerRepo;

import java.io.IOException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerRepo custRepo;

	public LoginController() {
		super();
		custRepo = new CustomerRepo();
	}

	/* GET request router */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		RequestDispatcher rd = null;

		if (action != null && action.isEmpty()) {
			switch (action) {
			case "login":
				getLogin(request, response, view, rd);
				return;
			default:
				break;
			}
		} else {
			response.getWriter().print("action is empty");
			return;
		}
	}

	private void getLogin(HttpServletRequest request, HttpServletResponse response, String view, RequestDispatcher rd)
			throws ServletException, IOException {
		view = "customer/login.jsp";

		request.setAttribute("username", "");
		request.setAttribute("password", "");

		request.setAttribute("username_err", null);
		request.setAttribute("password_err", null);

		rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("log :: LoginController :: doPost()");

		RequestDispatcher rd = request.getRequestDispatcher("customer/login.jsp");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		request.setAttribute("username", username);
		request.setAttribute("password", password);

		request.setAttribute("username_err", "");
		request.setAttribute("password_err", "");

		if (username != null && password != null) {
			if (!username.isEmpty() && !password.isEmpty()) {
				// check if username exist
				if (!custRepo.isUsernameExist(username)) {
					request.setAttribute("username_err", "username does not exist");
				} else {
					// check the password
					if (!custRepo.login(username, password)) {
						request.setAttribute("password_err", "wrong password");
					} else {
						response.getWriter().print("login success!");
						return;
					}
				}
			} else {
				if (username.isEmpty()) {
					request.setAttribute("username_err", "username should not be empty");
				}
				if (password.isEmpty()) {
					request.setAttribute("password_err", "password should not be empty");
				}
			}
		} else {
			response.getWriter().print("failed to retrieve form data");
			return;
		}

		rd.forward(request, response);
	}

}
