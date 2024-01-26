package customer_controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "customer/register.jsp";

		// actual field name
		request.setAttribute("username", "");
		request.setAttribute("email", "");
		request.setAttribute("phone", "");
		request.setAttribute("address", "");
		request.setAttribute("password", "");
		request.setAttribute("confirm_password", "");

		request.setAttribute("username_err", null);
		request.setAttribute("email_err", null);
		request.setAttribute("phone_err", null);
		request.setAttribute("address_err", null);
		request.setAttribute("password_err", null);
		request.setAttribute("confirm_password_err", null);

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("customer/register.jsp");

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");

		initializeRegisterForm(request, username, email, phone, address, password, confirmPassword);

		try {
			if (username != null && email != null && phone != null && address != null && password != null
					&& confirmPassword != null) {
				if (!username.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty()
						&& !password.isEmpty() && !confirmPassword.isEmpty()) {
					// all fields are filled
					response.getWriter()
							.print("All fields are filled!\n\nusername: " + username + "\n" + "email: " + email + "\n" + "phone: " + phone + "\n"
									+ "address: " + address + "\n" + "password: " + password + "\n"
									+ "confirm password: " + confirmPassword + "\n");
					return;
				} else {
					request.setAttribute("username_err", username.isEmpty() ? "Please enter your username" : "");
					request.setAttribute("email_err", email.isEmpty() ? "Please enter your email" : "");
					request.setAttribute("phone_err", phone.isEmpty() ? "Please enter your phone" : "");
					request.setAttribute("address_err", address.isEmpty() ? "Please enter your address" : "");
					request.setAttribute("password_err", password.isEmpty() ? "Please enter your password" : "");
					request.setAttribute("confirm_password_err",
							confirmPassword.isEmpty() ? "Please confirm your password" : "");
				}
			} else {
				response.getWriter()
						.print("username: " + username + "\n" + "email: " + email + "\n" + "phone: " + phone + "\n"
								+ "address: " + address + "\n" + "password: " + password + "\n" + "confirm password: "
								+ confirmPassword + "\n");
				return;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		rd.forward(request, response);
	}

	private void initializeRegisterForm(HttpServletRequest request, String username, String email, String phone,
			String address, String password, String confirmPassword) {

		request.setAttribute("username", username);
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("password", password);
		request.setAttribute("confirm_password", confirmPassword);

		request.setAttribute("username_err", "");
		request.setAttribute("email_err", "");
		request.setAttribute("phone_err", "");
		request.setAttribute("address_err", "");
		request.setAttribute("password_err", "");
		request.setAttribute("confirm_password_err", "");
	}

}