/***
 * ArrayStackClass.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This class constructs a stack frame for an equation.
 ***/
import java.util.EmptyStackException;

public class ArrayStackClass {
    private char[] stack;
    private int top;
    private int stackSize;

    public ArrayStackClass(int capacity) {
        stack = new char[capacity];
        top = -1;
    }

    public int getTop() {
        return top;
    }

    public void push(char value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        } else {
            System.out.println("Stack is full.");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public char peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            throw new EmptyStackException();
        }
    }
}