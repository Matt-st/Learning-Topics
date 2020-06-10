
import java.util.*;

public class LexicalStringSort {

    static void parseWords(String input) {
        String[] strArray = input.split(" ");

        List<String> wordList = Arrays.asList(strArray);
        Collections.sort(wordList, new Comp());

    }

    public static void main(String[] args) {
        parseWords("So that his place shall never be with those cold and timid souls who neither know victory nor defeat");
    }
}


class Comp implements Comparator<String> {
    public int compare(String o1, String o2) {
         /*
        1. Input two strings string 1 and string 2.
        2. for (int i = 0; i < str1.length() &&
                i < str2.length(); i ++)
          (Loop through each character of both
           strings comparing them until one
           of the string terminates):
           a. If unicode value of both the characters
              is same then continue;
           b. If unicode value of character of
              string 1 and unicode value of string 2
              is different then return (str1[i]-str2[i])
        3. if length of string 1 is less than string2
               return str2[str1.length()]
           else
               return str1[str2.length()]

         */
        for(int i = 0; i < o1.length() && i < o2.length(); i++){
            if(o1.charAt(i) == o2.charAt(i)){
                continue;
            }else{
                return o1.charAt(i) - o2.charAt(i);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}