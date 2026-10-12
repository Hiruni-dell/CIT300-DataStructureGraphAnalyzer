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

        System.out.println("\nPERFORMANCE / COMPLEXITY COMPARISON");
        System.out.println("Original data: " + Arrays.toString(data));
        System.out.println("Sorted data for binary search: " + Arrays.toString(sorted));
        System.out.println("Target: " + target);
        System.out.println("Linear search: index in original data = " + linear.getIndex()
                + ", comparisons = " + linear.getComparisons()
                + ", elapsed time (ns) = " + linear.getElapsedNanos());
        System.out.println("Binary search: index in sorted data = " + binary.getIndex()
                + ", comparisons = " + binary.getComparisons()
                + ", elapsed time (ns) = " + binary.getElapsedNanos());
        System.out.println("Note: sorting is performed before binary search; sorting cost is not included in its search timing.");
        System.out.println("\nTHEORETICAL COMPLEXITY");
        System.out.println("Array search: O(n); insertion at end: O(1) amortized; deletion: O(n)");
        System.out.println("Stack push: O(1) amortized; pop/peek: O(1)");
        System.out.println("Circular queue enqueue: O(1) amortized; dequeue/front: O(1)");
        System.out.println("Linked-list search/delete: O(n); insert at front: O(1); insert at end: O(n)");
        System.out.println("Linear search: O(n); binary search: O(log n) on sorted data");
        System.out.println("Graph BFS/DFS with adjacency lists: O(V + E), where V=vertices and E=edges");
        System.out.println("Measured nanoseconds can vary due to JVM warm-up and machine load; comparison counts are more reproducible.");
    }
}