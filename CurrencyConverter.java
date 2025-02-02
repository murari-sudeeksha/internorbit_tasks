import java.util.Scanner;

public class CurrencyConverter {
    
    // Exchange rates as constants
    public static final double USD_TO_RUPEE_RATE = 83.47; 
    public static final double RUPEE_TO_USD_RATE = 0.0119804;
    public static final double EURO_TO_RUPEE_RATE = 89.10;
    public static final double RUPEE_TO_EURO_RATE = 0.0113;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Currency Converter!");

        // Infinite loop for continuous conversion until the user decides to exit
        while (true) {
            // Display the menu
            System.out.println("\n1. USD to Rupee");
            System.out.println("2. Rupee to USD");
            System.out.println("3. Euro to Rupee");
            System.out.println("4. Rupee to Euro");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1, 2, 3, 4 or 5 to exit): ");
            
            int choice = scanner.nextInt();
            
            // Exit the program if the user chooses option 5
            if (choice == 5) {
                System.out.println("Thank you for using Currency Converter!");
                break; // Exit the loop and terminate the program
            }

            double amount = 0.0;
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount in USD: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        System.out.printf("Converted amount in Rupee: ₹ %.2f\n", usdToRupee(amount));
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount in Rupee: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        System.out.printf("Converted amount in USD: $ %.2f\n", rupeeToUsd(amount));
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount in Euro: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        System.out.printf("Converted amount in Rupee: ₹ %.2f\n", euroToRupee(amount));
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                    break;
                case 4:
                    System.out.print("Enter the amount in Rupee: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        System.out.printf("Converted amount in Euro: € %.2f\n", rupeeToEuro(amount));
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Consume the invalid input
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, 4, or 5.");
            }
        }

        scanner.close(); // Close the scanner object
    }

    // Conversion methods
    public static double usdToRupee(double USD) {
        return USD * USD_TO_RUPEE_RATE;
    }

    public static double rupeeToUsd(double Rupee) {
        return Rupee * RUPEE_TO_USD_RATE;
    }

    public static double euroToRupee(double EURO) {
        return EURO * EURO_TO_RUPEE_RATE;
    }

    public static double rupeeToEuro(double Rupee) {
        return Rupee * RUPEE_TO_EURO_RATE;
    }
}
