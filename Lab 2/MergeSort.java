import java.util.*;

public class MergeSort {

    public static int[] mergeSort(int array[]){

        if(array.length > 1){
            int middle = (array.length) / 2;

            int firsthalf[] = mergeSort(
                    Arrays.copyOfRange(array, 0, middle)
            );

            int secondhalf[] = mergeSort(
                    Arrays.copyOfRange(array, middle, array.length)
            );

            int newArray[] = merge(firsthalf, secondhalf);

            return newArray;
        }

        else{
            return array;
        }
    }


    public static int[] merge(int firsthalf[], int secondhalf[]){

        int finalArray[] = new int[firsthalf.length + secondhalf.length];
        int findex = 0;
        int sindex = 0;
        int endex = 0;

        while (findex < firsthalf.length && sindex < secondhalf.length){

            if(firsthalf[findex] < secondhalf[sindex]){
                finalArray[endex++] = firsthalf[findex++];

            }

            else{
                finalArray[endex++] = secondhalf[sindex++];

            }
        }

        while(findex < firsthalf.length){
            finalArray[endex++] = firsthalf[findex++];
        }

        while(sindex < secondhalf.length){
            finalArray[endex++] = secondhalf[sindex++];
        }

        return finalArray;
    }

    public static void Display(int myArr[]){
        for (int i = 0; i < myArr.length; i++){
            System.out.print(myArr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String args[]){

        int array[] = {5, 4, 3, 2, 1};

        Display(array);



        Display(mergeSort(array));

    }
}
