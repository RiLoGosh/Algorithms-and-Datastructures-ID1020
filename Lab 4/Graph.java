import java.util.*;


public class Graph<item> {

    private int edges;
    private final SeparateChainingHash<item, lab4Stack<item>> TheGraph;

    public Graph(int v){
        TheGraph = new SeparateChainingHash<>(v);
        edges = 0;
    }

    public Iterable<item> vertex(){
        return TheGraph.keys();
    }

    public Iterable<item> adjacent(item a){
        return TheGraph.get(a);
    }

    public int edges(){
        return edges;
    }

    public void addEdge(item a, item b){
        lab4Stack<item> myStack;

        //If first item is not yet a vertex in the graph, then add it along with its edge
        if ((myStack = TheGraph.get(a)) == null){
            myStack = new lab4Stack<>();
            myStack.Push(b);
            TheGraph.put(a, myStack);

        }

        //If item already exists, just add another edge to it
        else{
            myStack.Push(b);
        }

        //If second item is not yet a vertex in graph, then add it along with its edge
        if ((myStack = TheGraph.get(b)) == null){
            myStack = new lab4Stack<>();
            myStack.Push(a);
            TheGraph.put(b, myStack);
        }

        //If item already exists, just add another edge to it
        else{
            myStack.Push(a);
        }

        edges++;

    }

}
