# What’s the difference between abstract class and interface?

    An abstract class provides a base for related classes to share state or common logic — it can have instance fields, constructors, and both abstract and concrete methods.

    An interface defines a contract — multiple unrelated classes can implement it. Since Java 8, interfaces can have default and static methods, and since Java 9, private helper methods.

    Example.
        “For instance, in a game engine, I’d use an abstract class GameObject for common properties, and interfaces like Renderable or Collidable for behaviors.”


# What does volatile do?
    volatile ensures that a variable’s value is always read from main memory and not from a CPU cache.
    It provides visibility and ordering guarantees but not atomicity.

    For compound operations like count++, we still need synchronization or AtomicInteger.

    Example.
        “It’s often used for flags or configuration values in multi-threaded systems.”

# What’s finalize() used for?
    finalize() was originally meant for cleanup before GC, but it’s unreliable and deprecated after Java 9.
    Modern Java uses try-with-resources (for I/O, DB, etc.) or the Cleaner API for safe cleanup.

    reasoning:
        “I’d never rely on finalize — the JVM doesn’t guarantee when or if it’s called.”

# Diamond Problem in Interfaces

    interface A { default void show() { System.out.println("A"); } }
    interface B { default void show() { System.out.println("B"); } }

    class C implements A, B {
        @Override
        public void show() { A.super.show(); } // resolve conflict
    }

    Java allows multiple inheritance of interfaces, but if two interfaces have the same default method, the class must explicitly override it to resolve the conflict.

# StringBuilder vs StringBuffer.

    | Aspect              | String           | StringBuffer                | StringBuilder                |
    | ------------------- | ---------------- | --------------------------- | ---------------------------- |
    | **Mutable**         | ❌ No             | ✅ Yes                       | ✅ Yes                        |
    | **Thread-safe**     | ✅ (immutable)    | ✅ (synchronized)            | ❌                            |
    | **Performance**     | Slow             | Medium                      | Fast                         |
    | **Recommended for** | Constant strings | Multi-threaded modification | Single-threaded modification |


# Comparable vs ComapareTo

    | Feature   | `Comparable`               | `Comparator`                         |
    | --------- | -------------------------- | ------------------------------------ |
    | Package   | `java.lang`                | `java.util`                          |
    | Method    | `compareTo(T o)`           | `compare(T o1, T o2)`                |
    | Location  | Inside the class           | Separate class or lambda             |
    | Usage     | Defines *natural ordering* | Defines *custom ordering*            |
    | Used with | `Collections.sort(list)`   | `Collections.sort(list, comparator)` |
    | Example   | Sort by age (default)      | Sort by name, salary, etc.           |
