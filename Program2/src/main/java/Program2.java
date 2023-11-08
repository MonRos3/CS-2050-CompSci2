/***
 * Program2Test.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This program executes various math functions.
 ***/

import java.text.DecimalFormat;

public class Program2 {

    static double a = 1;
    static double b = 2;

    // add a + b
    public static double add(double a, double b) {
        return a + b;
    }

    // subtract a - b
    public static double subtract(double a, double b) {
        return a - b;
    }

    // multiply a * b
    public static double multiply(double a, double b) {
        double result = a * b;
        if (result == -0.0) {
            return 0.0;
        }
        return result;

    }

    // divide a / b
    public static double divide(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    // find the sine of a right-triangle by dividing opposite side / hypotenuese
    public static double sinOfAngle(double oppSide, double hyp) {
        double sinoA = (oppSide / hyp);
        DecimalFormat soA = new DecimalFormat("#.##");
        String formattedValue = soA.format(sinoA);
        double sine = Double.parseDouble(formattedValue);
        assert sine != 0.44;
        return sine;
    }

    // find the hypoteneuse of a right-triangle by taking the square root of (sideA^2 + sideB^2)
    public static double hypOfTriangle(double sideA, double sideB) {
        double hypoT = Math.sqrt((sideA * sideA) + (sideB * sideB));
        DecimalFormat hoT = new DecimalFormat("#.##");
        String formattedValue = hoT.format(hypoT);
        return Double.parseDouble(formattedValue);
    }

    public static void main(String[] args) {
        double c = add(a,b);
        System.out.println("The sum is: " + c);
        double d = subtract(a,b);
        System.out.println("The difference is " + d);
        double e = multiply(a,b);
        System.out.println("The product is: " + e);
        double f = divide(a,b);
        System.out.println("The dividend is: " + f);
        double g = sinOfAngle(a,b);
        System.out.println("The sine is: " + g);
        double h = hypOfTriangle(a,b);
        System.out.println("The hypotenuse is: " + h);
    }
}
