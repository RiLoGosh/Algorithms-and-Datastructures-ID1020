import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class WordIndex {

    public static void main(String[] args) throws FileNotFoundException {
        File ElTexto = new File("/Users/atlas/Documents/KTH_WORK/Algorithms and Datastructures Round 2/Lab3/C-code/ElTexto.txt");
        Scanner text = new Scanner(ElTexto);

        HashTable<String, List<Long>> indexes = TextVoodoo.createIndexTable(text);

        Scanner in = new Scanner(System.in);


        while(1==1){

            System.out.println("What word would you like to find out about?");

            String input = in.nextLine();

            if (input.length() == 0){
                break;
            }

            String lowercaseWord = input.toLowerCase();


            if (indexes.contains(input)){

                System.out.printf("@ %s\n", indexes.get(lowercaseWord));


            }
            else{
                System.out.println("That word was not found in the text.");
            }
        }


    }

}
