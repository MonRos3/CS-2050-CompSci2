/***
 * MyLinkedStack.java
 * Monica Ball - CS 2050-001
 * Professor Blanche
 *
 * This class constructs a linked list stack for an equation.
 ***/
import java.util.EmptyStackException;
public class MyLinkedStack {
    private Node head;
    private int size;

    public MyLinkedStack() {
        head = null;
        size = 0;
    }

    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public char pop() {
        if (!isEmpty()) {
            char value = head.data;
            head = head.next;
            size--;
            return value;
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public char peek() {
        if (!isEmpty()) {
            return head.data;
        } else {
            throw new EmptyStackException();
        }
    }

    private class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
}
