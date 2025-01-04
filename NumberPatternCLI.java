import java.util.Scanner;

public class NumberPatternCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for input
        System.out.print("Enter the number of rows to generate the pattern: ");
        int rows = scanner.nextInt();

        // Validate input
        if (rows <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            generatePattern(rows);
        }

        scanner.close();
    }

    private static void generatePattern(int rows) {
        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Add spaces for alignment
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // Add numbers
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            // Move to the next line
            System.out.println();
        }
    }
}
