#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h> // contains declarations for file control operations, including constants and functions used to manipulate file descriptors
    /*
        The open() function is declared in this header. This function is used to open files and set various flags (like O_RDONLY, O_WRONLY, O_CREAT, and O_NONBLOCK) to define the file access mode and behavior.
        The flags used in the open() call, such as O_NONBLOCK, are also defined here, allowing you to specify non-blocking I/O operations when opening files.
    */
#include <unistd.h> // provides access to the POSIX operating system API, including functions for file operations, process control, and other system calls
    /*
        The read() and write() functions are declared in this header. These functions are used for reading from and writing to file descriptors, respectively.
        The close() function, also declared here, is used to close file descriptors when they are no longer needed.
    */
#include <errno.h> // defines macros for reporting and retrieving error conditions through error codes && allows you to determine the reason for failure when system calls return errors
    /*
        The errno variable is set by system calls and some library functions in the event of an error to indicate what went wrong. You can check its value after a failed system call to handle errors appropriately.
        The macros defined in <errno.h>, such as EAGAIN and EWOULDBLOCK, are used to identify specific error conditions, particularly for non-blocking I/O operations
    */
#include <string.h>

int main()
{
    int inFile, outFile;
    char buffer[1024];
    ssize_t bytesRead, bytesWritten;

    inFile = open("reading2.txt", O_RDONLY | O_NONBLOCK);
    if (inFile < 0) {
        perror("Error opening input file");
        exit(-1);
    }

    outFile = open("writing.txt", O_WRONLY | O_CREAT, 0644); // 0644 -> allows r/w permissions for the owner of the file, and read-only for everyone else (if not -> file crash on open)
    if (outFile < 0) {
        perror("Error opening output file");
        close(inFile);
        exit(-1);
    }

    printf("Read from file: \n");

    while (1) {
        // read input
        bytesRead = read(inFile, buffer, sizeof(buffer));
        
        // If nothing was read and it's not due to an interruption or blocking -> exit loop
        if (bytesRead == 0) {
            break; // EOF
        } else if (bytesRead < 0) {
            if (errno == EAGAIN || errno == EWOULDBLOCK) {
                // No data available -> try again later
                continue;
            } else {
                perror("Error reading input file");
                break;
            }
        }

        // write the read data to the output file
        bytesWritten = write(outFile, buffer, bytesRead);
        if (bytesWritten < 0) {
            perror("Error writing to output file");
            break;
        }

        // Print the read content to stdout
        write(STDOUT_FILENO, buffer, bytesRead);
    }

    printf("\n");

    close(inFile);
    close(outFile);
    return 0;
}
