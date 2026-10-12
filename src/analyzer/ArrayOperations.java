package analyzer;
import java.util.Arrays;

public class ArrayOperations {
    private int[] values;
    private int size;

    public ArrayOperations(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("Capacity must be positive.");
        values = new int[capacity];
    }
    public void insert(int value) {
        if (size == values.length) values = Arrays.copyOf(values, values.length * 2);
        values[size++] = value;
    }
    public boolean delete(int value) {
        int i = search(value);
        if (i < 0) return false;
        System.arraycopy(values, i + 1, values, i, size - i - 1);
        size--;
        return true;
    }
    public int search(int value) {
        for (int i = 0; i < size; i++) if (values[i] == value) return i;
        return -1;
    }
    public void display() {
        if (size == 0) System.out.println("Array is empty.");
        else System.out.println(Arrays.toString(Arrays.copyOf(values, size)));
    }
    public int[] toArray() { return Arrays.copyOf(values, size); }
}