import java.util.Scanner;

/**
 * The program asks the user for the item being heated
 * and the amount of items being heated
 * and tells them how much time to heat them up for.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-02-25
 */
public final class Microwave {

    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main Method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Declare constants
        final int SUB_TIME = 60;
        final int PIZZA_TIME = 45;
        final int SOUP_TIME = 105;

        // Welcome and ask for food type
        System.out.println("Welcome, is your food pizza, sub, or soup?");
        System.out.print("Please type answer here: ");

        // Using Scanner for input
        final Scanner scanner = new Scanner(System.in);
        final String strFood = scanner.nextLine().toLowerCase();
        int baseTime = 0;

        // Find base cooking time
        if (strFood.equals("sub")) {
            baseTime = SUB_TIME;
        } else if (strFood.equals("pizza")) {
            baseTime = PIZZA_TIME;
        } else if (strFood.equals("soup")) {
            baseTime = SOUP_TIME;
        } else {
            System.out.println("Invalid item selected.");
            scanner.close();
            return;
        }
        //Ask user for how much food
        System.out.print("How many " + strFood);
        System.out.print("(s) will you be heating? ");
        System.out.print("Max. 3: ");

        try {
            //Change food amount input into integer
            int foodAmount = Integer.parseInt(scanner.nextLine());
            //Catch error if amount of food is less than one
            if (foodAmount < 1) {
                System.out.println("Number can't be less than 1.");
                scanner.close();
                return;
            //Catch error if amount of food is more than three
            } else if (foodAmount > 3) {
                System.out.println("Number can't be more than 3.");
                scanner.close();
            return;
            }

            //Calculate time
            int totalTime = baseTime;
            if (foodAmount == 2) {
                totalTime = (baseTime + baseTime / 2);
            } else if (foodAmount == 3) {
            totalTime = (baseTime * 2);
            }

            //Change total time into minutes and seconds
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;

        System.out.print("The total cook time is ");
        System.out.println(minutes + " minute(s) " + seconds + " second(s).");

        } catch (NumberFormatException error) {
        System.out.print("Invalid input. ");
        System.out.println("Please enter a number between 1 and 3.");
        }

        scanner.close();
    }
}
