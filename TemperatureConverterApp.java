import java.util.Scanner;

public class TemperatureConverterApp {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking user for the type of conversion
        System.out.println("Temperature Converter");
        System.out.println("Select conversion direction:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1/2): ");
        
        int choice = scanner.nextInt();

        double inputTemp, resultTemp;

        // Process based on user choice
        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            inputTemp = scanner.nextDouble();
            resultTemp = celsiusToFahrenheit(inputTemp);
            System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.\n", inputTemp, resultTemp);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            inputTemp = scanner.nextDouble();
            resultTemp = fahrenheitToCelsius(inputTemp);
            System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.\n", inputTemp, resultTemp);
        } else {
            System.out.println("Invalid choice. Please select either 1 or 2.");
        }

        scanner.close();
    }
}
