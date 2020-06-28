package questions;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacter {


    /*

    Let's build stuff

static void stuff(String str){
	///evaluate the string to determine the first non repeated character
	//apple -> a
	//aaron -> r
      1    2
	for(int i =0; i < str.length(); i++){
		char toCheck = str.charAt(i);
		boolean found = false;
		for(int j = i+ 1; j < str.length(); j++ ){
			if(toCheck == str.charAt()){
				found = true;
			}
		}
		if(!found){
			return toCheck;
		}
	}



}
     */

    public static void main(String[] args){
        System.out.println(findFirstNonRepeatedCharacterN2("apple"));
        System.out.println(findFirstNonRepeatedCharacterN2("aaron"));
        System.out.println(findFirstNonRepeatedCharacterN2("oorramm"));

        System.out.println(linkedHashMapFindNonRepeatedCharacter("apple"));
        System.out.println(linkedHashMapFindNonRepeatedCharacter("aaron"));
        System.out.println(linkedHashMapFindNonRepeatedCharacter("oorramm"));

    }

    private static Character linkedHashMapFindNonRepeatedCharacter(String word){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char letter : word.toCharArray()){
            if(map.containsKey(letter)){
                int count = map.get(letter);
                count = count + 1;
                map.put(letter, count);
            }else{
                map.put(letter, 1);
            }
        }
        Set entrySet = map.entrySet();
        // Obtain an Iterator for the entries Set

        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        while(it.hasNext()){
           Map.Entry entry =  it.next();
            if((int) entry.getValue() == 1){
                return (Character) entry.getKey();
            }

        }
        return null;
    }

    private static Character findFirstNonRepeatedCharacterN2(String word) {
        for(int i = 0; i < word.length(); i++){
            boolean found = false;
            for(int j = i+ 1; j < word.length(); j++ ){
                if(word.charAt(i) == word.charAt(j)){
                    found = true;
                    i++;

                }
            }
            if(!found){
                return word.charAt(i);
            }

        }
        return null;
    }
}
