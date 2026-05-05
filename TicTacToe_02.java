import java.util.Random;

public class TicTacToe_02 {

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
    }

    // 🔥 Toss Logic
    static void tossAndAssignSymbols() {
        Random rand = new Random();
        int toss = rand.nextInt(2); // 0 or 1

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

    // 🔥 Display Result
    static void displayTossResult() {
        if (isHumanTurn) {
            System.out.println("Human won the toss!");
            System.out.println("Human plays first with symbol: " + humanSymbol);
            System.out.println("Computer symbol: " + computerSymbol);
        } else {
            System.out.println("Computer won the toss!");
            System.out.println("Computer plays first with symbol: " + computerSymbol);
            System.out.println("Human symbol: " + humanSymbol);
        }
    }
}