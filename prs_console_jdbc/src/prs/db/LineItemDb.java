package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.LineItem;

import prs.exception.PrsDataException;

public class LineItemDb {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private LineItem getLineItemFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("ID");
		int requestId = rs.getInt("RequestID");
		int productId = rs.getInt("ProductID");
		int quantity = rs.getInt("Quantity");

		LineItem lineItem = new LineItem(id, requestId, productId, quantity);
		return lineItem;

	}

	public List<LineItem> getAll() {
		String selectAllLineItem = "SELECT * FROM LineItem";
		List<LineItem> lineItemList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet lineItems = stmt.executeQuery(selectAllLineItem)) {

			while (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);

				lineItemList.add(lineItem);
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving products. Msg: " + e.getMessage());

		}
		return lineItemList;
	}

	public LineItem getLineItemById(int id) {

		String lineItemSelect = "SELECT * FROM LINEITEM WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemSelect);) {

			ps.setInt(1, id);
			ResultSet lineItems = ps.executeQuery();

			if (lineItems.next()) {
				LineItem lineItem = getLineItemFromResultSet(lineItems);
				lineItems.close();
				return lineItem;
			} else {
				lineItems.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

	}

	public boolean addLineItem(LineItem lineItem) {
		String lineItemInsert = "INSERT INTO lineItem( RequestID, ProductID, Quantity) VALUES (?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemInsert)) {

			ps.setInt(1, lineItem.getRequestId());
			ps.setInt(2, lineItem.getProductId());
			ps.setInt(3, lineItem.getQuantity());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

	public boolean updateLineItem(LineItem lineItem) {
		String lineItemUpdate = "UPDATE lineItem SET RequestID = ?, ProductID = ?, Quantity = ?, WHERE ID = ? ";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemUpdate)) {

			ps.setInt(1, lineItem.getRequestId());
			ps.setInt(2, lineItem.getProductId());
			ps.setInt(3, lineItem.getQuantity());
			ps.setInt(4, lineItem.getId());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

	public boolean deleteLineItem(int id) {
		String lineItemDelete = "DELETE FROM product WHERE ID = ?;";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(lineItemDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}
}
