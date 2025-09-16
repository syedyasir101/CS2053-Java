package lab_5;

import java.util.Scanner;

//Custom Exception Class
class InvalidMarksException extends Exception {
 public InvalidMarksException(String message) {
     super(message);
 }
}

public class MarksValidator {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter marks (0-100): ");
     int marks = scanner.nextInt();

     try {
         validateMarks(marks);
         System.out.println("Marks entered: " + marks);
     } catch (InvalidMarksException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }

 // Method to validate marks
 public static void validateMarks(int marks) throws InvalidMarksException {
     if (marks < 0 || marks > 100) {
         throw new InvalidMarksException("Marks should be between 0 and 100.");
     }
 }
}
