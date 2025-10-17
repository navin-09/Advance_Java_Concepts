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
