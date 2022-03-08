#include <stdio.h> 
#include <string.h>   

void display(int array[], int size){

    printf("[");
    for (int i = 0; i < size - 1; i++)
    {
        printf("%d, ", array[i]);
    }

    printf("%d]", array[size-1]);
    printf("\n");
    
}


void orderneg(int myArray[], int size){
    
    int temp;
    for (int i = 0; i < size; i++)
    {
        if (myArray[i] >= 0)
        {
            for (int j = i + 1; j < size; j++)
            {
                if (myArray[j] < 0)
                {
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                    display(myArray, size);
                }
            }
            
        }
        
    }
    
}


int main(){

    int array[7] = {-1, 1, -1, 1, -1, 1, -1};

    display(array, 7);

    orderneg(array, 7);

}