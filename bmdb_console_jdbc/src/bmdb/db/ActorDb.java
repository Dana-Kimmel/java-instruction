package bmdb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bmdb.business.Actor;

public class ActorDb {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "bmdb_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {

		long id = rs.getLong("ID");
		String firstName = rs.getString("FirstName");
		String lastName = rs.getString("LastName");
		String gender = rs.getString("Gender");
		String birthDate = rs.getString("BirthDate");

		Actor actor = new Actor(id, firstName, lastName, gender, LocalDate.parse(birthDate));
		return actor;
	}

	public List<Actor> getAll() {
		List<Actor> actorList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet actors = stmt.executeQuery("SELECT * FROM Actor");) {

			while (actors.next()) {
				Actor actor = getActorFromResultSet(actors);

				actorList.add(actor);
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

		return actorList;

	}

	public Actor get(String lastName) {

		String actorSelect = "SELECT * FROM ACTOR WHERE LastName ='" + lastName + "'";
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet actors = stmt.executeQuery(actorSelect);) {

			if (actors.next()) {
				Actor actor = getActorFromResultSet(actors);

				return actor;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

	}

}
