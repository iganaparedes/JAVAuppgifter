package password;

import java.util.Scanner;

public class passwordcheck {
 public static void main(String[] args) {
		
		final String PASSWORD = "heyhey";
		int MAX_ATTEMPTS = 3;
		Scanner input = new Scanner(System.in);

		String passInput="";
		
		while (MAX_ATTEMPTS-- > 0 && !PASSWORD.equals(passInput))
		{
			System.out.print("Enter your password: ");
			passInput = input.nextLine();
	        if (passInput.equals(PASSWORD)) 
	            System.out.println("Welcome");
	        else 
	            System.out.println("Incorrect. Number of attempts remaining: " + MAX_ATTEMPTS); 
				
			}
		}
}

		

