#include <stdio.h> 
#include <string.h> 
#include <ctype.h>

#define maxchar 1000;


int filter(FILE *text){

    int max = 1000;
    char x;
    int i = 0;

    while ((x = fgetc(text) != NULL | x != EOF) && i < max)
    {
        
            if (isalpha(x) || x == ' ' || x == '\n'){
                puts(x);
            }
            else
            {
                putchar(' ');
            }
            i++;
        
        
    }
    

    return 0;
}


int main(){
    FILE *myFile;
    char* filename = "/Users/atlas/Documents/KTH_WORK/Algorithms and Datastructures Round 2/Lab3/C-code/ElTexto.txt";
    myFile = fopen(filename, "r");
    if(myFile == NULL){
        printf("Could not open file %s '\n'",filename);
    }
    else
    {
        filter(myFile);
    }
    

}