package lab_5;

import java.util.Scanner;

// Custom exception class
class InAgeverification extends Exception {
    public InAgeverification(String message) {
        super(message);
    }
}

public class Ageverification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Fixed syntax: 'Scanner sc new Scanner...' → 'Scanner sc = new Scanner...'

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            // Checking condition and will display exception if invalid
            if (age < 18) {
                throw new InAgeverification("Age must be over 18");
            }
            System.out.println("Valid age: " + age);
        } catch (InAgeverification e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Program continues........");
            sc.close(); // Moved to finally block to ensure scanner is closed regardless of outcome
        }
    }
}
