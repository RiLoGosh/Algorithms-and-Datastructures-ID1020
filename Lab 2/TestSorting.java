import java.util.Random;

public class TestSorting {

    public static final int range = 100;
    public static final int testAmount = 100;
    public static final int testSize1 = 10;
    public static final int testSize2 = 1000;
    public static final int cutoff = 30;



    public static void randomArray(int array[]){
        Random myRand = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = myRand.nextInt(range);
        }
    }

    public static long testCutoff(int size){
        int cutoffArray[] = new int[size];
        randomArray(cutoffArray);

        long starttime = System.nanoTime();
        CutOffSort.mergeSort(cutoffArray, cutoff);
        long endtime = System.nanoTime() - starttime;
        return endtime;
    }

    public static long testMergesort(int size){
        int mergeArray[] = new int[size];
        randomArray(mergeArray);

        long starttime = System.nanoTime();
        MergeSort.mergeSort(mergeArray);
        long endtime = System.nanoTime() - starttime;

        return endtime;
    }

    public static long testInsertion(int size){
        int insertionArray[] = new int[size];
        randomArray(insertionArray);

        long starttime = System.nanoTime();
        InsertionSort.sort(insertionArray);
        long endtime = System.nanoTime() - starttime;

        return endtime;
    }



    public static void main(String args[]){

        System.out.println();

        System.out.println("Insertion Sort:");

        System.out.println();
        System.out.println("Test Array Size = " + testSize1);
        int average = 0;
        long quickest = 999999;
        long slowest = 0;
        long temp;

        for (int i = 0; i < testAmount; i++){

            temp = testInsertion(testSize1);
            if (temp < quickest){
                quickest = temp;
            }
            if (temp > slowest){
                slowest = temp;
            }
            average += temp;


        }
        average = average / testAmount;

        System.out.println("Average:");
        System.out.println(average);
        System.out.println("Slowest time:");
        System.out.println(slowest);
        System.out.println("Quickest time:");
        System.out.println(quickest);

        average = 0;
        quickest = 9999999;
        slowest = 0;

        System.out.println();

        System.out.println("Test Array Size = " + testSize2);
        for (int i = 0; i < testAmount; i++){
            temp = testInsertion(testSize2);
            if (temp < quickest){
                quickest = temp;
            }
            if (temp > slowest){
                slowest = temp;
            }
            average += temp;
        }
        average = average / testAmount;

        System.out.println("Average:");
        System.out.println(average);
        System.out.println("Slowest time:");
        System.out.println(slowest);
        System.out.println("Quickest time:");
        System.out.println(quickest);


        average = 0;
        quickest = 999999;
        slowest = 0;

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("Merge Sort:");
        System.out.println();

        System.out.println("Test Size = " + testSize1);
        for (int i = 0; i < testAmount; i++){
            temp = testMergesort(testSize1);
            if (temp < quickest){
                quickest = temp;
            }
            if (temp > slowest){
                slowest = temp;
            }
            average += temp;
        }
        average = average / testAmount;


        System.out.println("Average:");
        System.out.println(average);
        System.out.println("Slowest time:");
        System.out.println(slowest);
        System.out.println("Quickest time:");
        System.out.println(quickest);

        average = 0;
        quickest = 999999;
        slowest = 0;

        System.out.println();

        System.out.println("Test Size = " + testSize2);
        for (int i = 0; i < testAmount; i++){
            temp = testMergesort(testSize2);
            if (temp < quickest){
                quickest = temp;
            }
            if (temp > slowest){
                slowest = temp;
            }
            average += temp;
        }
        average = average / testAmount;
        System.out.println("Average:");
        System.out.println(average);
        System.out.println("Slowest time:");
        System.out.println(slowest);
        System.out.println("Quickest time:");
        System.out.println(quickest);


        average = 0;
        quickest = 999999;
        slowest = 0;

        /*
        Testing Merge Sort with an insertion sort cut-off
         */


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Cut-Off Merge Sort w/ Insertion Sort:");
        System.out.println();

        System.out.println("Test Size = " + testSize1);
        for (int i = 0; i < testAmount; i++){
            temp = testCutoff(testSize1);
            if (temp < quickest){
                quickest = temp;
            }
            if (temp > slowest){
                slowest = temp;
            }
            average += temp;
        }
        average = average / testAmount;


        System.out.println("Average:");
        System.out.println(average);
        System.out.println("Slowest time:");
        System.out.println(slowest);
        System.out.println("Quickest time:");
        System.out.println(quickest);


        average = 0;
        quickest = 999999;
        slowest = 0;

        System.out.println();

        System.out.println("Test Size = " + testSize2);
        for (int i = 0; i < testAmount; i++){
            temp = testCutoff(testSize2);
            if (temp < quickest){
                quickest = temp;
            }
            if (temp > slowest){
                slowest = temp;
            }
            average += temp;
        }
        average = average / testAmount;
        System.out.println("Average:");
        System.out.println(average);
        System.out.println("Slowest time:");
        System.out.println(slowest);
        System.out.println("Quickest time:");
        System.out.println(quickest);







    }



}
