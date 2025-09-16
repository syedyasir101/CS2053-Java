package lab_5;
import java.util.Scanner;
import java.util.Scanner;

public class DivisionExample {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter numerator: ");
		int numerator = sc.nextInt();
		
		System.out.print("Enter denominator: ");
		int denominator = sc.nextInt();
		
		try {
			int result = numerator / denominator;
			System.out.print("Result:" + result);
		}catch(ArithmeticException e) {
			System.out.println("Error:Cannot divide by zero!");
		}
		
		System.out.println("Program continues...");
		sc.close();
	}
}
