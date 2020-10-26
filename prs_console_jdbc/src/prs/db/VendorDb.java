package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.Vendor;
import prs.exception.PrsDataException;

public class VendorDb {

	public VendorDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Vendor getVendorFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("ID");
		String code = rs.getString("Code");
		String name = rs.getString("Name");
		String address = rs.getString("Address");
		String city = rs.getString("City");
		String state = rs.getString("State");
		String zip = rs.getString("Zip");
		String phoneNumber = rs.getString("PhoneNumber");
		String email = rs.getString("Email");

		Vendor vendor = new Vendor(id, code, name, address, city, state, zip, phoneNumber, email);
		return vendor;

	}

	public List<Vendor> getAll() {
		String selectAllVendor = "SELECT * FROM Vendor";
		List<Vendor> vendorList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet vendors = stmt.executeQuery(selectAllVendor)) {

			while (vendors.next()) {
				Vendor vendor = getVendorFromResultSet(vendors);

				vendorList.add(vendor);
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving vendors. Msg: " + e.getMessage());

		}
		return vendorList;
	}

	public Vendor getVendorById(int id) {

		String vendorSelect = "SELECT * FROM Vendor WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorSelect);) {

			ps.setInt(1, id);
			ResultSet vendors = ps.executeQuery();

			if (vendors.next()) {
				Vendor vendor = getVendorFromResultSet(vendors);
				vendors.close();
				return vendor;
			} else {
				vendors.close();
				return null;
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving vendor. Msg: " + e.getMessage());

		}

	}

	public boolean addVendor(Vendor vendor) {
		String vendorInsert = "INSERT INTO Vendor( Code, Name, Address, City, State, Zip, PhoneNumber, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorInsert)) {

			ps.setString(1, vendor.getCode());
			ps.setString(2, vendor.getName());
			ps.setString(3, vendor.getAddress());
			ps.setString(4, vendor.getCity());
			ps.setString(5, vendor.getState());
			ps.setString(6, vendor.getZip());
			ps.setString(7, vendor.getPhoneNumber());
			ps.setString(8, vendor.getEmail());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new PrsDataException("Error adding vendor. Msg: " + e.getMessage());

		}

	}

	public boolean updateVendor(Vendor vendor) {
		String vendorUpdate = "UPDATE Vendor SET Code= ?, Name= ?, Address = ?, City = ?, State = ?, Zip = ?, PhoneNumber = ?, Email = ? WHERE ID = ? ";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorUpdate)) {

			ps.setString(1, vendor.getCode());
			ps.setString(2, vendor.getName());
			ps.setString(3, vendor.getAddress());
			ps.setString(4, vendor.getCity());
			ps.setString(5, vendor.getState());
			ps.setString(6, vendor.getZip());
			ps.setString(7, vendor.getPhoneNumber());
			ps.setString(8, vendor.getEmail());
			ps.setInt(9, vendor.getId());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error updating vendor. Msg: " + e.getMessage());

		}
	}

	public boolean vendorProduct(int id) {
		String vendorDelete = "DELETE FROM Vendor WHERE ID = ?;";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(vendorDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error deleting product. Msg: " + e.getMessage());
		}

	}

}
