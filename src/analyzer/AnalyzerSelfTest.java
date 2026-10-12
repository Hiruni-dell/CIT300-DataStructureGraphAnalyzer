package analyzer;

import java.util.Arrays;

/** Small dependency-free regression test runner. Run as a Java Application. */
public final class AnalyzerSelfTest {
    private AnalyzerSelfTest() {}

    public static void main(String[] args) {
        testArray();
        testStack();
        testQueue();
        testLinkedList();
        testSearching();
        testGraph();
        System.out.println("All AnalyzerSelfTest checks passed.");
    }

    private static void testArray() {
        ArrayOperations a = new ArrayOperations(1);
        a.insert(10); a.insert(20);
        check(a.search(20) == 1, "array search");
        check(a.delete(10), "array delete existing");
        check(Arrays.equals(a.toArray(), new int[]{20}), "array content after delete");
        check(!a.delete(99), "array delete missing");
    }
    private static void testStack() {
        CustomStack s = new CustomStack();
        check(s.pop() == null && s.peek() == null, "empty stack");
        s.push(4); s.push(9);
        check(s.peek() == 9 && s.pop() == 9 && s.pop() == 4 && s.isEmpty(), "stack LIFO");
    }
    private static void testQueue() {
        CustomQueue q = new CustomQueue();
        check(q.dequeue() == null && q.front() == null, "empty queue");
        for (int i = 0; i < 20; i++) q.enqueue(i);
        for (int i = 0; i < 10; i++) check(q.dequeue() == i, "queue FIFO");
        for (int i = 20; i < 35; i++) q.enqueue(i);
        for (int i = 10; i < 35; i++) check(q.dequeue() == i, "queue circular resize");
        check(q.isEmpty(), "queue empty after removals");
    }
    private static void testLinkedList() {
        CustomLinkedList l = new CustomLinkedList();
        check(!l.delete(3) && !l.search(3), "empty linked list");
        l.insertEnd(2); l.insertFront(1); l.insertEnd(3);
        check(l.search(2) && l.delete(2) && !l.search(2), "linked list search/delete");
    }
    private static void testSearching() {
        int[] values = {9, 2, 7, 2};
        check(SearchingAlgorithms.linearSearch(values, 7) == 2, "linear search");
        int[] sorted = SearchingAlgorithms.sortedCopy(values);
        check(Arrays.equals(sorted, new int[]{2, 2, 7, 9}), "sorted copy ascending");
        check(Arrays.equals(values, new int[]{9, 2, 7, 2}), "sorted copy preserves original data");
        check(SearchingAlgorithms.binarySearch(sorted, 7) >= 0, "binary search sorted data");
        check(SearchingAlgorithms.binarySearch(sorted, 100) == -1, "binary search missing");
        check(SearchingAlgorithms.measureLinearSearch(values, 7).getComparisons() == 3, "linear comparisons");
    }
    private static void testGraph() {
        Graph g = new Graph();
        g.addVertex("A"); g.addVertex("B"); g.addVertex("C");
        check(g.addEdge("A", "B"), "graph edge");
        check(!g.addEdge("A", "Z"), "graph rejects missing vertex");
        check(g.bfs("A").equals(Arrays.asList("A", "B")), "BFS");
        check(g.dfs("A").equals(Arrays.asList("A", "B")), "DFS");
        check(g.bfs("missing").isEmpty(), "BFS missing start");
    }
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError("Failed: " + message);
    }
}