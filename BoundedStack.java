import java.util.ArrayList;
import java.util.List;

public class BoundedStack {
    private final List<String> data;
    private final int capacity;
    private int top;

    // af -> boundedstack = collect all the value in the boundedstack
    // ri  -> boundedstack will be
        // - capacity  will greater than 0 
        // - top will be greater than 0 and cannot be more than the capacity
        // - data cannot be null and empty
    // safely and exposure
        // - we will final on the boundedstack. this way we prevent books cannot change all the value in the boundedstack (push, pop and other)
        // - we will return only new boundedstack that copy all the value

    private void checkRep() {
        assert capacity > 0 : "capacity must be greater than 0";
        assert data != null : "data cannot be null";
        assert top >= 0 && top <= capacity : "top is out of range";
        assert data.size() >= 0 && data.size() <= capacity : "data is out of range";
    }

    public BoundedStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();

        this.data = new ArrayList<>();
        top = 0;
        this.capacity = capacity;
        checkRep();
    }

    public boolean push(String name) {
        if (name == null || name == "") throw new IllegalArgumentException();
        if (top >= capacity) return false;

        data.add(name);
        top++;
        checkRep();
        return true;
    }

    public boolean pop() {
        if (top <= 0) return false;

        data.remove(top-1);
        top--;
        checkRep();
        return true;
    }

    public String peek() {
        if (top <= 0) {
            throw new IllegalArgumentException();
        }

        return data.get(top - 1);
    }

    public int size() {
        return top;
    }

    public int capacity() {
        return capacity;
    }

    public List<String> copy() {
        return new ArrayList<>(data);
    }

    public BoundedStack reverse() {
        BoundedStack reversed = new BoundedStack(capacity);
        for (int i = size()-1 ; i >= 0; i--) {
            reversed.push(data.get(i));
        }
        return reversed;
    }
}