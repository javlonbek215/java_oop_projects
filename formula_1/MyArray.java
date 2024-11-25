package formula_1;
import java.util.Iterator;
import java.util.LinkedList;

public class MyArray<T> implements Iterable<T> {
    private T[] values;
    private int currentIndex = 0;

    public MyArray() {
        values = (T[]) new Object[5];
    }

    public MyArray(T[] arr) {
        values = arr;
        currentIndex = arr.length;
    }

    /**
     * Adding value
     */
    public void add(T value) {
        increaseArray(); // increase array
        values[currentIndex] = value;
        currentIndex++;
    }

    public void add(int index, T value) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRight -> ERROR");
            return;
        }
        shiftToRight(index);   // [7,null,3,9,2,10]
        values[index] = value;  // [7, 15 ,3,9,2,10]
    }

    public void addFist(T value) {
        add(0, value);
    }

    public void addLast(T value) {
        add(value);
    }

    /**
     * Fetching  value
     */

    public T get(int index) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("get -> ERROR");
            return null;
        }
        return values[index];
    }

    public int indexOf(T value) {
        if (value == null) {
            System.out.println("indexOf -> MAZGI");
            return -1;
        }
        for (int i = 0; i < currentIndex; i++) {
            if (value.equals(values[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Update value
     */

    public T set(int index, T value) {// return old value
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRight -> ERROR");
            return null;
        }
        T oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    /**
     * Remove/delete
     */

    public T remove(int index) {
        // returns deleted value
        // [7,3,x,2,15,10]
        if (index < 0 || index >= currentIndex) {
            System.err.println("remove -> ERROR");
            return null;
        }
        T old = values[index];
        shiftToLeft(index);
        return old;
    }

    public void removeFirst() {
        // [7,3,2,15,10]
        // [3,2,15,10]
        remove(0);
    }

    public void removeLast() {
        remove(currentIndex - 1);
    }

    public int remove(T value) {
        // returns deleted index
        // [7,3,2,15,10]  value=15
        // [7,3,2,10]
        int index = indexOf(value);
        if (index == -1) {
            return -1;
        }
        remove(index);
        return index;
    }

    public void clear() {
        values = (T[]) new Object[5];
        currentIndex = 0;
    }

    /**
     * Is methods
     */

    public boolean isEmpty() {
        return currentIndex == 0;
    }

    public boolean isContains(T value) {
        return indexOf(value) != -1;
    }

    /**
     * Other methods
     */

    public int size() {
        return currentIndex;
    }

    public Object[] toArray() {
        Object[] array = new Object[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            array[i] = values[i];
        }
        return array;
    }

    public void printAll() {
        System.out.println(this);
    }

    public void printFirstAndLast() {
        if (currentIndex == 0) {
            System.err.println("Array is empty Mazgi");
            return;
        }
        System.out.println(" First: " + values[0]);
        System.out.println(" Last : " + values[currentIndex - 1]);
    }

    public String toString() { // [1,2,3,4,5]
        String str = "[";
        for (int i = 0; i < currentIndex; i++) {
            str = str + values[i];
            if (i != currentIndex - 1) {
                str = str + ",";
            }
        }
        str = str + "]";
        return str;
    }

    private void shiftToRight(int index) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToRight -> ERROR");
            return;
        }
        increaseArray(); // increase array
        for (int i = currentIndex; i != index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = null;
        currentIndex++;
    }

    private void shiftToLeft(int index) {
        if (index < 0 || index >= currentIndex) {
            System.err.println("shiftToLeft -> ERROR");
            return;
        }
        for (int i = index; i < currentIndex - 1; i++) {
            values[i] = values[i + 1];
        }
        currentIndex--;
        values[currentIndex] = null;
    }

    private void increaseArray() {
        if (currentIndex >= values.length) {
            T[] newArr = (T[]) new Object[currentIndex * 2];
            for (int i = 0; i < values.length; i++) {
                newArr[i] = values[i];
            }
            values = newArr;
        }
    }

    /**
     * Iterating
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() { //
                return index < currentIndex;
            }

            @Override
            public T next() {
                return values[index++];
            }
        };
    }

    public T[] toArray(T[] a) {
        a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), currentIndex);
        for (int i = 0; i < currentIndex; i++) {
            a[i] = values[i];
        }
        return a;
    }
}
