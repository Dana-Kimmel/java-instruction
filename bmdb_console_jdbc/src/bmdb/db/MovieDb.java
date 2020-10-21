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
import bmdb.business.Movie;

public class MovieDb {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "bmdb_user";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbURL, username, password);

		return connection;
	}

	private Movie getMovieFromResultSet(ResultSet rs) throws SQLException {

		long id = rs.getLong("ID");
		String title = rs.getString("Title");
		long year = rs.getLong("Year");
		String rating = rs.getString("Rating");
		String director = rs.getString("Director");

		Movie movie = new Movie(id, title, year, rating, director);
		return movie;
	}

	public List<Movie> getAll() {
		List<Movie> movieList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet movies = stmt.executeQuery("SELECT * FROM Movie");) {

			while (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);

				movieList.add(movie);
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}

		return movieList;

	}

	public Movie get(String title) {

		String titleSelect = "SELECT * FROM MOVIE WHERE Title ='" + title + "'";

		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet movies = stmt.executeQuery(titleSelect);) {

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);

				return movie;
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

}
