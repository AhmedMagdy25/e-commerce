package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shared.SingletonDBFuns;
import shared.User;

import java.io.IOException;
import java.util.ArrayList;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		SingletonDBFuns DB = SingletonDBFuns.getInstance();
		ArrayList<String> result = (ArrayList<String>) DB.authUser(user);
		
		if (result.size() == 1) {
			response.getWriter().write("{\"faild\":\""+result.get(0)+"\"}");
		} else if (result.size() == 0){
			response.getWriter().write("{\"error\":\" internal server error \"}");
		}else {
			if (password.equals(result.get(1))) {
				HttpSession session = request.getSession();
				session.setAttribute("userID", result.get(0));
				response.getWriter().write("{\"success\":\"done\"}");
			} else {
				response.getWriter().write("{\"faild\":\"email and password are not matched\"}");
			}
		}
	}

}
