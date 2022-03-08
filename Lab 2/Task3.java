import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {


    public static void countInversions(int array[]){

        for (int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if (array[i] > array[j]){
                    System.out.print("[" + i + ", " + array[i] + "], [" + j + ", " + array[j] + "]  ");
                    System.out.println();

                }
            }
        }
    }

    public static int factorial(int x){
        int fact = 1;
        for(int i = 2; i <= x; x++){
            fact = fact * i;
        }
        return fact;
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

        countInversions(myArray);


    }
}
