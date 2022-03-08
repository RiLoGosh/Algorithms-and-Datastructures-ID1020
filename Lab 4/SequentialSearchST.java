public class SequentialSearchST<Key, Value> {

    private int Size;
    private Node start;

    private class Node { // linked-list node
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.value = val;
            this.next = next;
        }
    }

    public int size(){
        return Size;
    }

    public Value get(Key key){

        for (Node x = start; x != null; x = x.next){
            if (key.equals(x.key)){
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value){

        //Update value if key is found
        for (Node x = start; x != null; x = x.next){
            if (key.equals(x.key)){
                x.value = value;
                return;
            }
        }

        //Else add new node if key is not found
        start = new Node(key, value, start);
        Size++;
    }

    public Iterable<Key> keys()  {
        CDLLQueue<Key> myQueue = new CDLLQueue<>();
        for (Node x = start; x != null; x = x.next) {
            myQueue.enqueue(x.key);
        }
        return myQueue;
    }

}
