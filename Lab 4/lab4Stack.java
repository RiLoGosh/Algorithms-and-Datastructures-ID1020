import java.util.Iterator;
import java.util.NoSuchElementException;

public class lab4Stack<Item> implements Iterable<Item> {
    private Node first;     // top of stack
    private int size;       // size of the stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public lab4Stack(){
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void Push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public Item Pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        size--;
        return item;                   // return the saved item
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

