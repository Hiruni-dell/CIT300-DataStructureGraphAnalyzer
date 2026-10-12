package analyzer;

public class CustomLinkedList {
    private static class Node {
        int data; Node next;
        Node(int data) { this.data = data; }
    }
    private Node head;

    public void insertFront(int value) {
        Node n = new Node(value); n.next = head; head = n;
    }
    public void insertEnd(int value) {
        Node n = new Node(value);
        if (head == null) { head = n; return; }
        Node c = head; while (c.next != null) c = c.next; c.next = n;
    }
    public boolean delete(int value) {
        if (head == null) return false;
        if (head.data == value) { head = head.next; return true; }
        Node c = head;
        while (c.next != null && c.next.data != value) c = c.next;
        if (c.next == null) return false;
        c.next = c.next.next; return true;
    }
    public boolean search(int value) {
        for (Node c = head; c != null; c = c.next) if (c.data == value) return true;
        return false;
    }
    public void display() {
        if (head == null) { System.out.println("Linked list is empty."); return; }
        Node c = head;
        while (c != null) { System.out.print(c.data + (c.next == null ? "" : " -> ")); c = c.next; }
        System.out.println();
    }
}