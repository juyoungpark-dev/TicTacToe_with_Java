//Main.java
//#100Days Of Code - Day 1
//Tic-Tac-Toe Game with Java
//Author: Kaitlyn Park
//Start Time: 2:30PM
//End Time: - 6:00PM
//Purpose: Getting familiar with Java and reminding basics ruls of code

/*What is Tic-Tac-Toe?:
a game in which two players seek in alternate turns to complete 
a row, a column, or a diagonal with either three O's or three X's drawn in the spaces of a grid of nine squares.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // This is the entry point of the program. Once you run the program, this
        // is the starting point.

        Scanner scan = new Scanner(System.in); // to read input
        TTT ttt = new TTT();
        String player1Name;
        char player1Mark = ttt.getCurrentPlayerMark();
        boolean isGameOver = false;

        System.out.println("\"Tic-Tac-Toe Game created by Kaitlyn\" Starts!!");
        System.out.println("Current Board Layout:");
        ttt.printBoard();
        System.out.println();

        System.out.print("Player name: ");
        player1Name = scan.nextLine();
        System.out.println("Welcome, " + player1Name);
        System.out.println("You start first!");
        System.out.println("Your player mark for this game will be: " + player1Mark);

        ttt.selectPositionOnBoard();
        while (!isGameOver) {
            ttt.player1Plays();
            ttt.printBoard();
            
            if (ttt.checkForWin()) {
                isGameOver = true;
                System.out.println("You won!");
                break;
            }

            System.out.print("Press Enter to continue:<Enter>");
            scan.nextLine();

            System.out.println("Computer's turn!");
            ttt.computerPlays();
            
            if (ttt.checkForWin()) {
                isGameOver = true;
                System.out.println("Computer won!");
                break;
            }
            System.out.println("It's your turn again!");
        }
    }
}
