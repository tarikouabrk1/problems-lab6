package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addFirst(book);  // LIFO: add to top
    }

    public Book pop() {
        return stack.removeFirst();  // remove from top
    }

    public Book peek() {
        return stack.getFirst();  // view top element
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book book : stack) {
            System.out.println("- " + book);
        }
    }
}
