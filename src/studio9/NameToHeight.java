package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<String, Double> heights = new HashMap<>();
		
		heights.put("Siya", 62.0);
		heights.put("Adeyinka", 64.0);
		
		System.out.println("Please type in a name, or type quit: ");
		String name = in.next();
		
		while (!name.equals("quit")) {
			if (heights.get(name) == null) {
				System.out.println("That name is not in our list! Please type in another name: ");
				name = in.next();
			}
			else {
				System.out.println("Name: " + name);
				System.out.println("Height: " + heights.get(name) + "in");
				System.out.println("Please type in a name: ");
				name = in.next();
			}
		}

	}
}
