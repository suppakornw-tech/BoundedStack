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
        BoundedStack bs1 = new BoundedStack();

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
