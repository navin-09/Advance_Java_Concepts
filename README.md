# Generics


| Concept            | Description                                                           | Example                             |
| ------------------ | --------------------------------------------------------------------- | ----------------------------------- |
| **Generic Type**   | Allows parameterized type (e.g., `Box<T>`)                            | `Box<Integer>`                      |
| **Generic Method** | Declares type `<T>` per method                                        | `<T> void print(T item)`            |
| **Bounded Type**   | Restrict types that can be used                                       | `<T extends Number>`                |
| **Wildcard `?`**   | Placeholder for unknown type                                          | `List<?>`, `List<? extends Number>` |
| **Type Erasure**   | Generics are a compile-time feature — at runtime, all become `Object` | (No runtime type info for T)        |
| **Advantages**     | Type safety, reusability, no casting                                  | —                                   |

# What is the Java Collections Framework (JCF)?

    The Java Collections Framework is a set of interfaces, classes, and algorithms that make it easy to store, access, and manipulate groups of objects efficiently.

# Collections graph

Collection Framework Hierarchy in Java
──────────────────────────────────────

                                Iterable
                                   ▲
                                   │
                              Collection
             ┌──────────────────┼──────────────────┐
             │                  │                  │
            List               Queue               Set
             │                  │                  │
 ┌───────────┼──────────┐       │        ┌─────────┼─────────┐
 │           │          │       │        │         │         │
ArrayList  LinkedList  Vector  PriorityQueue     HashSet  SortedSet
                        │           │               │         │
                      Stack       Deque      LinkedHashSet   TreeSet
                                   │
                               ArrayDeque


                               ┌──────────────────────────────┐
                               │         Map<K,V>             │
                               └──────────────┬───────────────┘
                                              │
     ┌────────────────────────────┬───────────┼───────────────┬────────────────────────────┐
     │                            │           │               │                            │
 ┌───▼────┐                 ┌─────▼────┐  ┌───▼────┐     ┌────▼────┐                ┌──────▼──────┐
 │ HashMap│                 │TreeMap   │  │LinkedHM│     │Hashtable│                │ConcurrentHM │
 └───┬────┘                 └──────────┘  └────────┘     └─────────┘                └─────────────┘
     │
     ▼
 LinkedHashMap


# Core Interfaces

| Interface | Description                          | Example Class                         | Allows Duplicates? | Ordered?                                                                     |
| --------- | ------------------------------------ | ------------------------------------- | ------------------ | ---------------------------------------------------------------------------- |
| **List**  | Ordered collection (index-based)     | `ArrayList`, `LinkedList`, `Vector`   | ✅ Yes              | ✅ Yes                                                                        |
| **Set**   | Unique elements only                 | `HashSet`, `LinkedHashSet`, `TreeSet` | ❌ No               | ❌ HashSet (unordered), ✅ LinkedHashSet (insertion order), ✅ TreeSet (sorted) |
| **Queue** | FIFO structure (First-In, First-Out) | `LinkedList`, `PriorityQueue`         | ✅ Yes              | Partially                                                                    |
| **Map**   | Key–Value pairs                      | `HashMap`, `TreeMap`, `LinkedHashMap` | Keys ❌, Values ✅   | Depends on implementation                                                    |

# Key Points Summary

| Interface | Implementation                  | Order      | Duplicates       | Sorted            | Notes                    |
| --------- | ------------------------------- | ---------- | ---------------- | ----------------- | ------------------------ |
| **List**  | ArrayList, LinkedList           | ✅ Yes      | ✅ Yes            | ❌ No              | Index-based              |
| **Set**   | HashSet, TreeSet, LinkedHashSet | ⚠️ Depends | ❌ No             | ⚠️ TreeSet only   | Unique elements          |
| **Queue** | LinkedList, PriorityQueue       | FIFO       | ✅ Yes            | ⚠️ Priority-based | Use for tasks or buffers |
| **Map**   | HashMap, TreeMap, LinkedHashMap | ⚠️ Depends | Keys ❌, Values ✅ | ⚠️ TreeMap sorted | Key–Value pairs          |


# ArrayList — Dynamic Array
    ✅ Fast random access (by index).
    ⚠️ Slower insertion/removal in the middle.

# LinkedList — Doubly Linked List
    ✅ Fast insertion/removal.
    ⚠️ Slower random access.

# HashSet — Unique Unordered Elements
    ✅ Unique elements.
    ⚠️ No guaranteed order.

# LinkedHashSet — Unique + Preserves Order
    ✅ Unique and ordered.

# TreeSet — Sorted Set
    ✅ Automatically sorted.
    ⚠️ Slower than HashSet.

# HashMap — Key–Value Storage
    ✅ Fast key lookups.
    ⚠️ No ordering.

# LinkedHashMap — Ordered Map
    ✅ Insertion Ordering.

# TreeMap — Sorted by Key
    ✅ Sorted automatically by key.
    ⚠️ Slightly slower than HashMap.


