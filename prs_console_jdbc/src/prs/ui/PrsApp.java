package prs.ui;

import java.time.LocalDate;
import java.util.List;

import prs.business.LineItem;
import prs.business.Product;
import prs.business.User;
import prs.business.Vendor;
import prs.db.LineItemDb;
import prs.db.ProductDb;
import prs.db.RequestDb;
import prs.db.UserDb;
import prs.db.VendorDb;
import prs.exception.PrsDataException;

public class PrsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS App");
		System.out.println();

		User authenticatedUser = null;
		UserDb userDb = new UserDb();

		while (authenticatedUser == null) {
			authenticatedUser = authenticateUser(userDb);
		}

		// Add a "login" command that prompts the user for an ID and password
		// Add a "logout" command that sets authenticatedUser to null

		System.out.println("COMMANDS:");

		// Product commands
		System.out.println("prod_la - List all products");
		System.out.println("prod_id - Get product by ID");
		System.out.println("prod_ap - Add product");
		System.out.println("prod_up - Update product");
		System.out.println("prod_dp - Delete product");

		// Line item commands
		System.out.println("line_la - List all line items");
		System.out.println("line_id - Get line item by ID");
		System.out.println("line_al - Add line item");
		System.out.println("line_ul - Update line item");
		System.out.println("line_dl - Delete line item");

		// Vendor commands
		System.out.println("vend_la - List all vendors");
		System.out.println("vend_id - Get vendor by ID");
		System.out.println("vend_av - Add vendor");
		System.out.println("vend_uv - Update vendor");
		System.out.println("vend_dv - Delete vendor");

		// User commands
		// list all users
		// get user by id
		// add userDb
		// update user
		// delete user

		// Request commands
		// list all requests
		// get request by id
		// add request
		// update request
		// delete request

		System.out.println("exit - Exit the application");
		System.out.println();

		ProductDb productDb = new ProductDb();
		LineItemDb lineItemDb = new LineItemDb();
		VendorDb vendorDb = new VendorDb();

		RequestDb requestDb = new RequestDb();

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter command: ");

			switch (command.toLowerCase()) {

			// ***** Product case *****

			case "prod_la":
				listProducts(productDb);
				break;

			case "prod_id":
				getProductById();
				break;

			case "prod_ap":
				addProduct();
				break;

			case "prod_up":
				updateProduct();
				break;

			case "prod_dp":
				deleteProduct();
				break;
			// ***** LineItem case *****

			case "line_la":
				listLineItems();
				break;

			case "line_id":
				getLineItemById();
				break;

			case "line_al":
				addLineItem();
				break;

			case "line-ul":
				updateLineItem();
				break;

			case "line_dl":
				deleteLineItem();

				// ***** Vendor case *****

			case "vend_la":
				listVendors();
				break;

			case "vend_id":
				getVendorById();
				break;

			case "vend_av":
				addVendor();
				break;

			case "vend_uv":
				updateVendor();
				break;

			case "vend_dv":
				deleteVendor();
				break;

			// ***** User case *****

			// ***** Request case *****

			case "exit":
				// Nothing to do
				break;

			default:
				System.out.println("Invalid command");
				break;

			}

		}

	}

	// ********* add Login Method
	// *************************************************************************************
	private static User authenticateUser(UserDb userDb) {

		String username = Console.getString("Username: ");
		String password = Console.getString("Password: ");

		User user = userDb.authenticateUser(username, password);

		if (user == null) {
			System.out.println("Incorrect entry");
		}
		return user;
	}

	// *********** Product
	// *******************************************************************************************************************
	private static void listProducts(ProductDb productDb) {
		try {

			List<Product> products = productDb.getAll();
			System.out.println("Products:");
			for (Product product : products) {
				System.out.println(product);
			}
			System.out.println();

		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve products. Msg: " + e.getMessage());
		}
	}

	private static void getProductById() {
		int productId = Console.getInt("Product's ID: ");
		Product productById = productDb.getProductById(productId);
		if (productById == null) {
			System.out.println("No product found");
		} else {
			System.out.println(productById);
		}
	}

	private static void addProduct() {

		int vendorId = Console.getInt("Vendor ID: ");
		String partNumber = Console.getString("Part number: ");
		String name = Console.getString("Product name: ");
		double price = Console.getDouble("Price: ");
		String unit = Console.getString("Unit: ");
		String photoPath = Console.getString("PhotoPath: ");

		Product newProduct = new Product(0, vendorId, partNumber, name, price, unit, photoPath);

		if (productDb.addProduct(newProduct)) {
			System.out.println("Product added successfully");

		} else {
			System.out.println("Error adding product");
		}

	}

	private static void updateProduct() {

		int vendorId = Console.getInt("Vendor ID: ");
		String partNumber = Console.getString("Part number: ");
		String name = Console.getString("Product name: ");
		double price = Console.getDouble("Price: ");
		String unit = Console.getString("Unit: ");
		String photoPath = Console.getString("PhotoPath: ");

		Product newProduct = new Product(0, vendorId, partNumber, name, price, unit, photoPath);

		if (productDb.updateProduct(newProduct)) {
			System.out.println("Product added successfully");

		} else {
			System.out.println("Error updating product");
		}
	}

	private static void deleteProduct() {
		int idToDelete = Console.getInt("Product ID to delete: ");
		if (productDb.deleteProduct(idToDelete)) {
			System.out.println("Product deleted");
		} else {
			System.out.println("Error deleting product");
		}
	}

	// *********** LineItem
	// ************************************************************************************************************************

	private static void listLineItems() {
		try {
			LineItemDb lineItemDb = new LineItemDb();
			List<LineItem> lineItems = lineItemDb.getAll();
			System.out.println("Line items:");
			for (LineItem lineItem : lineItems) {
				System.out.println(lineItem);
			}
			System.out.println();

		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve line items. Msg: " + e.getMessage());
		}

	}

	private static void getLineItemById() {
		int lineItemId = Console.getInt("Line item's ID: ");
		Product LineItemById = productDb.getProductById(lineItemId);
		if (LineItemById == null) {
			System.out.println("No line item found");
		} else {
			System.out.println(LineItemById);
		}
	}

	private static void addLineItem() {
		int requestId = Console.getInt("Request ID:");
		int productId = Console.getInt("Product ID:");
		int quantity = Console.getInt("Quantity:");

		LineItem newLineItem = new LineItem(0, requestId, productId, quantity);

		if (lineItemDb.addLineItem(newLineItem)) {
			System.out.println("Line item added successfully");

		} else {
			System.out.println("Error adding line item");
		}
	}

	private static void updateLineItem() {

		int requestId = Console.getInt("Request ID: ");
		int productId = Console.getInt("Product ID: ");
		int quantity = Console.getInt("Quantity: ");

		LineItem newLineItem = new LineItem(0, requestId, productId, quantity);

		if (lineItemDb.updateLineItem(newLineItem)) {
			System.out.println("Line item added successfully");

		} else {
			System.out.println("Error updating line item");
		}
	}

	private static void deleteLineItem() {
		int idToDelete = Console.getInt("Line item ID to delete: ");
		if (lineItemDb.deleteLineItem(idToDelete)) {
			System.out.println("Line item deleted");
		} else {
			System.out.println("Error deleting line item");
		}
	}

	// *********** Vendor
	// ***************************************************************************************************************************

	private static void listVendors() {
		try {

			List<Vendor> vendors = vendorDb.getAll();
			System.out.println("Vendors:");
			for (Vendor vendor : vendors) {
				System.out.println(vendor);
			}
			System.out.println();

		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve vendors. Msg: " + e.getMessage());
		}
	}

	private static void getVendorById() {
		int vendorId = Console.getInt("Vendor's ID: ");
		Vendor vendorById = vendorDb.getVendorById(vendorId);
		if (vendorById == null) {
			System.out.println("No vendor found");
		} else {
			System.out.println(vendorById);
		}
	}

	private static void addVendor() {

		String code = Console.getString("Code: ");
		String name = Console.getString("Name: ");
		String address = Console.getString("Address: ");
		String city = Console.getString("City: ");
		String state = Console.getString("State: ");
		String zip = Console.getString("Zip: ");
		String phoneNumber = Console.getString("Phone number: ");
		String email = Console.getString("Email: ");

		Vendor newVendor = new Vendor(0, code, name, address, city, state, zip, phoneNumber, email);

		if (vendorDb.addVendor(newVendor)) {
			System.out.println("Vendor added successfully");

		} else {
			System.out.println("Error adding vendor");
		}
	}

	private static void updateVendor() {

		String code = Console.getString("Code: ");
		String name = Console.getString("Name: ");
		String address = Console.getString("Address: ");
		String city = Console.getString("City: ");
		String state = Console.getString("State: ");
		String zip = Console.getString("Zip: ");
		String phoneNumber = Console.getString("Phone number: ");
		String email = Console.getString("Email: ");

		Vendor newVendor = new Vendor(0, code, name, address, city, state, zip, phoneNumber, email);

		if (vendorDb.updateVendor(newVendor)) {
			System.out.println("Vendor updated successfully");

		} else {
			System.out.println("Error adding vendor");
		}

	}

	private static void deleteVendor() {
		int idToDelete = Console.getInt("Vendor ID to delete: ");
		if (vendorDb.deleteVendor(idToDelete)) {
			System.out.println("Product deleted");
		} else {
			System.out.println("Error deleting vendor");
		}
	}
	// *********** User
	// *****************************************************************************************************************************

	// *********** Request
	// **************************************************************************************************************************

}
