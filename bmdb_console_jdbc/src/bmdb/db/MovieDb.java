package bmdb.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

		String titleSelect = "SELECT * FROM MOVIE WHERE Title = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(titleSelect)) {

			ps.setString(1, title);
			ResultSet movies = ps.executeQuery();

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);

				movies.close();
				return movie;
			} else {

				movies.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public Movie get(long id) {
		String movieSelect = "SELECT * FROM MOVIE WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieSelect)) {

			ps.setLong(1, id);
			ResultSet movies = ps.executeQuery();

			if (movies.next()) {
				Movie movie = getMovieFromResultSet(movies);

				movies.close();

				return movie;
			} else {
				movies.close();

				return null;
			}
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return null;
		}
	}

	public boolean add(Movie movie) {
		String movieInsert = "INSERT INTO movie(ID, Title, Year, Rating, Director) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieInsert)) {
			ps.setLong(1, movie.getId());
			ps.setString(2, movie.getTitle());
			ps.setLong(3, movie.getYear());
			ps.setString(4, movie.getRating());
			ps.setString(5, movie.getDirector());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}

	}

	public boolean delete(long id) {
		String movieDelete = "DELETE FROM movie WHERE ID = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieDelete)) {
			ps.setLong(1, id);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}

	public boolean update(Movie movie) {
		String movieUpdate = "UPDATE actor SET WHERE ID = ?, Title = ?, Year = ?, Rating = ?, Director = ?";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(movieUpdate)) {
			ps.setLong(1, movie.getId());
			ps.setString(2, movie.getTitle());
			ps.setLong(3, movie.getYear());
			ps.setString(4, movie.getRating());
			ps.setString(5, movie.getDirector());

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.err.println("Caught exception. " + e);
			return false;
		}
	}
}
