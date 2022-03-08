import java.util.NoSuchElementException;
import java.lang.reflect.Array;
import java.util.*;


public class BinarySearchST<someKey extends Comparable<someKey>, someValue> {

    public static class Couple<someKey, someValue>{

        public someKey key;
        public someValue value;

    }


    Couple<someKey, someValue>[] theTable;
    int noindex;

    public BinarySearchST(){
        theTable = (Couple<someKey, someValue>[])new Couple[8];
        noindex = 0;
    }

    private void resize(int newSize)
    {
        Couple<someKey, someValue>[] newPairs = (Couple<someKey, someValue>[])new Couple[newSize];

        System.arraycopy(theTable, 0, newPairs, 0, theTable.length);

        theTable = newPairs;
    }


    public void put(someKey key, someValue value){

        Couple<someKey, someValue> newcouple = new Couple<someKey, someValue>();
        newcouple.key = key;
        newcouple.value = value;

        if (noindex == 0 || key.compareTo(theTable[noindex - 1].key) > -1){
            theTable[noindex++] = newcouple;
            return;
        }


        int i = 0;
        for (; i < noindex - 1 && key.compareTo(theTable[i].key) < 0; i++);

        if (key.compareTo(theTable[i].key) == 0){
            theTable[i].value = value;

            return;
        }

        System.arraycopy(theTable, i, theTable, i + 1, noindex - i);

        theTable[i] = newcouple;

        noindex++;

        if (noindex > theTable.length / 2)
        {
            resize(theTable.length * 2);
        }


    }

    public int binarySearch(someKey key, int left, int right){


        if(right >= left){
            int middle = left + (right-left) / 2;
            int compare = key.compareTo(theTable[middle].key);

            if(compare == 0){
                return middle;
            }

            if (compare < 0){
                return binarySearch(key, left, middle-1);
            }

            if (compare > 0){
                return binarySearch(key, middle + 1, right);
            }
        }

        return -1;
    }


    public int findIndex(someKey key){

        return binarySearch(key, 0, noindex -1);

    }


    public someValue get(someKey key){

        int i = findIndex(key);

        if (i < 0){
            throw new NoSuchElementException();
        }

        return theTable[i].value;

    }


    public boolean contains(someKey key){

        return findIndex(key) >= 0;
    }

    public static void main(String[] args){

        BinarySearchST<String, Integer> myTable = new BinarySearchST<>();

        Scanner in = new Scanner(System.in);

        myTable.put("A", 1);
        myTable.put("B", 2);
        myTable.put("C", 3);
        myTable.put("D", 4);
        myTable.put("E", 5);
        myTable.put("A", 6);


        System.out.println(myTable.contains("A"));





        System.out.println(myTable.get("A"));
        System.out.println(myTable.get("B"));
        System.out.println(myTable.get("C"));
        System.out.println(myTable.get("A"));



    }

}
