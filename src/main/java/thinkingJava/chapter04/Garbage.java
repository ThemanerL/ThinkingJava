package thinkingJava.chapter04;

/**
 * System.gc()是把占了内存但是没有利用，同时没有被垃圾回收机制处理的对象尽可能的处理掉。
 * System.runFinalization()是强制垃圾回收机制尽可能的回收没有被利用的对象，以释放出其占用的内存。
 */
public class Garbage {
    public static void main(String[] args){
        if (args.length==0) {
            System.out.println("Usage: \n" + "java Garage before\n or:\n" + "java Garbage after");
            return;
        }
        while (!Chair.f) {
            new Chair();
            new String("To take up space");
        }
        System.out.println("After all Chairs have been created:\n"
                + "total created = " + Chair.created
                + ", total finalized = " + Chair.finalized);
        if (args[0].equals("before")) {
            System.out.println("gc():");
            System.gc();
            System.out.println("runFinalization():");
            System.runFinalization();
        }
        System.out.println("bye!");
        // Deprecated
        if (args[0].equals("after"))
            System.runFinalizersOnExit(true);
    }
}
class Chair {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;
    Chair() {
        i = ++created;
        if (created == 47)
            System.out.println("Created 47");
    }
    protected void finalize() {
        if (!gcrun) {
            gcrun = true;
            System.out.println("Beginning to finalize after " + created + " Chairs have been created");
        }
        if (i==47) {
            System.out.println("Finalizing Chair #47, " + "Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if (finalized>=created)
            System.out.println("All " + finalized + " finalized");
    }
}