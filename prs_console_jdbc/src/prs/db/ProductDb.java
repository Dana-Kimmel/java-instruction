package prs.db;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.exception.PrsDataException;

public class ProductDb {

	public ProductDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Product getProductFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("ID");
		int vendorId = rs.getInt("VendorID");
		String partNumber = rs.getString("PartNumber");
		String name = rs.getString("Name");
		double price = rs.getDouble("Price");
		String unit = rs.getString("Unit");
		String photoPath = rs.getString("PhotoPath");

		Product product = new Product(id, vendorId, partNumber, name, price, unit, photoPath);
		return product;

	}

	public List<Product> getAll() {
		String selectAllProduct = "SELECT * FROM Product";
		List<Product> productList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet products = stmt.executeQuery(selectAllProduct)) {

			while (products.next()) {
				Product product = getProductFromResultSet(products);

				productList.add(product);
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products. Msg: " + e.getMessage());

		}
		return productList;
	}

	public Product getProductById(int id) {

		String productSelect = "SELECT * FROM PRODUCT WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productSelect);) {

			ps.setInt(1, id);
			ResultSet products = ps.executeQuery();

			if (products.next()) {
				Product product = getProductFromResultSet(products);
				products.close();
				return product;
			} else {
				products.close();
				return null;
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving product. Msg: " + e.getMessage());

		}

	}

	public boolean addProduct(Product product) {
		String productInsert = "INSERT INTO product( VendorID, PartNumber, Name, Price, Unit, PhotoPath) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productInsert)) {

			ps.setInt(1, product.getVendorId());
			ps.setString(2, product.getPartNumber());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getUnit());
			ps.setString(6, product.getPhotoPath());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new PrsDataException("Error adding product. Msg: " + e.getMessage());

		}

	}

	public boolean updateProduct(Product product) {
		String productUpdate = "UPDATE product SET VendorID = ?, PartNumber = ?, Name = ?, Price = ?, Unit = ?, PhotoPath =?, WHERE ID = ? ";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productUpdate)) {

			ps.setInt(1, product.getVendorId());
			ps.setString(2, product.getPartNumber());
			ps.setString(3, product.getName());
			ps.setDouble(4, product.getPrice());
			ps.setString(5, product.getUnit());
			ps.setString(6, product.getPhotoPath());
			ps.setInt(7, product.getId());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error updating product. Msg: " + e.getMessage());

		}

	}

	public boolean deleteProduct(int id) {
		String productDelete = "DELETE FROM product WHERE ID = ?;";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(productDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error deleting product. Msg: " + e.getMessage());
		}

	}
}
