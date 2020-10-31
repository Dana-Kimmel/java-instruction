package bmdb.ui;

import java.time.LocalDate;
import java.util.List;

import bmdb.business.Actor;
import bmdb.business.Movie;
import bmdb.db.ActorDb;
import bmdb.db.MovieDb;

public class BmdbApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Bootcamp Movie Database!\n");

		System.out.println();
		System.out.println("Commands");
		System.out.println("la - List Actors");
		System.out.println("lt - List Titles");
		System.out.println("aa - Add actor");
		System.out.println("am - Add movie");
		System.out.println("da - Delete actor");
		System.out.println("dm - Delete movie");
		System.out.println("ua - Update actor");
		System.out.println("um - Update movie");
		System.out.println("gabn - Get an actor by last name");
		System.out.println("gmbt - Get a movie by title");
		System.out.println("gabi - Get an actor by ID");
		System.out.println("gmbi - Get a movie by ID");

		System.out.println("exit - Exit the Application");
		String command = Console.getString("Enter command: ");

		ActorDb actorDb = new ActorDb();
		MovieDb movieDb = new MovieDb();

		while (!command.equalsIgnoreCase("exit")) {

			switch (command) {
			case "la":

				List<Actor> actors = actorDb.getAll();
				System.out.println("Actors: ");
				for (Actor actor : actors) {
					System.out.println(actor);
				}
				break;

			case "aa":
				addActor(actorDb);
				break;

			case "da":
				long idToDelete = Console.getInt("Actor ID to delete: ");
				if (actorDb.delete(idToDelete)) {
					System.out.println("Actor deleted");
				} else {
					System.out.println("Error deleting actor");
				}
				break;

			case "ua":
				updateActor();

				break;

			case "gabn":

				String lastName = Console.getString("Actor's last name: ");
				Actor actor = actorDb.getActorByLastName(lastName);
				if (actor == null) {
					System.out.println("No actor found");
				} else {
					System.out.println(actor);
				}
				break;

			case "gmbt":
				MovieDb movieDbTitle = new MovieDb();
				String title = Console.getString("Enter movie title: ");
				Movie movie = movieDbTitle.get(title);
				if (movie == null) {
					System.out.println("No movie title found");
				} else {
					System.out.println(movie);
				}
				break;

			case "lt":

				List<Movie> movies = movieDb.getAll();
				System.out.println("Movie titles: ");
				for (Movie movie1 : movies) {
					System.out.println(movie1);
				}
				break;

			case "gabi":

				long actorId = Console.getInt("Actor's ID: ");
				Actor actorById = actorDb.get(actorId);
				if (actorById == null) {
					System.out.println("No actor found");
				} else {
					System.out.println(actorById);
				}
				break;

			case "gmbi":
				long movieId = Console.getInt("Movie's ID: ");
				Movie movieById = movieDb.get(movieId);
				if (movieById == null) {
					System.out.println("No movie found");
				} else {
					System.out.println(movieById);
				}
				break;

			case "am":
				String newTitle = Console.getString("Title: ");
				long newYear = Console.getInt("Year: ");
				String newRating = Console.getString("Rating: ");
				String newDirector = Console.getString("Director: ");

				Movie newMovie = new Movie(0, newTitle, newYear, newRating, newDirector);

				if (movieDb.add(newMovie)) {
					System.out.println("Movie added successfully");
				} else {
					System.out.println("Error adding movie");
				}
				break;

			case "dm":
				long movieIdToDelete = Console.getInt("Movie ID to delete: ");
				if (movieDb.delete(movieIdToDelete)) {
					System.out.println("Actor deleted");
				} else {
					System.out.println("Error deleting movie");
				}
				break;

			case "um":
				long updMovieId = Console.getInt("ID: ");
				String updTitle = Console.getString("Title: ");
				long updYear = Console.getInt("Year: ");
				String updRating = Console.getString("Rating: ");
				String updDirector = Console.getString("Rating: ");

				Movie updMovie = new Movie(updMovieId, updTitle, updYear, updRating, updDirector);

				if (movieDb.update(updMovie)) {
					System.out.println("Actor updated successfully");
				} else {
					System.out.println("Error updating actor");

				}
				break;
			}

			command = Console.getString("Enter command: ");
		}
	}

	private static void addActor(ActorDb adb) {

		String firstName = Console.getString("First name: ");
		String lastName = Console.getString("Last Name: ");
		String gender = Console.getString("Gender: ");
		String birthDateStr = Console.getString("Birthdate (YYYY-MM-DD");
		LocalDate birthDate = LocalDate.parse(birthDateStr);

		Actor newActor = new Actor(0, firstName, lastName, gender, birthDate);

		if (adb.add(newActor)) {
			System.out.println("Actor added successfully");

		} else {
			System.out.println("Error adding actor");
		}

	}

	private static void updateActor()

	{
		long updId = Console.getInt("ID: ");
		String updFirstName = Console.getString("First name: ");
		String updLastName = Console.getString("Last Name: ");
		String updGender = Console.getString("Gender: ");
		String updBirthDateStr = Console.getString("Birthdate (YYYY-MM-DD");
		LocalDate updBirthDate = LocalDate.parse(updBirthDateStr);

		Actor updActor = new Actor(updId, updFirstName, updLastName, updGender, updBirthDate);

		if (actorDb.update(updActor)) {
			System.out.println("Actor added successfully");

		} else {
			System.out.println("Error adding actor");
		}
	}
}
