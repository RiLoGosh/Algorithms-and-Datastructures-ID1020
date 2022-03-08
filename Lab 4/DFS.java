import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DFS {

    private SeparateChainingHash<String, Boolean> marked;
    private SeparateChainingHash<String, String> edgeTo;
    public final String Origin;

    public DFS(Graph<String> myGraph, String origin){
        marked = new SeparateChainingHash<>(13);

        for (String node : myGraph.vertex()){
            marked.put(node, false);
        }

        edgeTo = new SeparateChainingHash<>(13);
        Origin = origin;
        depthFirstSearch(myGraph, origin);
    }


    public void depthFirstSearch(Graph<String> myGraph, String origin){
        marked.put(origin, true);
        for (String nextnode : myGraph.adjacent(origin)){

            if(!marked.get(nextnode)){
                edgeTo.put(nextnode, origin);
                depthFirstSearch(myGraph, nextnode);
            }
        }
    }

    public boolean hasPathto(String destination){
        if(marked.get(destination) != null){
            return true;
        }
        return false;
    }

    public Iterable<String> pathTo(String destination){
        if(!hasPathto(destination)){
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

        DFS pathFinder = new DFS(myGraph, origin);
        for (String s : pathFinder.pathTo(destination)){
            System.out.print("[" + s + "]");
            if(!s.equals(destination)) {
                System.out.print("->");
            }
        }

    }

}
