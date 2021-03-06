import java.text.NumberFormat;

public class LineItem {

	// fields
	private Product product;
	private int quantity;

	// constructors
	public LineItem() {
		this.product = null;
		this.quantity = 0;
	}

	public LineItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	// setters and getters
	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	// helper methods
	public double getTotal() {
		double total = product.getPrice() * quantity;
		return total;
	}

	public String getTotalFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.getTotal());
	}
}