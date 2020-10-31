package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import prs.business.User;
import prs.exception.PrsDataException;

public class UserDb {

	public UserDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	/**
	 * Authenticates a User
	 *
	 * @param userName The user's userName
	 * @param password The user's password
	 * @returns The matching User or null if no matching User found
	 */

	private User getUserFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("ID");
		String userName = rs.getString("UserName");
		String password = rs.getString("Password");
		String firstName = rs.getNString("FirstName");
		String lastName = rs.getString("LastName");
		String phoneNumber = rs.getString("PhoneNumber");
		String email = rs.getString("Email");
		boolean isReviewer = rs.getBoolean("isReviewer");
		boolean isAdmin = rs.getBoolean("isAdmin");

		User user = new User(id, userName, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		return user;

	}

	public User authenticateUser(String username, String password) {

		String authenticateUser = "SELECT * From User WHERE UserName = ? AND Password = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(authenticateUser);) {

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet users = ps.executeQuery();

			if (users.next()) {
				User user = getUserFromResultSet(users);
				users.close();
				return user;
			} else {
				users.close();
				return null;
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving user. Msg: " + e.getMessage());

		}

	}

	public List<User> getAll() {
		String selectAll = "SELECT * FROM User";
		List<User> userList = new ArrayList<>();

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet users = stmt.executeQuery(selectAll)) {

			while (users.next()) {
				User user = getUserFromResultSet(users);

				userList.add(user);

			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving users. Msg: " + e.getMessage());

		}

		return userList;
	}

	public User getUserById(int id) {

		String userSelect = "SELECT * FROM User WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userSelect);) {

			ps.setInt(1, id);
			ResultSet users = ps.executeQuery();

			if (users.next()) {
				User user = getUserFromResultSet(users);
				users.close();
				return user;
			} else {
				users.close();
				return null;
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving user. Msg: " + e.getMessage());
		}

	}

	public boolean addUser(User user) {
		String userInsert = "INSERT INTO User( UserName, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userInsert)) {

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setBoolean(7, user.isReviewer());
			ps.setBoolean(8, user.isAdmin());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new PrsDataException("Error adding user. Msg: " + e.getMessage());

		}

	}

	public boolean updateUser(User user) {
		String userUpdate = "UPDATE user SET UserName = ?, Password = ?, FirstName = ?, LastName= ?, PhoneNumber = ?, Email =?, IsReviewer=?, IsAdmin =?  WHERE ID = ? ";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userUpdate)) {

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getPhoneNumber());
			ps.setString(6, user.getEmail());
			ps.setBoolean(7, user.isReviewer());
			ps.setBoolean(8, user.isAdmin());
			ps.setInt(9, user.getId());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error updating user. Msg: " + e.getMessage());

		}

	}

	public boolean deleteUser(int id) {
		String userDelete = "DELETE FROM User WHERE ID = ?;";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(userDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error deleting user. Msg: " + e.getMessage());
		}

	}
}
