import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HashDistributions {

    private static final int n = 10;

    public static void main(String[] args) throws FileNotFoundException {

        File ElTexto = new File("/Users/atlas/Documents/KTH_WORK/Algorithms and Datastructures Round 2/Lab3/C-code/ElTexto.txt");
        Scanner text = new Scanner(ElTexto);

        List<String> wordlist = TextVoodoo.getWords((n * 100), text);

        BST<Integer, Integer> myTree = new BST<>();

        for (String word : wordlist){

                int hash = word.hashCode();

                if (myTree.contains(hash)){
                    myTree.put(hash, myTree.get(hash) + 1);

                }

                else{
                    myTree.put(hash, 1);
                }
            }




        myTree.infixRepresentation(myTree.Root);

    }


}
