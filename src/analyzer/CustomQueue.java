package analyzer;

import java.util.Arrays;

/** Integer FIFO queue implemented as a resizable circular array. */
public class CustomQueue {
    private int[] items = new int[8];
    private int frontIndex;
    private int size;

    public void enqueue(int value) {
        if (size == items.length) grow();
        int rearIndex = (frontIndex + size) % items.length;
        items[rearIndex] = value;
        size++;
    }
    public Integer dequeue() {
        if (size == 0) return null;
        int value = items[frontIndex];
        frontIndex = (frontIndex + 1) % items.length;
        size--;
        if (size == 0) frontIndex = 0;
        return value;
    }
    public Integer front() { return size == 0 ? null : items[frontIndex]; }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    private void grow() {
        int[] expanded = new int[items.length * 2];
        for (int i = 0; i < size; i++) expanded[i] = items[(frontIndex + i) % items.length];
        items = expanded;
        frontIndex = 0;
    }

    public void display() {
        if (size == 0) { System.out.println("Queue is empty."); return; }
        int[] ordered = new int[size];
        for (int i = 0; i < size; i++) ordered[i] = items[(frontIndex + i) % items.length];
        System.out.println("Queue (front to rear): " + Arrays.toString(ordered));
    }
}