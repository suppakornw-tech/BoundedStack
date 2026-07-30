import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class BoundedStack {
    public static final int capacity = 10;
    private int top;
    private final List<String> elements;

    // af -> boundedstack = collect all the value in the boundedstack
    // ri  -> boundedstack will be
        // - boundedstack cannot be null
        // - boundedstack will collect the book not more than 100 book
        // - value cannot be null
        // - value cannot be empty
    // safely and exposure
        // - we will final on the boundedstack. this way we prevent books cannot change all the value in the boundedstack (push, pop and other)
        // - we will return only new boundedstack that copy all the value

    private void checkRep() {
        assert elements != null : "elements can not be null";
        assert elements.size() <= capacity : "elements is out of range";
        assert top >= -1 && top <= capacity : "top is out of range";
        
        for (String e : elements) {
            assert e != null : "value cannot be null";
            assert e != "" : "value cannot be empty";
        }
    } 

    public BoundedStack() {
        this.elements = new ArrayList<>();
        top = 0;
        checkRep();
    }

    public BoundedStack(List<String> initial) {
        if (initial == null) throw new IllegalArgumentException();
        if (initial.size() > capacity) throw new IllegalArgumentException();

        for (String s : initial) {
            if (s == null) throw new IllegalArgumentException();
            if (s == "") throw new IllegalArgumentException();
        }

        this.elements = new ArrayList<>(initial);
        top = initial.size();
        checkRep();
    }

    public boolean push(String name) {
        if (name == null || name == "") throw new IllegalArgumentException();
        if (top == capacity) return false;

        elements.add(name);
        top++;
        checkRep();
        return true;
    }

    public boolean pop(String name) {
        if (top <= 0) return false;

        elements.remove(top);
        top--;
        checkRep();
        return true;
    }

    public String peek() {
        if (top <= 0) {
            throw new IllegalArgumentException();
        }

        return elements.get(top - 1);
    }

    public int size() {
        return top;
    }

    public int capacity() {
        return capacity;
    }

    public List<String> copy() {
        return new ArrayList<>(elements);
    }

    public boolean reversed() {
        return true;
    }





    // public boolean add(String book) {
    //     if (book == null) throw new IllegalArgumentException();
    //     if (book == "" || book == " ") throw new IllegalArgumentException();
    //     if (books.size() >= MAX_BOOK) return false;
    //     if (books.contains(book)) return false;

    //     books.add(book);
    //     checkRep();
    //     return true;
    // }

    // public boolean remove(String book) {
    //     if (!books.contains(book)) return false;

    //     books.remove(book);
    //     checkRep();
    //     return true;
    // }

    // public int size() {
    //     return books.size();
    // }

    // public boolean contains(String book) {
    //     return books.contains(book);
    // }

    // public BoundedStack shuffled() {
    //     List<String> copy = new ArrayList<>(books);
    //     Collections.shuffle(copy);
    //     return new BoundedStack(copy);
    // }

    // public List<String> books() {
    //     return new ArrayList<String>(books);
    // }
}
