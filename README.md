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

