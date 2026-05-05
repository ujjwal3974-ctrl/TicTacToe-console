import java.util.Scanner;
import java.util.Random;

public class TicTacToe_09 {

    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {

        initializeBoard();
        tossAndAssignSymbols();
        displayTossResult();

        boolean gameOver = false;

        while (!gameOver) {

            printBoard();

            char currentSymbol = isHumanTurn ? humanSymbol : computerSymbol;

            if (isHumanTurn) {
                System.out.println("Human Turn:");
                humanMove();
            } else {
                System.out.println("Computer Turn:");
                computerMove();
            }

            // 🔥 UC9: Win Check
            if (checkWin(currentSymbol)) {
                printBoard();
                if (isHumanTurn) {
                    System.out.println("Human Wins!");
                } else {
                    System.out.println("Computer Wins!");
                }
                break;
            }

            // 🔥 Draw Check
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a Draw!");
                break;
            }

            // 🔥 Switch Turn
            isHumanTurn = !isHumanTurn;
        }
    }

    // UC1
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // UC2
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

    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("Human won the toss! Plays first.");
        } else {
            System.out.println("Computer won the toss! Plays first.");
        }
        System.out.println();
    }

    // UC3
    static int getUserSlot() {
        int slot;
        while (true) {
            System.out.print("Enter slot (1-9): ");
            slot = sc.nextInt();
            if (slot >= 1 && slot <= 9) return slot;
            System.out.println("Invalid input!");
        }
    }

    // UC4
    static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    static int getCol(int slot) {
        return (slot - 1) % 3;
    }

    // UC5
    static boolean isValidMove(int row, int col) {
        return board[row][col] == '-';
    }

    // UC6
    static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7
    static void humanMove() {
        while (true) {
            int slot = getUserSlot();
            int row = getRow(slot);
            int col = getCol(slot);

            if (isValidMove(row, col)) {
                updateBoard(row, col, humanSymbol);
                break;
            } else {
                System.out.println("Cell occupied! Try again.");
            }
        }
    }

    static void computerMove() {
        System.out.println("Computer is making a move...");

        while (true) {
            int slot = rand.nextInt(9) + 1;
            int row = getRow(slot);
            int col = getCol(slot);

            if (isValidMove(row, col)) {
                updateBoard(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // 🔥 UC9: Win Detection
    static boolean checkWin(char symbol) {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) {
                return true;
            }
        }

        // Diagonals
        if ((board[0][0] == symbol &&
             board[1][1] == symbol &&
             board[2][2] == symbol) ||

            (board[0][2] == symbol &&
             board[1][1] == symbol &&
             board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    // Draw Check
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}