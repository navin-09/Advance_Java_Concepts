package JVM_Internals;

public class MemoryExample {
     int x = 10;  // stored in Heap (inside the object)
    static int y = 20;  // stored in Metaspace (static memory)

    public static void main(String[] args) {
        MemoryExample obj = new MemoryExample(); // obj in Heap
        int z = 30; // local variable in Stack
    }
}