# What is a Functional Interface?
    A Functional Interface is an interface that has exactly one abstract method.

    @FunctionalInterface
    interface Greeting {
        void sayHello(String name);
    }

# What is SAM (Single Abstract Method)?
    SAM is just a technical term meaning “an interface with one abstract method.”
    Every Functional Interface = SAM Interface ✅

# Why Functional Interfaces Exist
    Before Java 8, you’d write anonymous classes like this:

    Runnable r = new Runnable() {
    public void run() {
        System.out.println("Running...");
        }
    };

    After Java 8, using functional interfaces, you can replace that with a lambda:

    Runnable r = () -> System.out.println("Running...");

# Built-in Functional Interfaces (from java.util.function)

| Interface             | Method                   | Purpose                          | Example                            |
| --------------------- | ------------------------ | -------------------------------- | ---------------------------------- |
| `Runnable`            | `void run()`             | Represents a task                | `new Thread(() -> …)`              |
| `Callable<V>`         | `V call()`               | Task that returns value          | Used with ExecutorService          |
| `Supplier<T>`         | `T get()`                | Supplies a value (no input)      | e.g., `() -> 42`                   |
| `Consumer<T>`         | `void accept(T t)`       | Consumes a value (no return)     | e.g., `x -> System.out.println(x)` |
| `Function<T, R>`      | `R apply(T t)`           | Maps one type to another         | e.g., `x -> x * 2`                 |
| `Predicate<T>`        | `boolean test(T t)`      | Tests a condition                | e.g., `x -> x > 10`                |
| `BiConsumer<T, U>`    | `void accept(T t, U u)`  | Takes 2 arguments                | e.g., `(a,b) -> …`                 |
| `BiFunction<T, U, R>` | `R apply(T t, U u)`      | Takes 2 inputs, returns 1 output | e.g., `(a,b)->a+b`                 |
| `BiPredicate<T, U>`   | `boolean test(T t, U u)` | Takes 2 inputs, returns boolean  | e.g., `(a,b)->a>b`                 |

| Concept                          | Description                                       | Example                                                 |
| -------------------------------- | ------------------------------------------------- | ------------------------------------------------------- |
| **Functional Interface**         | Interface with exactly one abstract method        | `Runnable`, `Callable`, `Supplier`, etc.                |
| **SAM (Single Abstract Method)** | A property of all functional interfaces           | `void run()` in `Runnable`                              |
| **Lambda Expression**            | Shorthand for implementing a functional interface | `() -> System.out.println("Run")`                       |
| **@FunctionalInterface**         | Annotation to enforce SAM rule                    | `@FunctionalInterface interface MyFunc { void run(); }` |
| **Package**                      | Most built-ins are in `java.util.function`        | `Predicate`, `Function`, etc.                           |

# What is a Lambda Function?
    A lambda function (or lambda expression) is a short block of code that takes parameters and returns a value — without needing a name or a full class.


| Syntax                                          | Meaning                        |
| ----------------------------------------------- | ------------------------------ |
| `(a, b) -> a + b`                               | Lambda that adds two numbers   |
| `(name) -> System.out.println("Hello " + name)` | Lambda that prints             |
| `() -> 42`                                      | Lambda that returns a constant |
| `(x) -> { int y = x * 2; return y; }`           | Multi-statement lambda body    |

| Benefit                              | Description                                        |
| ------------------------------------ | -------------------------------------------------- |
| ✅ **Concise**                        | No boilerplate (no class or method names)          |
| ⚙️ **Readable**                      | Focus on *what* you do, not *how*                  |
| 💡 **Functional Programming**        | Treat code as data — pass behavior around          |
| 🚀 **Used in Streams & Collections** | `filter()`, `map()`, `forEach()`, etc.             |
| 🔒 **Thread-friendly**               | Works seamlessly with `Runnable`, `Callable`, etc. |

| Concept               | Description                                                | Example                                  |
| --------------------- | ---------------------------------------------------------- | ---------------------------------------- |
| **Lambda Expression** | Shorthand for anonymous function                           | `(x, y) -> x + y`                        |
| **Works With**        | Functional interfaces (SAM interfaces)                     | `Runnable`, `Callable`, `Function`, etc. |
| **Syntax**            | `(parameters) -> expression` or `(parameters) -> { body }` | `(a, b) -> a + b`                        |
| **Main Use**          | Pass code as data, simplify callbacks, use with Streams    | `list.forEach(x -> ...)`                 |


What is a Stream in Java?

    A Stream is a sequence of elements that can be processed in a functional way — like filtering, transforming, or collecting data — without modifying the original collection.

    -> A Stream doesn’t store data.

    -> It pulls data from a source (like a List, array, or file).

    -> You apply a pipeline of operations (filter, map, sort, reduce, etc.).

    -> The Stream runs when you call a terminal operation (like collect() or forEach()).

