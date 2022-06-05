import java.util.Arrays;
import java.util.Collections;

public class SortingTest {

    public static void main(String[] args) {

        System.out.println("Smooth sort");
        SmoothSort obj1 = new SmoothSort();
        Integer[] v = new Integer [50000];

        System.out.println("Array is sorted in ascending order");
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }
//        System.out.println(Arrays.toString(v));
        long t1 = System.nanoTime();
        obj1.sort(v);
        long t2 = System.nanoTime();
//        System.out.println(Arrays.toString(v));
        System.out.println("Sort time: " + (t2-t1) + "ns");

        System.out.println("Array is sorted in descending order");
        int j = 0;
        for (int i = v.length-1; i >= 0; i--) {
            v[j] = i;
            j++;
        }
//        System.out.println(Arrays.toString(v));
        long t3 = System.nanoTime();
        obj1.sort(v);
        long t4 = System.nanoTime();
//        System.out.println(Arrays.toString(v));
        System.out.println("Sort time: " + (t4-t3) + "ns");

        System.out.println("Array with random order");
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }
        Collections.shuffle(Arrays.asList(v));
//        System.out.println(Arrays.toString(v));
        long t5 = System.nanoTime();
        obj1.sort(v);
        long t6 = System.nanoTime();
//        System.out.println(Arrays.toString(v));
        System.out.println("Sort time: " + (t6-t5) + "ns");




        System.out.println("\nMerge sort");
        MergeSort obj2 = new MergeSort();
        int n = 50000;
        Integer[] a = new Integer[n];

        System.out.println("Array is sorted in ascending order");
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
//        System.out.println(Arrays.toString(a));
        long t7 = System.nanoTime();
        obj2.mergeSort(a, n);
        long t8 = System.nanoTime();
//        System.out.println(Arrays.toString(a));
        System.out.println("Sort time: " + (t8-t7) + "ns");

        System.out.println("Array is sorted in descending order");
        int k = 0;
        for (int i = a.length-1; i >= 0; i--) {
            a[k] = i;
            k++;
        }
//        System.out.println(Arrays.toString(a));
        long t9 = System.nanoTime();
        obj2.mergeSort(a, n);
        long t10 = System.nanoTime();
//        System.out.println(Arrays.toString(a));
        System.out.println("Sort time: " + (t10-t9) + "ns");

        System.out.println("Array with random order");
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        Collections.shuffle(Arrays.asList(a));
//        System.out.println(Arrays.toString(a));
        long t11 = System.nanoTime();
        obj2.mergeSort(a, n);
        long t12 = System.nanoTime();
//        System.out.println(Arrays.toString(a));
        System.out.println("Sort time: " + (t12-t11) + "ns");
    }

}
