import java.util.Scanner;

public class TicTacToe_03 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int slot = getUserSlot();
        System.out.println("You selected slot: " + slot);
    }

    static int getUserSlot() {
        int slot;

        while (true) {
            System.out.print("Enter a slot number (1-9): ");
            slot = sc.nextInt();

            if (slot >= 1 && slot <= 9) {
                return slot; // valid input
            } else {
                System.out.println("Invalid input! Please enter between 1 and 9.");
            }
        }
    }
}