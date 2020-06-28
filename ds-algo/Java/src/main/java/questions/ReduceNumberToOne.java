package questions;

import java.util.HashSet;
import java.util.Set;

public class ReduceNumberToOne {

    //Given a number square each digit of the number and add them together than continue squaring
    // and adding until the value equals 1 or you determine an infinite loop

    public static void main(String[] args){
        System.out.println(numberReducer(19));
        System.out.println(numberReducer(1));
    }

    private static boolean numberReducer(int num) {
        Set<Integer> intSet = new HashSet<>();
        intSet.add(num);
        int total = 0;
        char[] nums = ("" + num).toCharArray();
        while(total != 1){
            total = 0;
            for(char i : nums){
                total += Math.pow(i - '0', 2);
            }
            if(intSet.contains(total)){
                return false;
            }
            intSet.add(total);
            nums = ("" + total).toCharArray();
        }

        return true;
    }

}
