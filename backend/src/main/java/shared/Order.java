package shared;

public class Order {
	String userID;
	String productID;
	String productName;
	String productImg;
	float productPrice;
	String timestamp;
	
	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float producrPrice) {
		this.productPrice = producrPrice;
	}

}