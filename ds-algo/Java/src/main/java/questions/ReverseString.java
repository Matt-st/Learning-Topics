package questions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ReverseString {



    public static void main(String[] args){
        System.out.println(reverseStringEasy("I3452345 am2345 groot///89034750-234"));
    }

    private static String reverseStringEasy(String sentence) {
        sentence = sentence.trim();//remove leading and trailing whitespace
        //clean up existing string before reversing remove special characters
       StringBuilder cleanUpBuilder = new StringBuilder();
        for(char i : sentence.toCharArray()){
            if( (int) i == 32 ||((int) i >= 65 &&(int) i <= 90) ||( (int) i >= 97 &&(int) i <= 122 )){
                cleanUpBuilder.append(i);
            }

        }

        String[] strArray = cleanUpBuilder.toString().split(" ");
        LinkedList ll = new LinkedList(Arrays.asList(strArray));
        Iterator iterator = ll.descendingIterator();
        StringBuilder builder = new StringBuilder();


        while(iterator.hasNext()){
            builder.append(iterator.next()).append(" ");
        }
        return builder.toString();
    }


}
