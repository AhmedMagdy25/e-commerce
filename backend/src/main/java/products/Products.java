package products;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import shared.JSONAdapter;
import shared.SingletonDBFuns;

public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public Products() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000"); 
		SingletonDBFuns db = SingletonDBFuns.getInstance();
		response.getWriter().write(new JSONAdapter().toJSON(db.getProducts()));
	}

}
