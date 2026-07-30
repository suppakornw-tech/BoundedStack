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
        boolean throwNegativeCapacity = false;
        try {
            new BoundedStack(-1);
        } catch (IllegalArgumentException e) {
            throwNegativeCapacity = true;
        }
        check("new bs1 -> capacity equal -1 -> throw IllegalArgumentException", throwNegativeCapacity);


        boolean throwZeroCapacity = false;
        try {
            new BoundedStack(-1);
        } catch (IllegalArgumentException e) {
            throwZeroCapacity = true;
        }
        check("new bs1 -> capacity equal 0 -> throw IllegalArgumentException", throwZeroCapacity);

        BoundedStack bs1 = new BoundedStack(10);
        check("new bs1 -> capacity equal 10 -> return true", bs1.capacity() == 10);

        System.out.println();
    }

    private static void testObervers() {
        BoundedStack empty = new BoundedStack(10);
        check("new empty -> size return will be 0", empty.size() == 0);

        boolean threwpeek = false;
        try {
            empty.peek();
        } catch (IllegalArgumentException e) {
            threwpeek = true;
        }
        check("peek() ตอนข้อมูลว่าง -> throw IllegalStateException",threwpeek);

        empty.push("apple");
        empty.push("pen");

        int before = empty.size();
        empty.size();
        empty.peek();
        empty.copy();

        check("new empty -> size return will be 2",empty.size() == 2);
        check("new empty -> peek -> will return pen",empty.peek() == "pen");
        check("observers have no side effects",empty.size() == before);

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
        testObervers();
        testProducer();
        testMutotor();

        summary();
    }
}
