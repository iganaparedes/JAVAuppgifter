package tictactoe;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class tttgame {

	public static void main(String[] args) {

		char[][] board = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
//int magicBox[]= {8,1,6,3,5,7,4,9,2};



 ArrayList<Integer> xPos= new ArrayList<Integer>();
 ArrayList<Integer> oPos= new ArrayList<Integer>(); 

//check



//--------------------

		int playersTurn=0;
		boolean isRunning = true;
		boolean gameIsrunning= true;
		boolean newTurn=true;
		int turn=0;
		int pos=0; 
		Scanner playerInput = new Scanner(System.in);
		System.out.println("Play TicTacToe!");
		System.out.println("Player ONE, choose a nickname: ");
		String player1 = playerInput.nextLine();
		System.out.println("Player TWO, choose a nickname: ");
		String player2 = playerInput.nextLine();
		drawBoard(board);
		
		while(gameIsrunning) {
			while (isRunning) {
	
				/*if (p1) {
					System.out.println(player1 + "'s turn (x)");
				} else {
					System.out.println(player2 + "'s turn (o)");
				}*/
				//while (true) {
	
				turn++;
				 playersTurn = turn % 2;
				 
			
				 if(playersTurn==0) {
						while(newTurn ||checkInput(board, pos,playersTurn,xPos)) {
							 if(checkWinCondition(xPos,oPos)){
								 isRunning=false;
								 placePosition(board, pos, "player2");
								 break; }
								System.out.println(player1 + "'s turn (x)");
	
							 pos = playerInput.nextInt();
							 newTurn = false;
							 
						 }
						if(isRunning)placePosition(board, pos, "player1");
						}
					else 
					{
						while(newTurn ||checkInput(board, pos,playersTurn,oPos)) {
							 if(checkWinCondition(xPos,oPos)) {
								 isRunning=false;
								 placePosition(board, pos, "player1");
								 break; }
								System.out.println(player2 + "'s turn (o)");
	
							 pos = playerInput.nextInt();
							 newTurn = false;
						 }
						if(isRunning)placePosition(board, pos, "player2");
					}	
				//System.out.println("Enter a number (1-9): ");
				
				 
				drawBoard(board);
				
				//System.out.println(xPos +"\n"+ oPos);
				newTurn = true;
				 /*else {
						System.out.println("end");
						break;
					}*/
				//}
			}
		System.out.println("Reset the game by typing \"true\" ");
			boolean answer = playerInput.nextBoolean();
			if(answer) {
				gameIsrunning=true;
				isRunning=true;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						board[i][j] = '-';
					}
				}
				drawBoard(board);
				xPos.clear();
				oPos.clear();
			}
			else gameIsrunning=false;
		}		
				
			playerInput.close();
			
		}



	private static boolean checkWinCondition(ArrayList<Integer> xPos, ArrayList<Integer> oPos) {
		 final ArrayList<Integer> row1= new  ArrayList<Integer>(List.of(0,1,2) );

		 final ArrayList<Integer> row2= new  ArrayList<Integer>(List.of(3,4,5) );

		 final ArrayList<Integer> row3= new  ArrayList<Integer>(List.of(6,7,8) );

		 final ArrayList<Integer> col1= new  ArrayList<Integer>(List.of(0,3,6) );

		 final ArrayList<Integer> col2= new  ArrayList<Integer>(List.of(1,4,7) );

		 final ArrayList<Integer> col3= new  ArrayList<Integer>(List.of(2,5,8) );

		 final ArrayList<Integer> dia1= new  ArrayList<Integer>(List.of(0,4,8) );

		 final ArrayList<Integer> dia2= new  ArrayList<Integer>(List.of(2,4,6) );
		 
		if(xPos.containsAll(row1) ||
			xPos.containsAll(row2) ||	
			xPos.containsAll(row3) ||
			xPos.containsAll(col1) ||	
			xPos.containsAll(col2) ||	
			xPos.containsAll(col3) ||	
			xPos.containsAll(dia1) ||	
			xPos.containsAll(dia2)	
				){System.out.println("X wins!!!");
				return true;
	}
		if(oPos.containsAll(row1) ||
				oPos.containsAll(row2) ||	
				oPos.containsAll(row3) ||
				oPos.containsAll(col1) ||	
				oPos.containsAll(col2) ||	
				oPos.containsAll(col3) ||	
				oPos.containsAll(dia1) ||	
				oPos.containsAll(dia2)	
					) {System.out.println("O wins!!!");
		
					return  true;
		}
		return false;
		
	}



	private static boolean checkInput(char[][] board,int pos,int player, ArrayList<Integer> posList) {
	   	if (0 < pos && pos < 10) {
	   	 	if (getSymbolAt(board,pos) == '-') {
	   	 		{
	   	 		posList.add(pos-1);
				return false;
	   	 		}
			}
	   	 	else
	   	 		System.out.println("Position taken, try another number!");
		}else 	
			System.out.println("Wrong number, try again!");

	  
		
		return true;
	}



	public static void drawBoard(char[][] board) {

		System.out.println("Board:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	public static void placePosition(char[][] board, int pos, String user) {

		char symbol = ' ';

		if (user.equals("player1")) {
			symbol = 'X';
		} else if (user.equals("player2")) {
			symbol = 'O';
		}

		switch (pos) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][1] = symbol;
			break;
		case 3:
			board[0][2] = symbol;
			break;
		case 4:
			board[1][0] = symbol;
			break;
		case 5:
			board[1][1] = symbol;
			break;
		case 6:
			board[1][2] = symbol;
			break;
		case 7:
			board[2][0] = symbol;
			break;
		case 8:
			board[2][1] = symbol;
			break;
		case 9:
			board[2][2] = symbol;
			break;
		default:
			break;
		}
	}
	
	public static char getSymbolAt(char[][] board,int pos) {

	
		switch (pos) {
		case 1:
			return board[0][0];
		case 2:
			return board[0][1];
		case 3:
			return board[0][2];		
		case 4:
			return board[1][0];		
		case 5:
			return board[1][1];		
		case 6:
			return board[1][2];			
		case 7:
			return board[2][0];			
		case 8:
			return board[2][1];		
		case 9:
			return board[2][2];			
	
		}
		return 0;
	}


}
