import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double b = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *): ");
        String operator = scanner.next();

        if (!OperationFactory.exists(operator)){
            System.out.println("Invalid operator :(");
            return;
        }

        Operation operation = OperationFactory.getOperation(operator);

        double result = operation.calculate(a, b);
        
        System.out.println("The result is: " + result);
    }
}
