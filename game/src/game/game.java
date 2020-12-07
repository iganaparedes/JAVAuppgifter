package game;

import java.util.Random;
import java.util.Scanner;

public class game {


	
	public static void main(String[] args) {
		
		Scanner playerInput = new Scanner(System.in);
		Random Rand = new Random();	
		
		int cpuScore = 0;
		int playerScore = 0;
		int counter = 0;
		String rock = "rock";
		String paper = "paper";
		String scissors = "scissors";
		
		while(counter == 0) {
			int cpuChoice = 1 + Rand.nextInt(3);
			
			System.out.println("Please press or type the following:");
			System.out.println();
			System.out.println("1 or \"rock\"");
			System.out.println("2 or \"paper\"");
			System.out.println("3 or \"scissors\"");
			String number = playerInput.nextLine();
	    	    	
	    	int playerChoice = 0;
	    	try {
	    		playerChoice = Integer.parseInt(number);
	    	}
	    	catch (NumberFormatException e)
	    	{
	    		if(number.equalsIgnoreCase("rock")) {
	    			playerChoice = 1;
	    		}
	    		else if(number.equalsIgnoreCase("paper")) {
	    			playerChoice = 2;
	    		}
	    		else if(number.equalsIgnoreCase("scissors")) {
	    			playerChoice = 3;
	    		}
	    		else {
	    			System.out.println("Spell correctly, please");
	    		}
	    	}
			
			
			if(playerChoice == cpuChoice) {
				System.out.println("          Both players chose the same, it's a TIE!");
				System.out.println();
			}
						
		
		else if(playerChoice == 1) {
			
			if(cpuChoice == 2) {
				System.out.println("CPU chose paper ");
				System.out.println("Player chose rock and lost this round");
				cpuScore++;
				System.out.println("Score:");
				System.out.println("CPU " + cpuScore);
				System.out.println("Player " + playerScore);
				System.out.println();
			}
			else if(cpuChoice == 3) {
				System.out.println("CPU chose scissors ");
				System.out.println("Player chose rock and won this round");
				playerScore++;
				System.out.println("Score:");
				System.out.println("CPU " + cpuScore);
				System.out.println("Player " + playerScore);
				System.out.println();
			}
						
		}
		else if(playerChoice == 2) {
			if(cpuChoice == 1) {
				System.out.println("CPU chose rock ");
				System.out.println("Player chose paper and won this round");
				playerScore++;
				System.out.println("Score:");
				System.out.println("CPU " + cpuScore);
				System.out.println("Player " + playerScore);
				System.out.println();
			}
			else if(cpuChoice == 3) {
				System.out.println("CPU chose scissors ");
				System.out.println("Player chose scissors and lost this round");
				cpuScore++;
				System.out.println("Score:");
				System.out.println("CPU " + cpuScore);
				System.out.println("Player " + playerScore);
				System.out.println();
			}
		}
			else if(playerChoice == 3) {
				if(cpuChoice == 1) {
					System.out.println("CPU chose rock ");
					System.out.println("Player chose scissors and lost this round");
					cpuScore++;
					System.out.println("Score:");
					System.out.println("CPU " + cpuScore);
					System.out.println("Player " + playerScore);
					System.out.println();
				}
				else if(cpuChoice == 2) {
					System.out.println("CPU chose paper ");
					System.out.println("Player chose scissors and won this round");
					playerScore++;
					System.out.println("Score:");
					System.out.println("CPU " + cpuScore);
					System.out.println("Player " + playerScore);
					System.out.println();
				}		
}		
			if(playerScore == 5) {
				System.out.println("          YOU WON!");
				counter++;
				System.out.println("Player score: " + playerScore);
				System.out.println("CPU score: " +cpuScore);
				
			}
			if(cpuScore == 5) {
				System.out.println("          YOU LOST!");
				counter++;
				System.out.println("Player score: " + playerScore);
				System.out.println("CPU score: " +cpuScore);
				
	
}
}
}
}

