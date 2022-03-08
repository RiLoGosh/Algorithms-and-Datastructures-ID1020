import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    public static int totalswaps = 0;

    public static void sort(int array[]){

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int k = i - 1;

            int swapcounter = 0;

            while (k >= 0 && array[k] > key) {
                array[k + 1] = array[k];
                k = k - 1;

                if (swapcounter != 1){
                    swapcounter++;
                }
            }
            array[k + 1] = key;

            if(swapcounter == 1){
                totalswaps++;
            }

            Display(array);

        }

    }

    public static void Display(int myArr[]){
        for (int i = 0; i < myArr.length; i++){
            System.out.print(myArr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {

        Scanner myScan = new Scanner(System.in);

        /*
        System.out.print("How large would you like the list to be?");
        int size = myScan.nextInt();
        System.out.println("Please enter values");
        int[] myArray = new int[size];
        for(int i = 0; i < size; i++){
            System.out.println("Next int?");
            myArray[i] = myScan.nextInt();
        }*/

        int myArray[] = { 12, 11, 13, 5, 6 };
        System.out.println("Input done.");
        Display(myArray);
        System.out.println();

        sort(myArray);

        System.out.println();
        System.out.println("Number of Swaps:");
        System.out.println(totalswaps);


    }
}
