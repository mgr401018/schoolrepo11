import math
import multiprocessing
import threading
import time
 
def intensive_calculation(thread_id):
    result = 0
    iterations = 10_000_000
 
    for i in range(iterations):
        result += math.sqrt(i)
        if i % (iterations // 10) == 0:
            print(thread_id, end="", flush=True)
 
def single_execution():
    print("1a single call:")
    start_time = time.time()
 
    intensive_calculation(1)
 
    end_time = time.time()
    print(f"\n1b single call time(sec): {end_time - start_time:.2f}")
 
def parallel_execution_with_processes(process_count):
    print("2a start multiprocessing:")
    start_time = time.time()
 
    processes = []
    for i in range(process_count):
        process = multiprocessing.Process(target=intensive_calculation, args=(i + 1,))
        processes.append(process)
        process.start()
 
    for process in processes:
        process.join()
 
    end_time = time.time()
    print(f"\n2b multiprocessing time(sec): {end_time - start_time:.2f}")
 
def parallel_execution_with_threads(thread_count):
    print("3a start threading:")
    start_time = time.time()
 
    threads = []
    for i in range(thread_count):
        thread = threading.Thread(target=intensive_calculation, args=(i + 1,))
        threads.append(thread)
        thread.start()
 
    for thread in threads:
        thread.join()
 
    end_time = time.time()
    print(f"\n3b threading time(sec): {end_time - start_time:.2f}")
 
def high_contention_execution(worker_count, mode):
    print(f"{mode[0]}a start {mode}:")
    start_time = time.time()
 
    if mode == "multiprocessing":
        processes = []
        for i in range(worker_count):
            process = multiprocessing.Process(target=intensive_calculation, args=(i + 1,))
            processes.append(process)
            process.start()
 
        for process in processes:
            process.join()
    elif mode == "threading":
        threads = []
        for i in range(worker_count):
            thread = threading.Thread(target=intensive_calculation, args=(i + 1,))
            threads.append(thread)
            thread.start()
 
        for thread in threads:
            thread.join()
 
    end_time = time.time()
    print(f"\n{mode[0]}b {mode} time(sec): {end_time - start_time:.2f}")
 
def main():
    cpu_count = multiprocessing.cpu_count()
 
    single_execution()
 
    parallel_execution_with_processes(cpu_count)
 
    parallel_execution_with_threads(cpu_count)
 
    high_contention_execution(cpu_count * 4, "multiprocessing")
 
    high_contention_execution(cpu_count * 4, "threading")
 
if __name__ == "__main__":
    main()