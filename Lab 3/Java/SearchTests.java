import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class SearchTests {

    private static final int testCount = 1000;
    private static final int n = 10;


    public static long symbolTableTest (List<String> wordlist){

        BinarySearchST<String, Integer> myTable = new BinarySearchST<>();

        long starttime = System.nanoTime();

        for (String word : wordlist){

            if (myTable.contains(word)){

                myTable.put(word, (myTable.get(word) + 1));

            }
            else{
                myTable.put(word, 1);
            }
        }

        long endtime = System.nanoTime();

        return (endtime - starttime);

    }

    public static long searchTreeTest (List<String> wordlist){

        BST<String, Integer> myTree = new BST<>();

        long starttime = System.nanoTime();

        for (String word : wordlist){

            if (myTree.contains(word)){
                myTree.put(word, myTree.get(word) + 1);
            }

            else{
                myTree.put(word, 1);
            }

        }

        long endtime = System.nanoTime();

        return endtime - starttime;

    }


    public static void main(String[] args) throws FileNotFoundException{


        File ElTexto = new File("/Users/atlas/Documents/KTH_WORK/Algorithms and Datastructures Round 2/Lab3/C-code/ElTexto.txt");
        Scanner text = new Scanner(ElTexto);

        List<String> wordlist = TextVoodoo.getWords((n * 100), text);



        long symbolTableMean = 0;
        long treeMean = 0;

        for (int i = 0; i < testCount; i++){
            symbolTableMean += symbolTableTest(wordlist);
            treeMean += searchTreeTest(wordlist);
        }

        symbolTableMean = symbolTableMean/testCount;
        treeMean = treeMean/testCount;

        System.out.println();
        System.out.println("Symbol Table test average time:");
        System.out.println(symbolTableMean);
        System.out.println();
        System.out.println();
        System.out.println("Search Tree average time:");
        System.out.println(treeMean);
        System.out.println();


    }





}
