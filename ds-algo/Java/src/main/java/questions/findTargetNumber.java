package questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class findTargetNumber {

    /*
    Given a sorted array of numbers and a target number, write a program that will return "true" or "-1"
    if two or more elements in the array add up to the target number.
     */

    static boolean findTargetNumber(int[] arr, int target){


        if(arr[1] > target){
            return false;
        }
        Set<Integer> intSet = new HashSet<>();
        for(int k = 0; k < arr.length; k++){
            intSet.add(k);
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = i +1; j < arr.length; j++){
               intSet.add(arr[i] + arr[j]);
            }
        }
        System.out.println(intSet.toString());
        return false;
    }


    public static void main(String[] args){
        int[] myIntArray = {10, 20, 30, 11};
        Arrays.sort(myIntArray);
        boolean found = findTargetNumber(myIntArray, 85);

        System.out.println("The target exists: "+ found);

    }

}
