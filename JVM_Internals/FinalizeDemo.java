package JVM_Internals;

public class FinalizeDemo {
    protected void finalize() {
        System.out.println("Finalize method called before GC");
    }

    public static void main(String[] args) {
        FinalizeDemo obj = new FinalizeDemo();
        obj = null; // Eligible for GC
        System.gc(); // Request GC
        System.out.println("Main method done.");
    }
}
