package shared;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class SingletonDBFuns implements Serializable {
	
	private static SingletonDBFuns instance;

	private static final long serialVersionUID = 1L;
	private String dbUrl = "jdbc:mysql://localhost:3306/e-commerce?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String dbName = "root";
	private String dbPassword = "amP@ssw0rd";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private Connection con;
	
	private SingletonDBFuns() {
		loadDriver(dbDriver);
		con = getConnection();
	};
	
	public static SingletonDBFuns getInstance() {
		if(instance == null)
			instance = new SingletonDBFuns();
		return instance;
	}

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbName, dbPassword);
		} catch (SQLException e) {
			System.out.println("Cannot connect the database!" + e.toString());
		}
		return con;
	}

	public boolean insert(User user){
		boolean result = false;
		if(con == null) return result;
		String sql = "insert into users(user_id, user_name, user_email, user_password) values(?,?,?,?)";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			String id = java.util.UUID.randomUUID().toString();
			ps.setString(1, id);
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.executeUpdate();
			ps.close();
			result = true;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return result;
	}

	public List<String> authUser(User user){
		ArrayList<String> result = new ArrayList<>();
		if(con == null) return result;
		String sql = "select user_id, user_password from users where user_email = ? ";

		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			rs = ps.executeQuery();
			while (rs.next()) {
				result.add(rs.getString(1));
				result.add(rs.getString(2));
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return result;
	}

	public List<Product> getProducts(){
		ArrayList<Product> products = new ArrayList<>();
		if(con == null) return products;
		String sql = "select * from products";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setDetails(rs.getString(3));
				product.setImage(rs.getString(4));
				product.setPrice(rs.getFloat(5));

				products.add(product);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return products;
	}

	public boolean makeOrder(List<String> ids){
		boolean result = false;
		if(con == null) return result;
		String sql = "insert into orders (user_id, product_id, timestamp) values(?,?,?)";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String timestamp = dtf.format(now);
			ps.setString(1, ids.get(0));
			ps.setString(2, ids.get(1));
			ps.setString(3, timestamp);
			ps.executeUpdate();
			result = true;
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.toString());;
		}
		return result;
	}

	public List<Order> getOrders(String userID){
		ArrayList<Order> orders = new ArrayList<>();
		if(con == null) return orders;
		String sql = "select products.product_id, products.product_name, products.product_img, products.product_price, orders.timestamp from orders"
				+ " inner join products on orders.product_id = products.product_id where orders.user_id = ?";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setProductID(rs.getString(1));
				order.setProductName(rs.getString(2));
				order.setProductImg(rs.getString(3));
				order.setProductPrice(rs.getFloat(4));
				order.setTimestamp(rs.getString(5));

				orders.add(order);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return orders;
	}
	
	public boolean deleteOrder(List<String> ids){
		boolean result = false;
		if(con == null) return result;
		String sql = "DELETE FROM orders WHERE user_id = ? and product_id = ? and timestamp = ? LIMIT 1;";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ids.get(0));
			ps.setString(2, ids.get(1));
			ps.setString(3, ids.get(2));
			
			ps.executeUpdate();

			result = true;
			
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e.toString());;
		}
		return result;
	}

}
