package analyzer;

import java.util.Arrays;

/** Integer stack implemented with a resizable array. */
public class CustomStack {
    private int[] items = new int[8];
    private int size;

    public void push(int value) {
        if (size == items.length) items = Arrays.copyOf(items, items.length * 2);
        items[size++] = value;
    }
    public Integer pop() { return size == 0 ? null : items[--size]; }
    public Integer peek() { return size == 0 ? null : items[size - 1]; }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public void display() {
        if (size == 0) { System.out.println("Stack is empty."); return; }
        System.out.println("Stack (bottom to top): " + Arrays.toString(Arrays.copyOf(items, size)));
    }
}