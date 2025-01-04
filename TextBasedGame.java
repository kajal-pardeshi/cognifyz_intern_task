import java.util.Scanner;
import java.util.Random;

public class TextBasedGame {
    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Beginner Guessing Game!");
        System.out.println("Rules: Try to guess the number I'm thinking of (between 1 and 10).");
        System.out.println("You have 3 chances to get it right!");

        Random random = new Random();
        int secretNumber = random.nextInt(10) + 1; 

        int attempts = 3; 
        boolean isGuessed = false; 
        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) 
        {
            System.out.println("\nYou have " + attempts + " attempts left.");
            System.out.print("Enter your guess (1-10): ");

            try 
            {
                int guess = scanner.nextInt(); 

                if (guess < 1 || guess > 10) 
                {
                    System.out.println("Please guess a number between 1 and 10.");
                    continue; 
                }

                if (guess == secretNumber) 
                {
                    System.out.println("🎉 Congratulations! You guessed it right.");
                    isGuessed = true;
                    break; 
                } 
                else if (guess < secretNumber) 
                {
                    System.out.println("Too low! Try again.");
                } 
                else 
                {
                    System.out.println("Too high! Try again.");
                }

                attempts--; 
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }

        if (!isGuessed) 
        {
            System.out.println("\nGame Over! The correct number was " + secretNumber + ".");
        }

        System.out.println("Thanks for playing the Beginner Guessing Game!");
        scanner.close();
    }
}
