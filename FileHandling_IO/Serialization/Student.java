package FileHandling_IO.Serialization;

import java.io.Serializable;

// 1️⃣ Serializable class
class Student implements Serializable {
    private static final long serialVersionUID = 1L;  // optional version ID
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
