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