package analyzer;

import java.util.Arrays;

/** Search algorithms with optional comparison-count reporting. */
public final class SearchingAlgorithms {
    private SearchingAlgorithms() {}

    public static final class SearchResult {
        private final int index;
        private final long comparisons;
        private final long elapsedNanos;

        public SearchResult(int index, long comparisons, long elapsedNanos) {
            this.index = index;
            this.comparisons = comparisons;
            this.elapsedNanos = elapsedNanos;
        }
        public int getIndex() { return index; }
        public long getComparisons() { return comparisons; }
        public long getElapsedNanos() { return elapsedNanos; }
    }

    public static int linearSearch(int[] data, int target) {
        return measureLinearSearch(data, target).getIndex();
    }

    public static int binarySearch(int[] sortedData, int target) {
        return measureBinarySearch(sortedData, target).getIndex();
    }

    public static SearchResult measureLinearSearch(int[] data, int target) {
        long start = System.nanoTime();
        long comparisons = 0;
        int found = -1;
        for (int i = 0; i < data.length; i++) {
            comparisons++;
            if (data[i] == target) { found = i; break; }
        }
        return new SearchResult(found, comparisons, System.nanoTime() - start);
    }

    /** The input must already be sorted in ascending order. */
    public static SearchResult measureBinarySearch(int[] sortedData, int target) {
        long start = System.nanoTime();
        int low = 0, high = sortedData.length - 1;
        long comparisons = 0;
        int found = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;
            if (sortedData[mid] == target) { found = mid; break; }
            if (sortedData[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return new SearchResult(found, comparisons, System.nanoTime() - start);
    }

    public static int[] sortedCopy(int[] data) {
        int[] sorted = Arrays.copyOf(data, data.length);
        Arrays.sort(sorted);
        return sorted;
    }
}