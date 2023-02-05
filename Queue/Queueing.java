package Queue;
import java.util.*;

// Implementation of IQueable uses 
// dynamic arrays 
interface IQueable {
    static final int DEFAULT_CAP = 1;
    public String[] enqueue(String value);

    public String dequeue();

    public String[] getQueue();

    public int size();

}

class Queue implements IQueable {
    // static private final int DEFAULT_CAP = 1;
    static private int front, end, capacity;
    // public int len = 0;
    
    public String[] arr;
    // if not argument provided,
    // then default constructor initialization
    // capacity is set to DEFAULT_CAP (1)
    public Queue() {
        this(DEFAULT_CAP);
    }

    public Queue(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        // front = end = 0;

        Queue.capacity = capacity;
        arr = new String[capacity];
    }
    // push element into the end of arr 
    public String[] enqueue(String value) {
        if (end + 1 >= capacity) {
            if (capacity == 0)
                capacity = 1;
            else
                capacity *= 2;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[end++] = value;

        return arr;
    }

    public String dequeue() {
        String dequeuedElem = (String) arr[0];

        // System.arraycopy(arr, 1, arr, end, arr.length);
        arr = Arrays.copyOfRange(arr, 1, arr.length);
        --end;
        return dequeuedElem;
    }

    public String[] getQueue() {
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < end ;i++) {
             sb.append(arr[i]);
             if(i < end-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();

    }

    public int size(){
        return end;
    }



}
// Stack is essentially LIFO (last-in first-out)
class Stack implements IQueable {
    // private static final int DEFAULT_CAP = 1;
    // LIFO
    // point to the top of array (elements added in to top of array)
    public String[] arr;
    public int len = 0;
    
    private int capacity = 0;

    // class constructor initialization
    // if no capacity provided, initialize with the default capacity 
    public Stack() {
        // Stack(DEFAULT_CAP);
        this(DEFAULT_CAP);
        
    }

    public Stack(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = new String[capacity];
    }

    // equivalent to push in stack
    // before pushing into stack, check if stack has the capacity 
    // if not then multiply it by 2 (dynamic array)
    public String[] enqueue(String value) {
        if (len + 1 >= capacity) {
            if (capacity == 0)
                capacity = 1;
            else
                capacity *= 2;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[len++] = value;

        return arr;
    }
    // equivalent to pop in stack 
    // remove top element of array 
    public String dequeue() {
        String popped = (String) arr[--len];
        arr[len] = null;
        return popped;
    }

    public String[] getQueue(){
        return arr;
    }

    // Operator Overloading
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < len ;i++) {
             sb.append(arr[i]);
             if(i < len-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();

    }

    public int size(){
        return len;
    }

}

public class Queueing {
    public static void main(String[] args) {
        // Stack stackExample = new Stack();

        // stackExample.enqueue("Haha");
        // stackExample.enqueue("Lolz");
        // System.out.println(stackExample.size());
        // System.out.println(stackExample.dequeue());
        // System.out.println(stackExample);
        // String[] stackList = stackExample.getQueue();

        Queue queueExample = new Queue();

        queueExample.enqueue("Hi");
        queueExample.enqueue("There");
        System.out.println(queueExample);
        System.out.println(queueExample.size());
        System.out.println(queueExample.dequeue());
        System.out.println(queueExample.size());
        System.out.println(queueExample);
    }
    
}
