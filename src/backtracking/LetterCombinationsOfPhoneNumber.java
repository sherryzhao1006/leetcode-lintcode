package backtracking;
import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 * Tags: Backtracking, String
 */
public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(letterCombinations("22"));
	}
	public static List<String> letterCombinations(String digits){
        List<String> result=new ArrayList<String>();
        if(digits.length() == 0 || digits == null){
            return result;
        }
        StringBuffer br=new StringBuffer();
        Map<Character, char[]> map = new HashMap<Character, char[]>();
       map.put('0', new char[] {});
       map.put('1', new char[] {});
       map.put('2', new char[] { 'a', 'b', 'c' });
       map.put('3', new char[] { 'd', 'e', 'f' });
       map.put('4', new char[] { 'g', 'h', 'i' });
       map.put('5', new char[] { 'j', 'k', 'l' });
       map.put('6', new char[] { 'm', 'n', 'o' });
       map.put('7', new char[] { 'p', 'q', 'r', 's' });
       map.put('8', new char[] { 't', 'u', 'v'});
       map.put('9', new char[] { 'w', 'x', 'y', 'z' });
       help(result,br,digits,map);
       return result;
    }
    public static void help(List<String> result,StringBuffer br,String digits,Map<Character,char[]> map){
        if(br.length() == digits.length()){
            result.add(br.toString());
            return;
        }
        char[] c=map.get(digits.charAt(br.length()));
        for(char a:c){
            br.append(a);
            help(result,br,digits,map);
            br.deleteCharAt(br.length()-1);
        }
    }
}
