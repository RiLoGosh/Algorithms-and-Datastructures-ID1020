
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextVoodoo {

    private static final int HASHTABLE_SIZE = 1024;



    public static List<String> getWords(String line){


        List<String> words = new ArrayList<>();

        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == ' ')
            {
                continue;
            }

            // save the starting index of the word, then iterate till a space
            // is found or end is found
            int startIndex = i;
            for (; i < line.length() && line.charAt(i) != ' '; i++);

            // add word to the list of words
            words.add(line.substring(startIndex, i));


        }

        return words;

    }

    public static List<String> getWords(int max, Scanner in)
    {
        List<String> words = new ArrayList<>(max);

        // add all words in scanner or up to `max` words into the word list
        while (words.size() < max && in.hasNextLine())
        {
            // get the next line, take out all the words, and add them to
            // the total list
            String currentLine = in.nextLine();

            List<String> lineWords = getWords(currentLine);

            words.addAll(lineWords);
        }

        return words;
    }

    public static HashTable<String, List<Long>> createIndexTable(Scanner in)
    {
        HashTable<String, List<Long>> indexes =
                new HashTable<>(HASHTABLE_SIZE);

        // count is the character index (1-based index) while the input
        // has a next line
        for (long count = 1; in.hasNextLine();)
        {
            // go through each line of text and select everything in between
            // spaces
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++, count++)
            {
                // skip all spaces
                if (line.charAt(i) == ' ')
                {
                    continue;
                }

                // save the starting index of the word, then iterate till a space
                // is found or end is found.
                // also increment `count` for each character.
                int startIndex = i;
                for (; i < line.length() &&
                        line.charAt(i) == ' ';
                     i++, count++);

                // make it lowercase so it's consistent across all instances
                // of the word
                String word = line
                        .substring(startIndex, i)
                        .toLowerCase();

                // add the word to the table
                if (indexes.contains(word))
                {
                    indexes
                            .get(word)
                            .add(count);
                }
                else
                {
                    List<Long> wordIndexes = new ArrayList<>();
                    wordIndexes.add(count);

                    indexes.put(
                            word,
                            wordIndexes);
                }

                // i will increment and thus skip the space that was found
                // in the inner for loop
            }
        }

        return indexes;
    }



}
