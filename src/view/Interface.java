package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Interface {

	private int choice = 0;
	Scanner scInput;
	
	private String inputValue1;
	private String inputValue2;
	private String inputValue3;

	public void clearConsole() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getInput(String inputPattern) {
		String input;
		while (true) {
			scInput = new Scanner(System.in);
			input = scInput.nextLine();
			if (Pattern.matches(inputPattern, input) == true) {
				break;
			} else {
				this.invalidNum();
			}
		}
		return input;
	}

	public void closeScanner(){
		scInput.close();
	}

	public void presentInstruction() throws IOException {
		
		clearConsole();
		System.out.println("-----------------------------------------------------");
		System.out.println("Enter number corresponding to action you wish to take");
		System.out.println("-----------------------------------------------------");
		System.out.println("1: Add new member");
		System.out.println("2: Register a new boat to a member");
		System.out.println("3: Delete a member");
		System.out.println("4: Delete a specific member's boat");
		System.out.println("5: Change a boat's information (length)");
		System.out.println("6: Logout");
		System.out.println("7: Print a compact list of all members");
		System.out.println("8: Print a verbose list of all members");
		System.out.println("9: Search");
		System.out.println("10: Login");
		System.out.println("11: Exit program");
		System.out.println("-----------------------------------------------------");
		setChoice(Integer.parseInt(getInput("^[1-9]{1,1}[0-1]{0,1}$")));
	}

	public void successful() {
		
		if (getChoice() == 1) {
			System.out.println("*New Member Added!*");
		} else if (getChoice() == 2) {
			System.out.println("\n *Boat Registered!*");
		} else if (getChoice() == 3) {
			System.out.println("\n *Member Deleted!*");
		} else if (getChoice() == 4) {
			System.out.println("\n *Boat Deleted!*");
		} else if (getChoice() == 5) {
			System.out.println("\n *Boat Changed!*");
		} else if (getChoice() == 6) {
			System.out.println("*LOGOUT SUCCESSFUL!*");
		}   else if (getChoice() == 10) {
			System.out.println("\n *LOGIN WAS SUCCESSFUL*");
		}
	}

	public void serchPlusOperator(ArrayList<String> choiceList) {

		clearConsole();
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Enter number to what you want to do:");
		System.out.println("-----------------------------------------------------");
		System.out.println("1: Add something more to your search by using the '&&' (AND) operator.");
		System.out.println("2: Add something more to your search by using the '||' (OR) operator.");
		System.out.println("3: Start searching, I dont want to add anything. \n");
		
		System.out.println(" ***NOTES:*** \n");
		System.out.println("Works like this:");
		System.out.println("The && operator removes from the list that is returned to you.");
		System.out.println("The || operator adds to the list that returns to you.");
		System.out.println("Example: Returns all members that starts with String: Fredrik || adam || sara...");
		System.out.println("then revomes all members of that does not end with string: && jonsson");
		System.out.println("then revomes all members that doesnt contain the string: && s");
		System.out.println("Will now returns strings that starts with Fredrik, sara or adam that ends with jonsson and contains an s");
		System.out.println("adding now another || operator will treat it as if encapusalting it in (Fredrik || adam || sara && jonsson) ||...");
		
		System.out.println("-----------------------------------------------------");
		
		System.out.print("(");
		for (int i = 0; i < choiceList.size(); i += 3) {
			
			if (i != 0) {
				if(i != 3 && choiceList.get(i) == "||" && choiceList.get(i-3) == "&&"){
					System.out.print(") " + choiceList.get(i) + " (");
				}else{
				System.out.print(" " + choiceList.get(i) + " ");
			}
			}
			if (Integer.parseInt(choiceList.get(i + 1)) == 1) {
				System.out.print("name contains: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 2) {
				System.out.print("name starts with: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 3) {
				System.out.print("name ends with: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 4) {
				System.out.print("Members born month: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 5) {
				System.out.print("Members born day: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 6) {
				System.out.print("Members born year: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 7) {
				System.out.print("personal number: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 8) {
				System.out.print("members > " + choiceList.get(i + 2) + " years");
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 9) {
				System.out.print("members < " + choiceList.get(i + 2) + " years");
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 10) {
				System.out.print("members with boat type: " + choiceList.get(i + 2));
			} else if (Integer.parseInt(choiceList.get(i + 1)) == 11) {
				System.out.print("members with boat length: " + choiceList.get(i + 2));
			}
			
		}
		System.out.println("");
		setInputValue3(getInput("[1-3]{1}"));

	}

	public void error() {

		clearConsole();
		if (getChoice() == 1) {
			System.out.println("\n *The new member could not be added.*");
			System.out.println("*There is already a member with that personal number!*");
		} else if (getChoice() == 2) {
			System.out.println("\n *The new boat could not be registered.*");
			System.out.println("*Could not find any members with that ID!*");
		} else if (getChoice() == 3) {
			System.out.println("\n *The member could not be deleted.*");
			System.out.println("*Could not find any members with that ID!*");
		} else if (getChoice() == 4) {
			System.out.println("\n *The boat could not be deleted.*");
			System.out.println("*Could not find any members/boats with that ID!*");
		} else if (getChoice() == 5) {
			System.out.println("\n *The boat info could not be changed.*");
			System.out.println("*Could not find any members/boats with that ID!*");
		} else if (getChoice() == 9) {
			System.out.println("\n *Could not find any member on your search criteria.*");
		} else if (getChoice() == 10) {
			System.out.println("\n *Wrong Username or Password!*");
		}
	}
	public void errorLogin(){
		System.out.println("*LOGIN IS REQUIRED FOR ACCESS!*");
	}

	public void invalidNum() {
		System.out.println("*Invalid number/format/characters, please try again.*");
	}

	public void compactList(ArrayList<model.Member> memberList) {

		clearConsole();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < memberList.size(); i++) {

			sb.append("Name: " + memberList.get(i).getName() + "\n");
			sb.append("Member ID: " + memberList.get(i).getMemberID() + "\n");
			sb.append("Number of Boats: " + memberList.get(i).getNumberOfBoats() + "\n");
			sb.append("-------------------------------------------- \n");
		}
		System.out.println(sb.toString());
	}

	public void verboseList(ArrayList<model.Member> memberList) {

		clearConsole();
		if (memberList == null) {
			error();
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < memberList.size(); i++) {
			sb.append("Name: " + memberList.get(i).getName() + "\n");
			sb.append("Personal Number: " + memberList.get(i).getPersonalNumber().substring(0, 6) + "-"
					+ memberList.get(i).getPersonalNumber().substring(6, 10) + "\n");
			sb.append("Member ID: " + memberList.get(i).getMemberID() + "\n");
			for (int j = 0; j < memberList.get(i).getBoatList().size(); j++) {

				sb.append("Boat Type: " + memberList.get(i).getBoatList().get(j).getType() + "\n");
				sb.append("Boat ID: " + memberList.get(i).getBoatList().get(j).getID() + "\n");
				sb.append("Boat Length: " + memberList.get(i).getBoatList().get(j).getLength() + "m \n");
			}
			sb.append("-------------------------------------------- \n");
		}
		System.out.println(sb.toString());
	}

	public void exit() {
		clearConsole();
		System.out.println("*Existing program...*");
		System.out.println("*Welcome back!*");
	}
	public void pressEnterToContinue(){
			System.out.print("Press Enter Key to Continue...");
			setInputValue1(getInput(""));
	}

	public void displayInput1() {
		clearConsole();
		if (getChoice() == 1) {
			System.out.println(
					"*Please enter a firstname and surname for the member(Press 'esc' to go back to main menu):*");
			System.out.println("*Format: firstname + blankspace + surname,(Fredrik Jönsson)*");
			setInputValue1(getInput("[a-zA-Z]+.*[ \t]{1}.*[a-zA-Z]+$"));
		} else if (getChoice() == 2) {
			System.out.println("*Enter the ID of the member you wish to add a boat to:*");
			setInputValue1(getInput("[0-9]+"));
		} else if (getChoice() == 3) {
			System.out.println("*Enter the ID of the member you wish to delete:*");
			setInputValue1(getInput("[0-9]+"));
		} else if (getChoice() == 4) {
			System.out.println("*Enter the ID of the member who owns the boat that you wish to delete:*");
			setInputValue1(getInput("[0-9]+"));
		} else if (getChoice() == 5) {
			System.out.println("*Enter the ID of the members boat you wish to change:*");
			setInputValue1(getInput("[0-9]+"));
		} else if (getChoice() == 9) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Enter number of what you want to search for:");
			System.out.println("-----------------------------------------------------");
			System.out.println("1: Name contains ceartain letters");
			System.out.println("2: Name starts with ceartain letters");
			System.out.println("3: Name ends with ceartain letters");
			System.out.println("4: For members born a certain month(00 format)---(Not Implemented)");
			System.out.println("5: For members born a certain day of the month(00 format)---(Not Implemented)");
			System.out.println("6: For members born a certain year(00 format)---(Not Implemented)");
			System.out.println("7: For a certain personal number---(Not Implemented)");
			System.out.println("8: For members older than ... years(00 format)---(Not Implemented)");
			System.out.println("9: For member younger than ... years(00 format)---(Not Implemented)");
			System.out.println("10: Type of boat---(Not Implemented)");
			System.out.println("11: Length of boat(just numbers)---(Not Implemented)");
			setInputValue1(getInput("^[1-3]{1}$"));
		} else if (getChoice() == 10) {
			System.out.println("Username:");
			setInputValue1(getInput(".+"));
		}
		displayInput2();
	}

	public void displayInput2() {
		if (getChoice() == 1) {
			System.out
					.println("*Please enter the personal number for the member(Press 'esc' to go back to main menu):*");
			System.out.println("*Format: 10 digits, (YYMMDDXXXX): *");
			setInputValue2(getInput("[0-9]{10}"));
		} else if (getChoice() == 2) {
			System.out.println("-----------------------------------------------------");
			System.out.println("*Enter the number of what the boat type you want to add:*");
			System.out.println("-----------------------------------------------------");
			System.out.println("1: Kayak");
			System.out.println("2: Sailboat");
			System.out.println("3: Motorsailor");
			System.out.println("3: Other");
			setInputValue2(getInput("[1-4]{1}"));
		} else if (getChoice() == 4) {
			System.out.println("*Enter the ID of the boat you wish to delete:*");
			setInputValue2(getInput("[0-9]+"));
		} else if (getChoice() == 5) {
			System.out.println("*Enter the ID of the boat you wish change:*");
			setInputValue2(getInput("[0-9]+"));
		} else if (getChoice() == 9) {
			System.out.println("Type the text/numbers that you want to search for.");
			setInputValue2(getInput(".+"));
		} else if (getChoice() == 10) {
			System.out.println("Password:");
			setInputValue2(getInput(".+"));
		}
		displayInput3();
	}

	public void displayInput3() {
		if (getChoice() == 2) {
			System.out.println("*Enter the length of the boat(Only numbers):*");
			setInputValue3(getInput("[0-9]+"));
		} else if (getChoice() == 5) {
			System.out.println("*Enter the new length of the boat:*");
			setInputValue3(getInput("[0-9]+"));
		}
	}

	public int getChoice() {
		return choice;
	}

	private void setChoice(int choice) {
		this.choice = choice;
	}

	public String getInputValue2() {
		return inputValue2;
	}

	public void setInputValue2(String input2) {
		this.inputValue2 = input2;
	}

	public String getInputValue3() {
		return inputValue3;
	}

	public void setInputValue3(String input3) {
		this.inputValue3 = input3;
	}

	public String getInputValue1() {
		return inputValue1;
	}

	public void setInputValue1(String input1) {
		this.inputValue1 = input1;
	}
}
