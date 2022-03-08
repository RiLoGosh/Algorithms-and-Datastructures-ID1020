#include <stdio.h> 
#include <string.h>   




int readIter(int length){

    char text[length];
    int i = 0;
    char c = 0;
    while (c != '\n'){
        c = getchar();
        text[i++] = c;
    }
    
    for (int x = i; x >= 0; x--)
    {
        putchar(text[x]);
    }
    
    return 0;

}

int readRec(){
    char c = getchar();
    if (c != '\n')
    {
        readRec();
    }
    putchar(c);
    return 0;
}

int main()
{ 
    int length = 50;

    readIter(length);
    //readRec();
    printf("\n");
    return 0;
}