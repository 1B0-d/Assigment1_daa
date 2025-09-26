package algo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeSort {
    public static int insCalls = 0;

    public static void saveMetrics(int arraySize) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("metrics.csv", true))) {

            writer.println(arraySize + "," + insCalls);
        } catch (IOException e) {
            System.err.println("writing metrics error" + e.getMessage());
        }
    }
    public static void sort(int[] a) {
        insCalls = 0;
        int[] buf = new int[a.length];
        sort(a, 0, a.length, buf);

        saveMetrics(a.length);
    }

    private static void sort(int[] a, int lo, int hi, int[] buf) {
        int n = hi - lo;
        if (n <= 1) return;

        if (n <= 24) {
            insertion(a, lo, hi);
            insCalls++;
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, buf);
        sort(a, mid, hi, buf);
        merge(a, lo, mid, hi, buf);
    }

    private static void merge(int[] a, int lo, int mid, int hi, int[] buf) {
        int i = lo, j = mid, k = 0;
        while (i < mid && j < hi) buf[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
        while (i < mid) buf[k++] = a[i++];
        while (j < hi)  buf[k++] = a[j++];
        System.arraycopy(buf, 0, a, lo, k);
    }

    private static void insertion(int[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            int x = a[i], j = i - 1;
            while (j >= lo && a[j] > x) { a[j + 1] = a[j]; j--; }
            a[j + 1] = x;
        }
    }
}
