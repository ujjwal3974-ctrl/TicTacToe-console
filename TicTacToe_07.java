import java.util.Scanner;
import java.util.Random;

public class TicTacToe_07 {

    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        initializeBoard();          // UC1
        tossAndAssignSymbols();     // UC2
        displayTossResult();        // UC2
        printBoard();               // UC1

        // 🔥 UC7: One Turn Each (Demo)
        if (isHumanTurn) {
            humanMove();
            printBoard();

            computerMove();
            printBoard();
        } else {
            computerMove();
            printBoard();

            humanMove();
            printBoard();
        }
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
        System.out.println();
    }

    // 🔷 UC2: Toss Logic
    static void tossAndAssignSymbols() {
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
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("Computer plays first with: " + computerSymbol);
        }
        System.out.println();
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
                System.out.println("Invalid input! Try again.");
            }
        }
    }

    // 🔷 UC4: Mapping
    static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // 🔷 UC5: Validation
    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        if (board[row][col] != '-') return false;
        return true;
    }

    // 🔷 UC6: Update Board
    static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // 🔷 UC7: Human Move
    static void humanMove() {
        while (true) {
            int slot = getUserSlot();
            int row = getRow(slot);
            int col = getCol(slot);

            if (isValidMove(row, col)) {
                updateBoard(row, col, humanSymbol);
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // 🔷 UC7: Computer Move
    static void computerMove() {
        System.out.println("Computer is making a move...");

        while (true) {
            int slot = rand.nextInt(9) + 1; // 1–9
            int row = getRow(slot);
            int col = getCol(slot);

            if (isValidMove(row, col)) {
                updateBoard(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }
}