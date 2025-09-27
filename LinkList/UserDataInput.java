import java.util.Scanner;

public class UserDataInput {

    public static void main(String[] args) {
        // 1. Create a Scanner object for reading user input
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Student Data Input ---");

            // 2. Get the user's name (String)
            System.out.print("Enter your full name: ");
            String name = scanner.nextLine();

            // 3. Get the user's GPA (Double)
            // We use a loop to ensure the input is a valid number.
            double gpa = 0.0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter your GPA (e.g., 3.85): ");
                if (scanner.hasNextDouble()) {
                    gpa = scanner.nextDouble();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a numerical value for GPA.");
                    scanner.next(); // Consume the invalid input to prevent an infinite loop
                }
            }

            // 4. Display the collected information
            System.out.println("\n--- Input Summary ---");
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        }
    }
}