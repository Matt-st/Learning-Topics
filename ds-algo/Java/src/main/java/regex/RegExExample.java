package regex;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample {

    static void exampleOne(){
        String content = "This is Chaitanya " +
                "from Beginnersbook.com.";

        String pattern = ".*book.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("The text contains 'book'? " + isMatch);
    }

    static void exampleTwo(){
        String content = "This is a tutorial Website!";
        String patternString = ".*tuToRiAl.*";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        boolean isMatched = matcher.matches();
        System.out.println("Is it a Match?" + isMatched);
        matcher.regionStart();
        matcher.regionEnd();
        System.out.println("the word is" + content.substring(matcher.regionStart(), matcher.regionEnd()));
        MatchResult m = matcher.toMatchResult();

    }

    static void exampleThree(String str){

        String patternString = ".*class.*";
        Pattern classPattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = classPattern.matcher(str);
        boolean isMatched = matcher.matches();
        System.out.println("Is it a Match?" + isMatched);
        matcher.regionStart();
        matcher.regionEnd();
        System.out.println("the word is" + str.substring(matcher.regionStart(), matcher.regionEnd()));
        MatchResult m = matcher.toMatchResult();

    }

    public static void main(String args[]){
        exampleOne();
        exampleTwo();
        exampleThree("class checker{ public static void main(){return true;}}");
    }
}
