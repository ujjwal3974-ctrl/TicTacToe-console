import java.util.Scanner;
import java.util.Random;

public class TicTacToe_05 {

    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        // 🔥 UC3 + UC4 + UC5 Integrated
        while (true) {
            int slot = getUserSlot();
            int row = getRow(slot);
            int col = getCol(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, humanSymbol);
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        printBoard();
    }

    // 🔷 UC1: Initialize Board
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    // 🔷 UC1: Print Board
    static void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // 🔷 UC2: Toss Logic
    static void tossAndAssignSymbols() {
        Random rand = new Random();
        int toss = rand.nextInt(2);

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    // 🔷 UC2: Display Toss Result
    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("Human won the toss!");
            System.out.println("Human plays first with: " + humanSymbol);
            System.out.println("Computer symbol: " + computerSymbol);
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("Computer plays first with: " + computerSymbol);
            System.out.println("Human symbol: " + humanSymbol);
        }
    }

    // 🔷 UC3: User Input
    static int getUserSlot() {
        int slot;

        while (true) {
            System.out.print("Enter slot (1-9): ");
            slot = sc.nextInt();

            if (slot >= 1 && slot <= 9) {
                return slot;
            } else {
                System.out.println("Invalid input! Enter between 1 and 9.");
            }
        }
    }

    // 🔷 UC4: Slot → Row
    static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // 🔷 UC4: Slot → Column
    static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // 🔷 UC5: Validate Move
    static boolean isValidMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    // 🔷 UC5: Place Move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}