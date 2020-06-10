import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimpleComparator {
    static void parseWords(String input) {
        String[] strArray = input.split(" ");
        List<String> wordList = Arrays.asList(strArray);
        Collections.sort(wordList, new SimpleCompareStringLength());

        // Arrays.sort(str, Comparator.comparingInt(String::length));
        for(int i = 0; i < wordList.size(); i++){
            System.out.println(" " + wordList.get(i));
        }
    }

    public static void main(String[] args) {
        parseWords("So that his place shall never be with those cold and timid souls who neither know victory nor defeat");
    }
}

class SimpleCompareStringLength implements Comparator<String> {
    public int compare(String o1, String o2) {
        int result = Integer.compare(o1.length(), o2.length());
        System.out.println("compared  :" +  o1 +" -> "+ o2 + " = " + result);
        return result;
    }
}