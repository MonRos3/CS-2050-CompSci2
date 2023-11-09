/***
 * MyStack.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This program provides the stack methods used by Program5.
 ***/
import java.util.EmptyStackException;
import java.util.Stack;
public class MyStack {
    private Stack<Character> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public void push(char value) {
        stack.push(value);
    }

    public char pop() {
        if (!isEmpty()) {
            return stack.pop();
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public char peek() {
        if (!isEmpty()) {
            return stack.peek();
        } else {
            throw new EmptyStackException();
        }
    }
}
