
### Blocking (synchronous) file reading:

- The program waits until the file read operation is complete before proceeding with the next task
- Simpler to programs since the flow of execution is linear
- Can cause performance issues if I/O operations are slow
- By default, file operations in C are blocking

> View `Blocking_Nonblocking_IO/demo_blocking/blocking.c`
### Non-blocking (asynchronous) file reading:

- The program initiates the file read operation and can continue with other tasks without waiting for the file to be fully read
- Requires more complex logic (e.g., polling, using event loops, or handling incomplete reads/writes)
- Commonly used in asynchronous programming and in environments where you need to handle multiple I/O sources simultaneously
- fcntl.h, unistd.h & errno.h

> View `Blocking_Nonblocking_IO/demo_nonblocking/nonblocking.c`
### Glossary:
- **Asynchronous programming** - a technique that enables a program to start a potentially long-running task and still be able to be responsive to other events while that task runs, rather than having to wait until that task has finished
- **File descriptor** - a unique identifier or reference that the operating system assigns to a file when it is opened
- **Polling** - a technique used in non-blocking I/O where a program continuously checks if a file descriptor is ready for reading or writing
