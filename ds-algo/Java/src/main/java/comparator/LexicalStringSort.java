package comparator;

import java.util.*;

public class LexicalStringSort {

    static void parseWords(String input) {
        String[] strArray = input.split(" ");

        List<String> wordList = Arrays.asList(strArray);
        Collections.sort(wordList, new SimpleCompareStringLength().thenComparing(String::compareToIgnoreCase));
        for(int i = 0; i < wordList.size(); i++){
            System.out.println(" " + wordList.get(i));
        }
    }

    public static void main(String[] args) {
        parseWords("So that his place shall never be with those cold and timid souls who neither know victory nor defeat");
    }
}
