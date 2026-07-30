import java.util.Arrays;
import java.util.List;

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
        System.out.println("=== Summary ===");
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
        check("new bs1 -> capacity equal -1 -> throw IllegalArgumentExceptionegalArgumentException", throwNegativeCapacity);


        boolean throwZeroCapacity = false;
        try {
            new BoundedStack(-1);
        } catch (IllegalArgumentException e) {
            throwZeroCapacity = true;
        }
        check("new bs1 -> capacity equal 0 -> throw IllegalArgumentExceptionegalArgumentException", throwZeroCapacity);

        BoundedStack bs1 = new BoundedStack(10);
        check("new bs1 -> capacity equal 10 -> return true", bs1.capacity() == 10);

        System.out.println();
    }

    private static void testPush() {
        BoundedStack bs2 = new BoundedStack(10);

        bs2.push("apple");
        bs2.push("pen");

        check("new bs2 -> size return will be 2", bs2.size() == 2);
        check("new bs2 -> peek -> return pen", bs2.peek() == "pen");

        boolean threwNull = false;
        try {
            bs2.push(null);
        } catch (IllegalArgumentException e) {
            threwNull = true;
        }
        check("new bs2 -> push null -> throw IllegalArgumentException", threwNull);

        boolean threwEmpty = false;
        try {
            bs2.push("");
        } catch (IllegalArgumentException e) {
            threwEmpty = true;
        }
        check("new bs2 -> push empty -> throw IllegalArgumentException", threwEmpty);
        
        bs2.push("rock");
        bs2.push("rock");
        bs2.push("rock");
        bs2.push("rock");
        bs2.push("rock");
        bs2.push("rock");
        bs2.push("rock");
        bs2.push("rock");

        check("new bs2 -> push another rock -> return false", !bs2.push("another rock"));

    }
    private static void testPop(){
        BoundedStack bs3 = new BoundedStack(10);

        bs3.push("apple");
        bs3.push("pen");
        bs3.pop(); 

        check("new bs3 -> size -> return 1", bs3.size() == 1);
        check("new bs3 -> peek -> return apple", bs3.peek() == "apple");

        bs3.pop();

        check("new bs3 -> pop -> throw IllegalArgumentException", !bs3.pop());
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
        check("new empty -> peek -> throw IllegalArgumentException",threwpeek);

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

    private static void testExposure() {
     
        System.out.println();
    }
    
    public static void main(String[] args) {
        testCreators();
        testPush();
        testPop();
        testObervers();
        // testProducer();
        // testExposure();

        summary();
    }
}
