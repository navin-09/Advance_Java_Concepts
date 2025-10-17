# JVM Memory Layout.

JVM Memory Layout
──────────────────────────────────────────────
| Method Area / Metaspace  →  Class metadata, static vars |
| Heap                     →  Objects, instance variables |
| Stack                    →  Method calls, local vars    |
| PC Register              →  Current instruction pointer |
| Native Method Stack      →  JNI (native C/C++ calls)    |
──────────────────────────────────────────────


| Memory Area             | Purpose                                                                  | Example                 |
| ----------------------- | ------------------------------------------------------------------------ | ----------------------- |
| **Stack**               | Stores method frames and local variables. Each thread has its own stack. | `int a = 5;` lives here |
| **Heap**                | Stores all Java objects (shared by all threads).                         | `new Person()`          |
| **Metaspace** (Java 8+) | Stores **class metadata**, method info, static vars. Replaced “PermGen.” | Class names, methods    |
| **PC Register**         | Tracks the current instruction in execution.                             | —                       |
| **Native Stack**        | Used for native (non-Java) methods.                                      | `System.loadLibrary()`  |



# Garbage Collection

    Garbage Collection (GC) automatically frees memory by removing unreachable objects from the Heap.

| Type                  | Description                        | GC Behavior                             |
| --------------------- | ---------------------------------- | --------------------------------------- |
| **Strong Reference**  | Default reference (`new Object()`) | Never garbage collected while reachable |
| **Weak Reference**    | Doesn’t prevent GC                 | Collected if no strong references       |
| **Soft Reference**    | GC’d only when memory is low       | Used for caching                        |
| **Phantom Reference** | Used for cleanup after GC          | Advanced use case                       |


# JIT Compilation (Just-In-Time Compiler)

JIT = Just-In-Time Compiler
    It’s part of the JVM that converts hot (frequently used) bytecode into native machine code at runtime for speed.

Source Code → javac → Bytecode (.class) → JVM → JIT → Native CPU instructions


# finalize() and GC Tuning

    The finalize() method

        A protected method in Object class.

        Called once before GC destroys the object.

        Used for cleanup (like closing files, releasing native resources).
    
    finalize() is deprecated (Java 9+)
    Use try-with-resources or Cleaner API instead — much safer and predictable.


# File Handling with FileReader and BufferedReader

    Concept: Basic Character Stream I/O

        Java has two main kinds of streams:
            Character streams → Reader, Writer (for text data)

            Byte streams → InputStream, OutputStream (for binary data)


# Serialization
    Serialization = Converting an object into a byte stream (to save or send).

    Deserialization = Reconstructing the object back from that byte stream.

    ObjectOutputStream & ObjectInputStream used for serialization

    Only classes that implement Serializable can be serialized.

    Fields marked as transient are skipped (see next point).

    Version mismatch (via serialVersionUID) can cause errors if class definition changes.

    transient Keyword Marks a field not to be serialized.

    Used for:

        Sensitive info (like passwords)

        Temporary or derived fields


# NIO (Files, Paths) — Modern, Efficient File APIs (Java 7+)

    NIO (New I/O) introduced in Java 7 provides:

        Easier, safer file handling via java.nio.file.*

        Better performance for large files

        Simplified APIs using static methods


| Method                  | Purpose                       |
| ----------------------- | ----------------------------- |
| `Files.exists(path)`    | Check if file exists          |
| `Files.copy(src, dest)` | Copy file                     |
| `Files.move(src, dest)` | Move file                     |
| `Files.delete(path)`    | Delete file                   |
| `Files.size(path)`      | Get size                      |
| `Files.walk(path)`      | Recursive directory traversal |


# Java 11+ — Files.readString() & Files.writeString()

| Topic                                        | Description                                   | When to Use                         |
| -------------------------------------------- | --------------------------------------------- | ----------------------------------- |
| **FileReader / BufferedReader**              | Old-school but simple character-based reading | Small text files                    |
| **Object Streams**                           | Serialize/deserialize Java objects            | Save app state or send over network |
| **transient keyword**                        | Skip fields during serialization              | Hide passwords or temporary fields  |
| **NIO (`Files`, `Paths`)**                   | Modern, efficient file API                    | Production-ready apps               |
| **Java 11 `readString()` / `writeString()`** | Simplified read/write methods                 | Quick file access                   |
