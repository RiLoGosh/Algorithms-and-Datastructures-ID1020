import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BFS {

    private SeparateChainingHash<String, Boolean> marked;
    private SeparateChainingHash<String, String> edgeTo;
    public final String Origin;

    public BFS(Graph<String> myGraph, String ori){
        marked = new SeparateChainingHash<>(13);
        edgeTo = new SeparateChainingHash<>(13);
        Origin = ori;

        for (String node : myGraph.vertex()){
            marked.put(node, false);
        }

        breadthFirstSearch(myGraph, ori);
    }

    public void breadthFirstSearch(Graph<String> myGraph, String ori){

        CDLLQueue<String> myQueue = new CDLLQueue<>();
        marked.put(ori, true);

        myQueue.enqueue(ori);

        while(!myQueue.isEmpty()){

            String nexus = myQueue.dequeue();

            for (String node : myGraph.adjacent(nexus)){

                if (!marked.get(node)){
                    marked.put(node, true);
                    edgeTo.put(node, nexus);
                    myQueue.enqueue(node);
                }

            }
        }

    }

    public boolean hasPath(String destination){
        if(marked.get(destination) != null){
            return true;
        }
        return false;
    }

    public Iterable<String> pathTo(String destination){

        if (!hasPath(destination)){
            return null;
        }

        lab4Stack<String> path = new lab4Stack<>();

        for (String s = destination; !s.equals(Origin); s = edgeTo.get(s)){
            path.Push(s);
        }

        path.Push(Origin);
        return path;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File ElTexto = new File("/Users/atlas/Documents/KTH_WORK/Algorithms and Datastructures Round 2/Lab4/contiguous-usa.dat.txt");
        Scanner text = new Scanner(ElTexto);

        Graph<String> myGraph = new Graph<>(13);

        while(text.hasNext()){
            String a = text.next();
            String b = text.next();
            myGraph.addEdge(a, b);
        }

        String origin;
        String destination;

        Scanner in = new Scanner(System.in);

        System.out.println("What is the origin state/vertex?");
        origin = in.nextLine().toUpperCase();

        System.out.println("What is the destination?");
        destination = in.nextLine().toUpperCase();

        BFS pathFinder = new BFS(myGraph, origin);
        for (String s : pathFinder.pathTo(destination)){
            System.out.print("[" + s + "]");
            if(!s.equals(destination)) {
                System.out.print("->");
            }
        }

    }


}
