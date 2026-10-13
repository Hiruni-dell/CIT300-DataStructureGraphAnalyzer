package analyzer;

import java.util.Arrays;

/** Demonstrates measured steps, elapsed time, and theoretical complexity. */
public final class PerformanceAnalyzer {
    private PerformanceAnalyzer() {}

    public static void runDemo() {
        int[] data = {42, 15, 8, 23, 16, 4, 15, 9};
        int target = 23;
        int[] sorted = SearchingAlgorithms.sortedCopy(data);

        SearchingAlgorithms.SearchResult linear =
                SearchingAlgorithms.measureLinearSearch(data, target);
        SearchingAlgorithms.SearchResult binary =
                SearchingAlgorithms.measureBinarySearch(sorted, target);

        System.out.println("\n------------ PERFORMANCE COMPARISON -----------");
        System.out.println("Original data: " + Arrays.toString(data));
        System.out.println("Sorted data for binary search: " + Arrays.toString(sorted));
        System.out.println("Target value: " + target);
        System.out.println("\nSEARCH PERFORMANCE");
        System.out.println("Linear search  | Original-array index: " + linear.getIndex()
                + " | Comparisons: " + linear.getComparisons()
                + " | Elapsed time (ns): " + linear.getElapsedNanos());
        System.out.println("Binary search  | Sorted-array index: " + binary.getIndex()
                + " | Comparisons: " + binary.getComparisons()
                + " | Elapsed time (ns): " + binary.getElapsedNanos());
        System.out.println("Note: the binary-search index refers to the sorted copy.");
        System.out.println("Sorting is performed before binary search; sorting time is not included in search timing.");

        System.out.println("\n------------- THEORETICAL COMPLEXITY -----------");
        System.out.println("Array search: O(n); insertion at end: O(1) amortized; deletion: O(n)");
        System.out.println("Stack push: O(1) amortized; pop/peek: O(1)");
        System.out.println("Circular queue enqueue: O(1) amortized; dequeue/front: O(1)");
        System.out.println("Linked-list search/delete: O(n); insert at front: O(1); insert at end: O(n)");
        System.out.println("Linear search: O(n); binary search: O(log n) on sorted data");
        System.out.println("Graph BFS/DFS with adjacency lists: O(V + E), where V = vertices and E = edges");
        System.out.println("Measured nanoseconds may vary with JVM warm-up and machine load.");
        System.out.println("Comparison counts are generally more reproducible than elapsed time.");
        System.out.println("------------------------------------------------");
    }
}
