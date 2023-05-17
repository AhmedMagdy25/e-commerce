package orders;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shared.JSONAdapter;
import shared.SingletonDBFuns;

import java.io.IOException;
import java.util.ArrayList;


public class Orders extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	SingletonDBFuns db = SingletonDBFuns.getInstance();
	

	public Orders() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			
			HttpSession session = request.getSession(false);
			if(session != null ) {
				String userID = session.getAttribute("userID").toString();
				String orders = new JSONAdapter().toJSON(this.db.getOrders(userID));
				response.getWriter().write(orders);				
			}else {
				response.getWriter().write("{\"forbidden\":\"login frist\"}");
			}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			
			HttpSession userSession = request.getSession(false);
			String productID = request.getParameter("productID");
			String requestType = request.getParameter("type");
				
			if(userSession == null) {
				response.getWriter().write("{\"forbidden\":\"login frist\"}");
			}else {
				ArrayList<String> ids = new ArrayList<String>();
				ids.add( (String) userSession.getAttribute("userID") );
				ids.add(productID);
				
				if(requestType.equals("add")) {
					if (this.db.makeOrder(ids))
						response.getWriter().write("{\"done\":\"the order is added successfully\"}");
					else
						response.getWriter().write("{\"error\":\"internal server error\"}");
				}else if(requestType.equals("delete")){
					ids.add(request.getParameter("timestamp"));
					if (this.db.deleteOrder(ids)) 
						response.getWriter().write("{\"success\":\"done\"}");
					else 
						response.getWriter().write("{\"error\":\"internal server error\"}");
				}else 
					response.getWriter().write("{\"error\":\"request type not specified\"}");
			}
				
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		resp.addHeader("Access-Control-Allow-Methods", "DELETE");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		
		HttpSession userSession = req.getSession(false);
		String productID = req.getParameter("productID");
			
		if(userSession == null) {
			resp.getWriter().write("{\"error\":\"login again\"}");
		}else {
			ArrayList<String> ids = new ArrayList<String>();
			ids.add( (String) userSession.getAttribute("userID") );
			ids.add(productID);
			if (this.db.deleteOrder(ids)) {
				resp.getWriter().write("{\"done\":\"the order is added successfully\"}");
			} else {
				resp.getWriter().write("{\"error\":\"internal server error\"}");
			}
		}
	}
	
	

}
