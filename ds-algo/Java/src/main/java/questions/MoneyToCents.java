package questions;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyToCents {


    static void convertToChange(String str){
       str =  str.replace("$", "");
       String[] moneyArr = str.split("\\.");
       int spareChange = Integer.parseInt(moneyArr[1]);
       int dollars = Integer.parseInt(moneyArr[0]);

       int cents = (dollars * 100) + spareChange;

       int quarters = cents/25;
       cents = cents % 25;
       int dimes = cents/10;
       cents = cents % 10;
       int nickels = cents/5;
       cents = cents % 5;

      System.out.println("Quarters: "+ quarters + " dimes: " + dimes + " nickels: " + nickels + " pennies: " + cents);

    }


    public static void main(String[] args){
        convertToChange("$1.26");
    }
}
