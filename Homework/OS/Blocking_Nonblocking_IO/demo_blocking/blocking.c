#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    FILE* inFile;
    char ch;

    inFile = fopen("reading.txt", "r");

    if (inFile == NULL) {
        printf("Error opening file \n");
        exit(-1);
    }

    FILE* outFile = fopen("writing.txt", "w");
    
    if (outFile == NULL) {
        printf("Error opening output file \n");
        fclose(inFile);
        exit(-1);
    }

    printf("Read from file: \n");

    while ((ch = fgetc(inFile)) != EOF) {
        printf("%c", ch);
        fputc(ch, outFile);  
    }

    fclose(inFile);
    fclose(outFile);
    return 0;
}