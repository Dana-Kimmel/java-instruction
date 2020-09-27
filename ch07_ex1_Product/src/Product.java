import java.text.NumberFormat;

public class Product {

	private String code;
	private String description;
	private double price;

	// static variables
	private static int instanceCount = 0;

	// constructors
	public Product() {
		code = "";
		description = "";
		price = 0;

		instanceCount++;
	}

	public Product(String codeParam, String descParam, double priceParam) {
		this.code = codeParam;
		this.description = descParam;
		this.price = priceParam;

		instanceCount++;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getPriceFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

	public String getPriceNumberFormat() {
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(2);
		number.setMaximumFractionDigits(2);
		return number.format(price);
	}

	// static methods
	public static int getInstanceCount() {
		return instanceCount;
	}
}