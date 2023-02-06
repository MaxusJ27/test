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
    // declaration of necessary variables
    private static int end, capacity;
    
    public String[] arr;
    // if no argument provided,
    // then default constructor initialization
    // capacity is set to DEFAULT_CAP (1)
    public Queue() {
        this(DEFAULT_CAP);
    }

    public Queue(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);

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

        // copying array starting from 1 to the end (removing the first element)
        // not advisable to use since whole array is copied every time
        // this is called.
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
    // LIFO
    // point to the top of array (elements added in to top of array)
    public String[] arr;
    private static int len = 0;
    
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
    // for printing the stack
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
    // get the current number of elements in stack
    public int size(){
        return len;
    }

}

public class Queueing {
    public static void main(String[] args) {
        System.out.println("Stack Example:");
        Stack stackExample = new Stack();
        // stack push operation
        stackExample.enqueue("Hello");
        stackExample.enqueue("World");
        // print out the current stack
        System.out.println("Current stack is " + stackExample);
        // stack size
        System.out.println("Size of stack = " + stackExample.size());
        // dequeued element
        System.out.println("Popped element IS " + stackExample.dequeue());

        System.out.println("Current stack after popping is " + stackExample);
        // using getQueue and size
        String[] stack = stackExample.getQueue();
        int stackSize = stackExample.size();
        System.out.print("The elements of the stack are: ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print(stack[i]);
        }
        
        System.out.println("\nQueue Example:");
        Queue queueExample = new Queue();
        // enqueue
        queueExample.enqueue("Hi");
        queueExample.enqueue("There");
        // check the current queue
        System.out.println("Current queue is: " + queueExample);
        // check the size of queue
        System.out.println("Size of queue is " + queueExample.size());
        // dequeued element 
        System.out.println("Dequeued element is " + queueExample.dequeue());
        // check the size of queue
        System.out.println("Size of queue is " + queueExample.size());
        // check the current queue
        System.out.println("Current queue after dequeue is " + queueExample);
        // using getQueue and size
        String[] queue = queueExample.getQueue();
        int queueSize = queueExample.size();
        System.out.print("The elements of the queue are: ");
        for (int i = 0; i < queueSize; i++) {
            System.out.print(queue[i]);
        }
        // remove new line 
        System.out.print("\n");
    }
    
}
