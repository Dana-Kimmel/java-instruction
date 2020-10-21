package bmdb.ui;

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
		System.out.println("gabn - Get an actor by last name");
		System.out.println("title - Get a movie by title");
		System.out.println("exit - Exit the Application");
		String command = Console.getString("Enter command: ");

		while (!command.equalsIgnoreCase("exit")) {

			switch (command) {
			case "la":
				ActorDb actorDb = new ActorDb();
				List<Actor> actors = actorDb.getAll();
				System.out.println("Actors: ");
				for (Actor actor : actors) {
					System.out.println(actor);
				}
				break;

			case "gabn":
				ActorDb actorDbGabn = new ActorDb();
				String lastName = Console.getString("Actor's last name: ");
				Actor actor = actorDbGabn.get(lastName);
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
			}

			command = Console.getString("Enter command: ");
		}
	}

}
