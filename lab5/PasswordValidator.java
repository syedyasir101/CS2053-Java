package lab_5;

import java.util.Scanner;

//Custom Exception Class
class WeakPasswordException extends Exception {
 public WeakPasswordException(String message) {
     super(message);
 }
}

public class PasswordValidator {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter your password: ");
     String password = scanner.nextLine();

     try {
         validatePassword(password);
         System.out.println("Password accepted.");
     } catch (WeakPasswordException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }

 // Method to validate password
 public static void validatePassword(String password) throws WeakPasswordException {
     if (password.length() < 6) {
         throw new WeakPasswordException("Password too short! Must be at least 6 characters.");
     }
 }
}
