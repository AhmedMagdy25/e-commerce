package signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shared.User;
import shared.SingletonDBFuns;

import java.io.IOException;

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		SingletonDBFuns DB = SingletonDBFuns.getInstance();
		if(DB.insert(user)) response.getWriter().write("{\"success\":\"done\"}");
		else response.getWriter().write("{\"error\":\"faild to sign up\"}");
	}

}
