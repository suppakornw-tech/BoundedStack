import java.util.ArrayList;
import java.util.List;

// create by suppakorn wannaprabha 
//           ศุภกร วรรณประภา
//           6821601496

/**
     * BoundedStack - ADT แทน Stack ที่ถูกกำหนดขอบเขตชัดเจน
     * 
     * ค่านามธรรม (A): ลำดับของค่าที่เรียงจากค่าที่เข้าก่อนไปค่าที่เข้าทีหลัง เช่น [1,2] หมายถึง 2 อยู่บนสุด
     * 
     * ตัวอย่างการใช้งาน: 
     *      BoundedStack s = new BoundedStack(3);
     *      s.push(1);
     *      s.push(2);
     *      System.out.println(s.peek());   // 2
     *      s.pop();
     *      System.out.println(s.peek());   // 1
     */

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

    //==== Creators ====
    // create BoundedStack the capacity will be pass from the user  
    /**
     * @param capacity the maximum data that can collect in this stack
     * @post Stack will be create with the empty data. the size will be 0
     * @throws IllegalArgumentException if capacity <= 0
     * 
     */
    public BoundedStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();

        this.data = new ArrayList<>();
        top = 0;
        this.capacity = capacity;
        checkRep();
    }

    //==== Mutators ====
    // add the data to the top stack 
    /**
     * @param x is the data that we add to the stack
     * @pre size will be less than the capacity
     * @post size + 1
     * @throws IllegalArgumentException if size = capacity
     */

    public boolean push(String name) {
        if (name == null || name == "") throw new IllegalArgumentException();
        if (top >= capacity) return false;

        data.add(name);
        top++;
        checkRep();
        return true;
    }

    // remove the lastest data
    /**
     * @pre stack cannot be empty
     * @post size will be -1 
     * @return the data that get remove
     * @throws IllegalArgumentException if the stack is all ready empty
     */

    public boolean pop() {
        if (top <= 0) return false;

        data.remove(top-1);
        top--;
        checkRep();
        return true;
    }

    //==== Obsevers ====
    //  return data that on the top stack right now
    /**
     * @return top data of this stack
     * @throws IllegalArgumentException if the stack is empty
     */
    public String peek() {
        if (top <= 0) {
            throw new IllegalArgumentException();
        }

        return data.get(top - 1);
    }

    // return position of the lastest data 
    /**
     * @return position of the lastest data
     */

    public int size() {
        return top;
    }

    // return capacity
    /**
     * @return capacity
     */

    public int capacity() {
        return capacity;
    }

    // return ArrayList that collect all the same data
    /**
     * @return ArrayList that collect all the same data
     */

    public List<String> copy() {
        return new ArrayList<>(data);
    }

    // ==== Producers ====
    // return BoundedStack that completely reverse
    /**
     * 
     * @post be the same size() , if original is ["apple", "pen"] reversed wil be ["pen", "apple"]
     * @return reverse BoundedStack
     */

    public BoundedStack reverse() {
        BoundedStack reversed = new BoundedStack(capacity);
        for (int i = size()-1 ; i >= 0; i--) {
            reversed.push(data.get(i));
        }
        return reversed;
    }
}