package JVM_Internals;

import java.lang.ref.WeakReference;

public class GarbageCollection {
    public static void main(String[] args) {
        String strong = new String("Strong");
        WeakReference<String> weak = new WeakReference<>(new String("Weak"));

        System.gc();
        System.out.println("Strong: " + strong);
        System.out.println("Weak: " + weak.get()); // may be null after GC
    }
}
