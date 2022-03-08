import java.util.*;
import java.util.Queue;

public class SeparateChainingHash<Key, Value> {

    private static final int TableSize = 997;
    private int TheSize;
    private int X;
    private SequentialSearchST<Key, Value>[] TheTable;


    public SeparateChainingHash(){
        this(TableSize);
    }


    public SeparateChainingHash(int x){
        this.X = x;
        TheTable = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[X];

        for (int i = 0; i < X; i++){
            TheTable[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % X;
    }

    public int size(){
        return TheSize;
    }

    public Value get(Key key){
        return (Value) TheTable[hash(key)].get(key);
    }

    public void put(Key key, Value value){
        if (get(key) == null){
            TheSize++;
        }
        TheTable[hash(key)].put(key, value);
    }

    public Iterable<Key> keys(){
        CDLLQueue<Key> myQueue = new CDLLQueue<>();

        for (int i = 0; i < X; i++){
            for (Key key : TheTable[i].keys()){
                myQueue.enqueue(key);
            }
        }
        return myQueue;
    }


}
