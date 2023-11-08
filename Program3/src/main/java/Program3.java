/***
 * Program3.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This program converts infix notation to postfix notation.
 ***/

import java.util.EmptyStackException;
import java.io.*;

public class Program3 {

    char[] operators = { '(', ')', '*', '/', '+', '-', '%'};

    private static boolean isOperator(char o){
        return o == '(' || o == ')' || o == '*' || o == '/' || o == '%' || o == '+' || o == '-';
    }

    static int orderOfOps(char operator){
        int order;
        switch(operator){
            case '(':
                order = 1;
                break;
            case '*':
                order = 2;
                break;
            case '/':
                order = 3;
                break;
            case '%':
                order = 4;
                break;
            case '+':
                order = 5;
                break;
            case '-':
                order = 6;
                break;
            case ')':
                order = 7;
                break;
            default:
                order = 0;
                break;
        }
        return order;
    }

    public static String infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        ArrayStackClass stack = new ArrayStackClass(300);

        for (int i = 0; i < s.length(); i++) {
            char o = s.charAt(i);

            if (Character.isDigit(o) || o == '.') {
                // If it's a digit or a decimal point, append to postfix
                postfix.append(o);
            } else if (isOperator(o)) {
                // Handle operators
                while (!stack.isEmpty() && isOperator(stack.peek()) &&
                        orderOfOps(o) <= orderOfOps(stack.peek())) {
                    char poppedOperator = stack.pop();
                    if (poppedOperator != ' ') {
                        postfix.append(" ").append(poppedOperator);
                    }
                }
                stack.push(o);
            } else if (o == '(') {
                stack.push(o);
            } else if (o == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char poppedOperator = stack.pop();
                    if (poppedOperator != ' ') {
                        postfix.append(" ").append(poppedOperator);
                    }
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "Unmatched parenthesis.";
                }
            } else if (!Character.isWhitespace(o)) {
                return "Invalid character: " + o;
            }
        }
        return postfix.toString().trim();
    }

    public static void main(String[] args) {
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("Program3.txt"));
            BufferedWriter outputFile = new BufferedWriter(new FileWriter("Program3.out"));
            String line;

            while ((line = inputFile.readLine()) != null) {
                String infixNotation = line.trim();
                String postfixNotation = infixToPostfix(infixNotation);
                outputFile.write(infixNotation + " --> " + postfixNotation + "\n");
            }

            inputFile.close();
            outputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}