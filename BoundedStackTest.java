import java.util.Arrays;

public class BoundedStackTest {
    private static int passed  = 0;
    private static int failed = 0;

    private static void check (String name, boolean ok) {
        if (ok) {
            passed++;
            System.out.println("[PASS]: " + name);
        } else {
            failed++;
            System.out.println("[FAIL]: " + name);
        }
    }

    private static void summary() {
        System.out.println("\n=== Summary ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Total : " + (passed + failed));
        System.out.println(failed == 0 ? "ALL TESTS PASSED" : "SOME TESTS FAILED");
    }

    private static void testCreators() {
        // empty
        BoundedStack empty = new BoundedStack();
        check("new empty -> size will be 0", empty.size() == 0);

        boolean throwNotHaveAnything = false;
        try {
            empty.peek();
        } catch (Exception e) {
            throwNotHaveAnything = true;
        }
        check("new empty -> do not have anything", throwNotHaveAnything);

        // have something
        BoundedStack something = new BoundedStack(Arrays.asList("something"));
        check("new something -> size will be 1 ", something.size() == 1);
        check("new something -> do have something ", something.peek() == "something");

        // full
        BoundedStack full = new BoundedStack(Arrays.asList("item", "item", "item", "item", "item", "item", "item", "item", "item", "item"));
        check("new full -> size max to capacity", full.size() == full.capacity());


        // null
        boolean throwNull = false;
        try {
            new BoundedStack(null);
        } catch (IllegalArgumentException e) {
            throwNull = true;
        }
        check("new null -> throw IllegalArgumentException", throwNull);

        // empty
        boolean throwEmpty = false;
        try {
            new BoundedStack(Arrays.asList(""));
        } catch (IllegalArgumentException e) {
            throwEmpty = true;
        }
        check("new value empty -> throw IllegalArgumentException", throwEmpty);

        System.out.println();
    }

    private static void testObervers() {
        System.out.println();
    }

    private static void testProducer() {
        System.out.println();
    }

    private static void testMutotor() {
        System.out.println();
    }
    
    public static void main(String[] args) {
        testCreators();
        // testObervers();
        // testProducer();
        // testMutotor();

        summary();
    }
}
