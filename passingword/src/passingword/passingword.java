package passingword;

import java.util.Scanner;

public class passingword {

	public static void main(String[] args) {
		int passCheck = 0;
		String password = "CATSareAWESOME";
		Scanner input = new Scanner(System.in);
		while (passCheck < 3) {
			System.out.println("Please enter your password:");
			String userInput = input.nextLine();

			if (userInput.equals(password)) {
				System.out.println("Welcome!");
				passCheck = 4;
			} else if (!userInput.equals(password)) {
				System.out.println("Wrong password!");
				passCheck++;
				if(passCheck == 3) {
					System.out.println("Game over!");
				}
			}
			
			
		}	
			
	}
}
