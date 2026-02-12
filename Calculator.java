
import java.util.Scanner;

public class Calculator {

    public double calculate(double a, double b, String operator) {
        double result = 0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = (b != 0) ? a / b : 0;
                break;
            default:
                System.out.println("Invalid Operator");
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator obj = new Calculator();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();   // accepts int, float, double

        System.out.print("Enter operator (+, -, *, /): ");
        String op = sc.next();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        double result = obj.calculate(a, b, op);

        System.out.println("Result: " + result);
    }
}
