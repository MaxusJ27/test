package DS;

import java.util.*;
/* Fundamental aspects of a dynamic array
1. be able to set the capacity and value at index,
    and get its current size, value at index and check if it's empty 
2. when adding elements, if array is at max capacity then
        i. check if it's 0, if 0 then set to 1
        ii. otherwise multiply the capacity by 2 then (Arrays.copyOf(array, capacity))
3. when remove elements at specific index, we use 
System.arraycopy(arr, rm_index + 1, arr, rm_index, len - rm_index + 1);
which copies the array starting at index + 1 into an position index
essentially 'squashing the array' one position backwards
|0|1|2|3|4| -> |0|1|3|4|  (remove at index 2) (length -= 1, capacity -= 1)
4. remove specific element
iterate through the entire array and constantly checking if arr[i] = elem
if yes then remove at specific index i 
4. reverse the array 
iterate to half of the array while swapping the right and left ends
int temp = arr[i];
arr[i] = arr[len - i - 1];
arr[len - i - 1] = arr[i];
5. sort (Arrays.sort(arr, 0, arr.length()))
6. binary search: index (Arrays.binarySearch(arr, key)) 
7. be converted into string for printing 
        i. arr.size() == 0 return "[]"
        ii. else use string builder 
        StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
            return sb.append(arr[len - 1] + "]").toString();
 */


public class dynamic_array implements Iterable<Integer> {
    // can only be initialized once
    private static final int DEFAULT_CAP = 1 << 3;

    public int[] arr;
    public int len = 0;
    private int capacity = 0;

    // initialize array with default capacity
    public dynamic_array() {
        this(DEFAULT_CAP);
    }

    // initialize array with certain capacity
    // operator overloading
    public dynamic_array(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    // Given an array, make it into a dynamic array
    public dynamic_array(int[] array) {
        if (array == null) throw new IllegalArgumentException("Array cannot be null");
        arr = java.util.Arrays.copyOf(array, array.length);
        capacity = len = array.length;
    }

    // Returns the size of the array
    public int size() {
        return len;
    }

    // Returns true/false on whether the array is empty
    public boolean isEmpty() {
        return len == 0;
    }

    // To get/set values without method call overhead you can do
    // array_obj.arr[index] instead, you can gain about 10x the speed
    public int get(int index) {
        return arr[index];
        // return array_obj.arr[index];
    }

    public void set(int index, int elem) {
        arr[index] = elem;
        // arr_obj.arr[index] = elem;
    }

    // add an element to this dynamic array
    public void add(int elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0)
                capacity = 1;
            else
                capacity *= 2;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[len++] = elem;
    }

    // Removes the element at the specified index in this list
    // If possible, avoid calling this method as it takes O(n) time
    // to remove an element (since you have to reconstruct the array)
    public void removeAt(int rm_index) {
        // arraycopy(sourceArr, sourcePos, destArr, destPos, size)
        System.arraycopy(arr, rm_index + 1, arr, rm_index, len - rm_index + 1);
        --len;
        --capacity;
    }

    // search and remove an element if it is found in the array
    // if possible, avoid calling this method as it takes O(n) time
    // iterate through the entire array 
    public boolean remove(int elem) {
        for (int i = 0; i < len; i++) {
            if (i == elem) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // reverse the contents of this array 
    // starts at the middle 
    public void reverse() {
        for (int i = 0; i < len / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }

    // sort array 
    public void sort() {
        // len = array.length()
        Arrays.sort(arr, 0, len);
    }

    public int binarySearch(int key) {
        int index = Arrays.binarySearch(arr, key);
        return index;
    }
    // Iterator is still fast but not as fast iterative for loops
    @Override 
    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<Integer>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public Integer next() {
                return arr[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override 
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
            return sb.append(arr[len - 1] + "]").toString();
        }
    }

    public static void main(String[] args) {
        dynamic_array ar = new dynamic_array(50);

        ar.add(3);
        ar.add(7);
        ar.add(6);
        ar.add(4);

        ar.sort();

        System.out.println(ar.toString());

        for (int i = 0; i < ar.size(); i++) System.out.println(ar.get(i));


    }
}
