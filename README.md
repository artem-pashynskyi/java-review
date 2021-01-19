# java-review

- BigDecimal

- Classes

- Collections
    - Set:
        - addAll() - combine two lists and remove duplicates
        - retainAll() - combine two lists and keep only common elements in both sets.
        - removeAll() - combine two lists and keep only items from the first set that we do not have in second set

- Core

- Enums

- Exceptions

- Inheritance:
    - Hexadecimal numeral system, often shortened to "hex", is a numeral system made up of 16 symbols (base 16). The standard numeral system is called decimal (base 10) and uses ten symbols: 0,1,2,3,4,5,6,7,8,9. Hexadecimal uses the decimal numbers and six extra symbols. There are no numerical symbols that represent values greater than nine, so letters taken from the English alphabet are used, specifically A, B, C, D, E and F. Hexadecimal A = decimal 10, and hexadecimal F = decimal 15.
    - @Override annotation help compiler to check for a valid method signature.
    - System.out.println - automatically applies toString() method to each object.
    - Inheritance represents an "IS A" relationship. 
 
- Interfaces:
    - Dependency Injection - Our classes should not instantiate their dependencies.
    - Divide big interfaces into smaller ones.
    - Interfaces(Contracts): to build loosely-coupled, extensible, testable applications. VS Abstract Classes(Partially-completed Classes): To share code.

- Lambda:
    - Functional Interfaces:
        - Consumer -> void consume(obj);
        - Supplier -> obj supply();
        - Function -> obj map(obj);
        - Predicate -> boolean test(condition);

- MapEntry

- OOP

- OOP Refactoring

- Streams
    - To process a collection of data in a declarative way.
    - Intermediate operations:
        - map() / flatMap()
        - filter()
        - limit(n) / skip(n)
        - takeWhile(predicate) / dropWhile(predicate)
        - sorted(Comparator.comparing(Movie::getTitle))
        - distinct()
        - peek()
    - Reducers:
        - count()
        - anyMatch(predicate)
        - allMatch(predicate)
        - noneMatch(predicate)
        - findFirst() / findAny()
        - max(comparator) / min(comparator)
    - Collectors:
        - toList()
        - toSet()
        - toMap()
        - summarizingInt()
        - joining()
        - groupingBy()
            
- Concurrency:
    - thread.start()
    - thread.sleep()
    - thread.join() - waits till thead is finished to proceed.
    - thread.interrupt() - do not actually stop the thread, but sends a request to stop thread, need to check for the interrupt status to stop.
    - Strategies to write thread safe code(to avoid Race conditions):
        - Confinement - create new object for each thread.
        - Immutability - Lock lock = new ReentrantLock(); - lock.lock() / lock.unlock() object while working on it.
        - Synchronization - synchronized keyword.
        - Volatile keyword - guarantees that changes to a field are visible across all threads.
        - Atomic objects 
            - Incrementing: AtomicInteger class is good for incrementing values and preferable over synchronization.
            - Adding: LongAdder / DoubleAdder classes are good for adding / incrementing values and preferable over synchronization.
        - Partitioning
            - ConcurrentMap
            - ConcurrentHashMap
            - ConcurrentLinkedDeque
            - ConcurrentSkipListSet
    - Collections.synchronizedCollection();    
    
- Executors:
    - Thread pool (Executors framework)
        - ExecutorService implementing classes:
            - ForkJoinPool
            - ScheduledThreadPoolExecutor
            - ThreadPoolExecutor
        - Executors framework - just simplifies thread manipulation, but does not solve concurrent issues while modifying same object.
        - Executors.newFixedThreadPool(2); - created new pool with 2 threads.
            - executor.submit() - submits a task to the thread pool.
            - executor.shutdown() - stops the thread pool, but only after all tasks are finished.
            - executor.shutdownNow() - stops the thread pool and forces all existing tasks to stop.  
        - CompletableFuture.runAsync(); - runs a task in the separate thread and continues the execution.
        - CompletableFuture.supplyAsync();
        
            
            
    