package part1;

import java.util.Scanner;
public class Assignment5Part1 {

    public static double multiply (double a,double b){//mathematical operation functions
    double c = a * b;
    return c;
    }
    public static double dividing (double a,double b){
        double c = a / b;
        return c;
    }
    public static double add (double a,double b){
        double c = a + b;
        return c;
    }
    public static double subtraction (double a,double b){
        double c = a - b;
        return c;
    }

    static void main(String[] args) {
        Scanner cin = new Scanner(System.in); //scanner initialization

        System.out.printf("Enter first operand: \n");
        double first_operand = cin.nextDouble();
        System.out.printf("Enter operation: \n");
        char operation = cin.next().charAt(0);
        System.out.printf("Enter second operand: \n");
        double second_operand = cin.nextDouble();
        double result = switch (operation){  //A switch-case that checks a character and calls the corresponding function
            case '*' -> multiply(first_operand,second_operand);
            case '/' -> dividing(first_operand,second_operand);
            case '+'->add(first_operand,second_operand);
            default -> subtraction(first_operand,second_operand);
        };
        System.out.printf("Result  :%.4f", result);
    }
}
