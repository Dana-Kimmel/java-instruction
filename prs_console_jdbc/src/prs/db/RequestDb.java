package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.business.Request;
import prs.exception.PrsDataException;

public class RequestDb {

	public RequestDb() {

	}

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "prs_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Request getRequestFromResultSet(ResultSet rs) throws SQLException {

		int id = rs.getInt("ID");
		int userId = rs.getInt("UserID");
		String description = rs.getString("description");
		String justification = rs.getString("Justification");
		String date = rs.getString("DateNeeded");
		LocalDate dateNeeded = LocalDate.parse(date);
		String deliveryMode = rs.getString("DeliveryMode");
		String status = rs.getString("Status");
		double total = rs.getDouble("Total");
		String submitDate = rs.getString("SubmittedDate");
		LocalDateTime submittedDate = LocalDateTime.parse(submitDate);
		String reasonForRejection = rs.getString("ReasonForRejection");

		Request request = new Request(id, userId, description, justification, dateNeeded, deliveryMode, status, total,
				submittedDate, reasonForRejection);
		return request;

	}

	public List<Request> getAll() {
		String selectAllrequest = "SELECT * FROM Request";
		List<Request> requestList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet requests = stmt.executeQuery(selectAllrequest)) {

			while (requests.next()) {
				Request request = getRequestFromResultSet(requests);

				requestList.add(request);
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving requests. Msg: " + e.getMessage());

		}
		return requestList;
	}

	public Request getRequestById(int id) {

		String requestSelect = "SELECT * FROM Request WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestSelect);) {

			ps.setInt(1, id);
			ResultSet requests = ps.executeQuery();

			if (requests.next()) {
				Request request = getRequestFromResultSet(requests);
				requests.close();
				return request;
			} else {
				requests.close();
				return null;
			}

		} catch (SQLException e) {
			throw new PrsDataException("Error retrieving request. Msg: " + e.getMessage());

		}

	}

	public boolean addRequest(Request request) {
		String requestInsert = "INSERT INTO Request(UserID, Description, Justification, DateNeeded, DeliveryMode, Status, Total, SubmittedDate, ReasonForRejection) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestInsert)) {

			ps.setInt(1, request.getUserId());
			ps.setString(2, request.getDescription());
			ps.setString(3, request.getJustification());
			ps.setLocalDate(4, request.getDateNeeded());
			ps.setString(5, request.getDeliveryMode());
			ps.setString(6, request.getStatus());
			ps.setDouble(7, request.getTotal());
			ps.setLocalDateTime(8, request.getSubmittedDate());
			ps.setString(9, request.getReasonForRejection());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			throw new PrsDataException("Error adding request. Msg: " + e.getMessage());

		}

	}

	public boolean updateRequest(Request request) {
		String requestUpdate = "UPDATE Request SET UserID = ?, Description = ?, Justification = ?, DateNeeded = ?, DeliveryMode = ?, Status = ?, Total = ?, SubmittedDate = ?, ReasonForRejection = ? WHERE ID = ? ";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestUpdate)) {

			ps.setInt(1, request.getUserId());
			ps.setString(2, request.getDescription());
			ps.setString(3, request.getJustification());
			ps.setLocalDate(4, request.getDateNeeded());
			ps.setString(5, request.getDeliveryMode());
			ps.setString(6, request.getStatus());
			ps.setDouble(7, request.getTotal());
			ps.setLocalDateTime(8, request.getSubmittedDate());
			ps.setString(9, request.getReasonForRejection());
			ps.setInt(10, request.getId());
			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error updating request. Msg: " + e.getMessage());

		}

	}

	public boolean deleteRequest(int id) {
		String requestDelete = "DELETE FROM Request WHERE ID = ?;";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(requestDelete)) {
			ps.setInt(1, id);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			throw new PrsDataException("Error deleting request. Msg: " + e.getMessage());
		}

	}
}
