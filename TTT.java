//TTT.java
//#100Days Of Code - Day 1
//Tic-Tac-Toe Game with Java
//Author: Kaitlyn Park
//Start Time: 2:30PM
//End Time: -
//Purpose: Getting familiar with Java and reminding basics ruls of code

/*What is Tic-Tac-Toe?:
a game in which two players seek in alternate turns to complete 
a row, a column, or a diagonal with either three O's or three X's drawn in the spaces of a grid of nine squares.
*/

//Every file with the extension of '.java' must include every code within a public class named with the filename itself.

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TTT {

    // member variables of TTT class:
    private char[][] board; // 2D array (3 x 3)
    private char currentPlayerMark; // X or O
    private int[] positions = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private List<Integer> availablePositions = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    // consturctor of TTT: this initializes the member variables when an instance of
    // TTT is created.
    public TTT() {
        // initialize the member variables:
        board = new char[3][3];
        initializeBoard();

        currentPlayerMark = Math.round(Math.random()) == 0 ? 'X' : 'O';
        // Math.random() = random number between 0 to 1
        // Math.round() = round the number. for example, if the random num is 0.7, it
        // rounds up to 1.
    }

    // methods of TTT class:
    // initializeBoard : initialize all slots to empty
    public void initializeBoard() {
        for (int i = 0, n = 1; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) (n + '0');
                n++;
            }
        }

    }

    // printBoard: print the tictactoe board
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // isBoardFull: check whether or not the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false; // board is not full
            }
        }
        return true; // board is full
    }

    // checkForWin: check to see if a player has won
    public boolean checkForWin() {
        if (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin())
            return true;
        return false;
    }

    // checkRowsForWin: check the rows for a win
    private boolean checkRowsForWin() {
        boolean matching = false;
        for (int r = 0; r < 3; r++) {
            if (checkRowCol(board[r][0], board[r][1], board[r][2]))
                matching = true;
        }
        return matching;
    }

    // checkColumnsForWin: check the columns for a win
    private boolean checkColumnsForWin() {
        boolean matching = false;
        for (int c = 0; c < 3; c++) {
            if (checkRowCol(board[0][c], board[1][c], board[2][c]))
                matching = true;
        }
        return matching;
    }

    // checkDiagonalsForWin: check the diagonals for a win
    private boolean checkDiagonalsForWin() {
        boolean matching = false;
        if (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]))
            matching = true;

        return matching;
    }

    // checkRowCol(c1,c2,c3): check the three specified characters taken in to see
    // if all three are the same ‘x’ or ‘o’ letter.
    private boolean checkRowCol(char c1, char c2, char c3) {
        boolean matching = false;
        if (c1 == c2 && c2 == c3) {
            matching = true;
        }
        return matching;
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void selectPositionOnBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void markOnBoard(int pos, char currentPlayer) {
        switch (pos) {
            case 1:
                board[0][0] = currentPlayer;
                availablePositions.remove(pos - 1);
                break;
            case 2:
                board[0][1] = currentPlayer;
                availablePositions.remove(pos - 1);
                break;
            case 3:
                board[0][2] = currentPlayer;
                availablePositions.remove(pos - 1);
                break;
            case 4:
                board[1][0] = currentPlayer;
                availablePositions.remove(Integer.valueOf(pos));
                break;
            case 5:
                board[1][1] = currentPlayer;
                availablePositions.remove(Integer.valueOf(pos));
                break;
            case 6:
                board[1][2] = currentPlayer;
                availablePositions.remove(Integer.valueOf(pos));
                break;
            case 7:
                board[2][0] = currentPlayer;
                availablePositions.remove(Integer.valueOf(pos));
                break;
            case 8:
                board[2][1] = currentPlayer;
                availablePositions.remove(Integer.valueOf(pos));
                break;
            case 9:
                board[2][2] = currentPlayer;
                availablePositions.remove(Integer.valueOf(pos));
                break;
            default:
                break;
        }
    }

    public void computerPlays() {
        char computerPlayerMark = currentPlayerMark == 'X' ? 'O' : 'X';

        Random random = new Random();

        int computerSelection = availablePositions.get(random.nextInt(availablePositions.size()));
        markOnBoard(computerSelection, computerPlayerMark);
        printBoard();
        System.out.println("Computer selected " + computerSelection);
    }

    public void player1Plays() {
        Scanner scan = new Scanner(System.in);
        int selectedPosition = -1;
        int i = 0;
        boolean validated = false;

        System.out.print("Select a position: (1-9)");
        selectedPosition = scan.nextInt();
        scan.nextLine();

        while (i < availablePositions.size()) {
            if (selectedPosition == availablePositions.get(i)) {
                validated = true;
                break;
            } else {
                i++;
            }
        }
        if (!validated) {
            System.out.println("You must select a number in available positions.");
            player1Plays();
        } else {
            System.out.println("You selected " + selectedPosition);
            markOnBoard(selectedPosition, currentPlayerMark);
        }
    }
}