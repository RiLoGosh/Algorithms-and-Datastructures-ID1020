import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class CDLLQueue<item> implements Iterable<item>{

    private Node sentinel;
    private int size;

    public CDLLQueue(){
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    private class Node{
        Node next;
        Node prev;
        item value;
    }

    //checks if list is empty
    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }

    public void enqueue(item value){
        Node n = new Node();
        n.value = value;
        n.next = sentinel;
        n.prev = sentinel.prev;
        sentinel.prev.next = n;
        sentinel.prev = n;
        size++;
    }

    public item dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        item theItem = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return theItem;
    }

    public Iterator<item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<item> {
        private Node n = sentinel;

        public boolean hasNext() {
            return n.next != sentinel;
        }

        public void remove() {
        }

        public item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in queue!");
            }
            n = n.next;
            return n.value;
        }
    }


}