Stream Pipeline Structure

    Source → Intermediate Operations → Terminal Operation

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    int sum = numbers.stream()                // 1️⃣ Source
                    .filter(n -> n % 2 == 0) // 2️⃣ Intermediate (keep evens)
                    .mapToInt(n -> n * n)    // 3️⃣ Intermediate (square each)
                    .sum();                  // 4️⃣ Terminal (sum of all)
                    
    System.out.println(sum); // Output: 56

Intermediate Operations (Transform or Filter)

| Operation           | Description                         | Example                      |
| ------------------- | ----------------------------------- | ---------------------------- |
| `filter(Predicate)` | Keeps elements that match condition | `.filter(n -> n > 5)`        |
| `map(Function)`     | Transforms elements                 | `.map(n -> n * 2)`           |
| `sorted()`          | Sorts stream elements               | `.sorted()`                  |
| `distinct()`        | Removes duplicates                  | `.distinct()`                |
| `limit(n)`          | Takes first `n` elements            | `.limit(3)`                  |
| `skip(n)`           | Skips first `n` elements            | `.skip(2)`                   |
| `peek()`            | Debug/inspect without consuming     | `.peek(System.out::println)` |

Terminal Operations (Produce Result)

| Operation                                   | Description                      | Example                         |
| ------------------------------------------- | -------------------------------- | ------------------------------- |
| `forEach()`                                 | Performs action for each element | `.forEach(System.out::println)` |
| `collect()`                                 | Converts Stream → List, Set, Map | `.collect(Collectors.toList())` |
| `count()`                                   | Returns number of elements       | `.count()`                      |
| `findFirst()` / `findAny()`                 | Returns optional element         | `.findFirst().get()`            |
| `reduce()`                                  | Combines elements into one       | `.reduce(0, Integer::sum)`      |
| `anyMatch()` / `allMatch()` / `noneMatch()` | Checks conditions                | `.anyMatch(x -> x > 10)`        |


| Concept              | Description                                                 | Example                              |
| -------------------- | ----------------------------------------------------------- | ------------------------------------ |
| **Stream**           | Sequence of elements supporting functional-style operations | `list.stream()`                      |
| **Intermediate Ops** | Transform/filter data (lazy)                                | `filter()`, `map()`, `sorted()`      |
| **Terminal Ops**     | Produce final result (trigger execution)                    | `collect()`, `forEach()`, `reduce()` |
| **Lazy Evaluation**  | Stream executes only when terminal op runs                  | —                                    |
| **Immutable Source** | Doesn’t change the original collection                      | —                                    |
| **Parallel Stream**  | Multi-threaded processing                                   | `parallelStream()`                   |


# ParallelStreamExample.java

| Concept               | Description                                 | Example                     |
| --------------------- | ------------------------------------------- | --------------------------- |
| **Sequential Stream** | Single-threaded stream                      | `list.stream()`             |
| **Parallel Stream**   | Multi-threaded stream (auto-split workload) | `list.parallelStream()`     |
| **Internal Threads**  | Uses ForkJoinPool (managed threads)         | No need to create manually  |
| **Thread Safety**     | Only use when elements are independent      | Don’t modify shared objects |
| **Ordering**          | Use `forEachOrdered()` if order matters     | —                           |

| ✅ Good Use Cases                                       | ❌ Avoid When                                    |
| ------------------------------------------------------ | ----------------------------------------------- |
| Large data sets (10,000+ elements)                     | Very small data sets                            |
| CPU-intensive tasks (math, filtering, transformations) | IO-bound tasks (like reading files or DB calls) |
| Independent operations (no shared data or state)       | Shared mutable data (risk of race conditions)   |



# Lazy vs Eager
Lazy Evaluation means Java doesn’t execute stream operations immediately when you write them.
Instead, it builds a pipeline of operations first,

Eager Evaluation means operations are executed immediately,
as soon as they are encountered — not delayed or deferred.

Intermediate operations (like filter(), map(), sorted()) → lazy

Terminal operations (like collect(), forEach(), count()) → eager



| Type             | Examples                                                       | Execution                           | Returns           |
| ---------------- | -------------------------------------------------------------- | ----------------------------------- | ----------------- |
| **Intermediate** | `filter()`, `map()`, `sorted()`, `distinct()`                  | **Lazy** (no execution yet)         | Stream            |
| **Terminal**     | `collect()`, `forEach()`, `count()`, `reduce()`, `findFirst()` | **Eager** (triggers full execution) | Non-Stream result |

Source → filter() → map() → sorted() → collect()
           ↑         ↑        ↑         ↑
        (lazy)    (lazy)   (lazy)   (executes everything)

# Reduce function

| Term            | Description                                   | Example                         |
| --------------- | --------------------------------------------- | ------------------------------- |
| **Identity**    | Initial value for accumulator                 | `0` in `reduce(0, (a,b)->a+b)`  |
| **Accumulator** | Combines two elements                         | `(a,b)->a+b`                    |
| **Combiner**    | Merges partial results (for parallel streams) | `(p1,p2)->p1+p2`                |
| **Result**      | Final single output value                     | `int`, `String`, `Object`, etc. |

