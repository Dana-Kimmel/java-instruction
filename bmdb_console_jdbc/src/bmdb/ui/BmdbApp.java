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
		System.out.println("da - Delete actor ");
		System.out.println("ua - Update actor");
		System.out.println("gabn - Get an actor by last name");
		System.out.println("gabi - Get an actor by id");
		System.out.println("title - Get a movie by title");
		System.out.println("exit - Exit the Application");
		String command = Console.getString("Enter command: ");

		ActorDb actorDb = new ActorDb();

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
				String newFirstName = Console.getString("First name: ");
				String newLastName = Console.getString("Last Name: ");
				String newGender = Console.getString("Gender: ");
				String newBirthDateStr = Console.getString("Birthdate (YYYY-MM-DD");
				LocalDate newBirthDate = LocalDate.parse(newBirthDateStr);

				Actor newActor = new Actor(0, newFirstName, newLastName, newGender, newBirthDate);

				if (actorDb.add(newActor)) {
					System.out.println("Actor added successfully");

				} else {
					System.out.println("Error adding actor");
				}
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

			case "title":
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
				MovieDb movieDb = new MovieDb();
				List<Movie> movies = movieDb.getAll();
				System.out.println("Movie titles: ");
				for (Movie movie1 : movies) {
					System.out.println(movie1);
				}
				break;

			case "gabi":

				long id = Console.getInt("Actor's ID: ");
				Actor actorById = actorDb.get(id);
				if (actorById == null) {
					System.out.println("No actor found");
				} else {
					System.out.println(actorById);
				}
				break;
			}

			command = Console.getString("Enter command: ");
		}
	}

}
