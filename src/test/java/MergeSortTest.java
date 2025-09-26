import algo.MergeSort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.Arrays;

public class MergeSortTest {

    private static final int MAX_ARRAY_SIZE = 100000;

    @BeforeEach
    void reset() {
        MergeSort.insCalls = 0;
    }

    @Test
    void testLargeRandomArray() {
        int[] a = generateRandomArray(MAX_ARRAY_SIZE);
        int[] expected = a.clone();
        Arrays.sort(expected);

        MergeSort.sort(a);

        assertArrayEquals(expected, a);
    }

    @Test
    void testRandomArrayWithDuplicates() {
        int[] a = generateRandomArray(1000);
        a[200] = a[300];
        a[500] = a[600];

        int[] expected = a.clone();
        Arrays.sort(expected);

        MergeSort.sort(a);

        assertArrayEquals(expected, a);
    }

    @Test
    void testNegativeNumbers() {
        int[] a = generateRandomArray(5000);

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] - 10000;
        }

        int[] expected = a.clone();
        Arrays.sort(expected);

        MergeSort.sort(a);

        assertArrayEquals(expected, a);
    }

    @Test
    void testMaxSizeArray() {
        int[] a = generateRandomArray(MAX_ARRAY_SIZE);
        int[] expected = a.clone();
        Arrays.sort(expected);

        MergeSort.sort(a);

        assertArrayEquals(expected, a);  }

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(20000) - 10000;
        }
        return a;
    }
}
