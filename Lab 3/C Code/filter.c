#include <stdio.h> 
#include <string.h> 
#include <ctype.h>

int main(){
    int x;

    while ((x = getchar()) | x != EOF)
    {
        if ((isalpha(x)) | (x == ' ') | (x == '\n'))
        {
            putchar(x);
        }
        else
        {
            putchar(' ');
        }
        
        
    }
    
}