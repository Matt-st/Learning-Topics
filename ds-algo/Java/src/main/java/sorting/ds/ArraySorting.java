package sorting.ds;

import java.util.*;

public class ArraySorting {

    static void sortIntArray( int[] numArr) {
        Arrays.sort(numArr, 1,5);
        System.out.println("Subset of sorted numbers : " + Arrays.toString(numArr));
        Arrays.sort(numArr);
        System.out.println("All sorted numbers : " + Arrays.toString(numArr));
       int val = Arrays.binarySearch(
               numArr, 2
       );
        System.out.println("Found 2 at this position: " + val);
        String[] str = new String[]{"Volvo", "BMW", "Ford", "Mazda"};
        Arrays.sort(str);
        System.out.println("All sorted strings : " + Arrays.toString(str));
    }

    public static void main(String[] args) {
        int[] myIntArray = new int[]{100, 20, 320, 400, 2, 9, 4, 3, 67, 54, 34};
        sortIntArray(myIntArray);
    }
}
