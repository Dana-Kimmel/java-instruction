import java.util.ArrayList;

public class WizardInventoryApp {

	public static void main(String[] args) {

		ArrayList<String> wizardItems = new ArrayList<>();

		wizardItems.add("wooden staff");
		wizardItems.add("wizard hat");
		wizardItems.add("cloth shoes");

		System.out.println("The Wizard Inventory Game\n");
		System.out.println("COMMAND MENU");
		System.out.println("show - Show all items\ngrab - Grab an item\nedit - Edit an item");
		System.out.println("drop - Drop an item\nexit - Exit program");

		String choice;

		choice = Console.getString("\nCommand: \n");

		while (!choice.equalsIgnoreCase("exit")) {
			if (choice.equalsIgnoreCase("show")) {
				showAll(wizardItems);
				choice = Console.getString("\nCommand: \n");
			}
			if (choice.equalsIgnoreCase("grab")) {
				grabItem(wizardItems);
				choice = Console.getString("\nCommand: \n");

			} else if (choice.equalsIgnoreCase("edit")) {
				editItem(wizardItems);
				choice = Console.getString("\nCommand: \n");
			} else if (choice.equalsIgnoreCase("drop")) {
				dropItem(wizardItems);
				choice = Console.getString("\nCommand: \n");
			} else if (choice.equalsIgnoreCase("exit")) {
				System.out.println("Bye now :)");
			}

			else {
				System.out.println("Invalid");
				choice = Console.getString("\nCommand: \n");
			}
		}
	}

	public static void showAll(ArrayList<String> wizardItems) {
		int itemCounter = 1;
		for (String wizardItem : wizardItems) {
			System.out.println(itemCounter++ + ".  " + wizardItem);

		}
	}

	public static ArrayList<String> grabItem(ArrayList<String> wizardItems) {
		if (wizardItems.size() >= 4) {
			System.out.println("You can't carry any more items. Drop something first.");
		} else {
			String addedItem = Console.getString("Name: ");
			wizardItems.add(addedItem);
			System.out.println(addedItem + " was added.");
		}
		return wizardItems;
	}

	public static ArrayList<String> editItem(ArrayList<String> wizardItems) {
		int enterNumber = Console.getInt("Number: ");
		enterNumber--;
		String editItem = Console.getString("Updated name: ");
		wizardItems.set(enterNumber, editItem);
		enterNumber++;
		System.out.println("Item number " + enterNumber + " was updated");
		return wizardItems;
	}

	public static ArrayList<String> dropItem(ArrayList<String> wizardItems) {
		int enterNumber = Console.getInt("Number: ");
		enterNumber--;
		String itemDropped = wizardItems.remove(enterNumber);
		System.out.println(itemDropped + " was dropped");
		return wizardItems;
	}

}
