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
		System.out.println("user_la - List all users");
		System.out.println("user_id - Get user by ID");
		System.out.println("user_au - Add user");
		System.out.println("user_uu - Update user");
		System.out.println("user_du - Delete user");

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

			if (command.equalsIgnoreCase("login")) {
				authenticatedUser = authenticateUser(userDb);

				if (authenticatedUser == null) {
					System.out.println("Username/password not found");
				} else {
					System.out.println("Welcome, " + authenticatedUser.getFirstName());
				}

			} else if (command.equalsIgnoreCase("logout")) {
				authenticatedUser = null;
			} else if (authenticatedUser != null) {

				switch (command.toLowerCase()) {

				// ***** Product case *****

				case "prod_la":
					listProducts(productDb);
					break;

				case "prod_id":
					getProductById(productDb);
					break;

				case "prod_ap":
					addProduct(productDb);
					break;

				case "prod_up":
					updateProduct(productDb);
					break;

				case "prod_dp":
					deleteProduct(productDb);
					break;
				// ***** LineItem case *****

				case "line_la":
					listLineItems(lineItemDb);
					break;

				case "line_id":
					getLineItemById(lineItemDb);
					break;

				case "line_al":
					addLineItem(lineItemDb);
					break;

				case "line-ul":
					updateLineItem(lineItemDb);
					break;

				case "line_dl":
					deleteLineItem(lineItemDb);

					// ***** Vendor case *****

				case "vend_la":
					listVendors(vendorDb);
					break;

				case "vend_id":
					getVendorById(vendorDb);
					break;

				case "vend_av":
					addVendor(vendorDb);
					break;

				case "vend_uv":
					updateVendor(vendorDb);
					break;

				case "vend_dv":
					deleteVendor(vendorDb);
					break;

				// ***** User case *****

				case "user_la":
					listUsers(userDb);
					break;

				case "user_id":
					getUserById(userDb);
					break;

				case "user_au":
					addUser(userDb);
					break;

				case "user_uu":
					updateUser(userDb);
					break;

				case "user_du":
					deleteUser(userDb);
					break;

				// ***** Request case *****

				case "exit":
					// Nothing to do
					break;

				default:
					System.out.println("Invalid command");
					break;

				}
			} else {
				System.out.println("Must be logged in");
			}
		}

	}

	// ********* add Login Method
	// *************************************************************************************
	private static User authenticateUser(UserDb userDb) {

		try {
			String userName = Console.getString("Username: ");
			String password = Console.getString("Password: ");

			User user = userDb.authenticateUser(userName, password);
			if (user == null) {
				System.out.println("Incorrect entry");

			}
			return user;
		} catch (PrsDataException e) {
			System.err.println("Error logging in. Msg: " + e.getMessage());
			return null;
		}

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

	private static void getProductById(ProductDb productDb) {
		int productId = Console.getInt("Product's ID: ");
		Product productById = productDb.getProductById(productId);
		if (productById == null) {
			System.out.println("No product found");
		} else {
			System.out.println(productById);
		}
	}

	private static void addProduct(ProductDb productDb) {

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

	private static void updateProduct(ProductDb productDb) {

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

	private static void deleteProduct(ProductDb productDb) {
		int idToDelete = Console.getInt("Product ID to delete: ");
		if (productDb.deleteProduct(idToDelete)) {
			System.out.println("Product deleted");
		} else {
			System.out.println("Error deleting product");
		}
	}

	// *********** LineItem
	// ************************************************************************************************************************

	private static void listLineItems(LineItemDb lineItemDb) {
		try {

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

	private static void getLineItemById(LineItemDb lineItemDb) {
		int lineItemId = Console.getInt("Line item's ID: ");
		LineItem lineItemById = lineItemDb.getLineItemById(lineItemId);
		if (lineItemById == null) {
			System.out.println("No line item found");
		} else {
			System.out.println(lineItemById);
		}
	}

	private static void addLineItem(LineItemDb lineItemDb) {
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

	private static void updateLineItem(LineItemDb lineItemDb) {

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

	private static void deleteLineItem(LineItemDb lineItemDb) {
		int idToDelete = Console.getInt("Line item ID to delete: ");
		if (lineItemDb.deleteLineItem(idToDelete)) {
			System.out.println("Line item deleted");
		} else {
			System.out.println("Error deleting line item");
		}
	}

	// *********** Vendor
	// ***************************************************************************************************************************

	private static void listVendors(VendorDb vendorDb) {
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

	private static void getVendorById(VendorDb vendorDb) {
		int vendorId = Console.getInt("Vendor's ID: ");
		Vendor vendorById = vendorDb.getVendorById(vendorId);
		if (vendorById == null) {
			System.out.println("No vendor found");
		} else {
			System.out.println(vendorById);
		}
	}

	private static void addVendor(VendorDb vendorDb) {

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

	private static void updateVendor(VendorDb vendorDb) {

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

	private static void deleteVendor(VendorDb vendorDb) {
		int idToDelete = Console.getInt("Vendor ID to delete: ");
		if (vendorDb.deleteVendor(idToDelete)) {
			System.out.println("Product deleted");
		} else {
			System.out.println("Error deleting vendor");
		}
	}

	// *********** User
	// *****************************************************************************************************************************

	private static void listUsers(UserDb userDb) {
		try {

			List<User> users = userDb.getAll();
			System.out.println("Users:");
			for (User user : users) {
				System.out.println(user);
			}
			System.out.println();

		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve users. Msg: " + e.getMessage());
		}
	}

	private static void getUserById(UserDb userDb) {
		int userId = Console.getInt("User's ID: ");
		User userById = userDb.getUserById(userId);
		if (userById == null) {
			System.out.println("No user item found");
		} else {
			System.out.println(userId);
		}
	}

	private static void addUser(UserDb userDb) {

		String userName = Console.getString("Username: ");
		String password = Console.getString("Password: ");
		String firstName = Console.getString("First name: ");
		String lastName = Console.getString("Last name: ");
		String phoneNumber = Console.getString("Phone number: ");
		String email = Console.getString("Email: ");

		User newUser = new User(0, userName, password, firstName, lastName, phoneNumber, email, false, false);

		if (userDb.addUser(newUser)) {
			System.out.println("User added successfully");

		} else {
			System.out.println("Error adding user");
		}

	}

	private static void updateUser(UserDb userDb) {

		String userName = Console.getString("Username: ");
		String password = Console.getString("Password: ");
		String firstName = Console.getString("First name: ");
		String lastName = Console.getString("Last name: ");
		String phoneNumber = Console.getString("Phone number: ");
		String email = Console.getString("Email: ");

		User newUser = new User(0, userName, password, firstName, lastName, phoneNumber, email, false, false);

		if (userDb.updateUser(newUser)) {
			System.out.println("User added successfully");

		} else {
			System.out.println("Error updating user");
		}
	}

	private static void deleteUser(UserDb userDb) {
		int idToDelete = Console.getInt("User ID to delete: ");
		if (userDb.deleteUser(idToDelete)) {
			System.out.println("User deleted");
		} else {
			System.out.println("Error deleting user");
		}
	}

	// *********** Request
	// **************************************************************************************************************************

}
