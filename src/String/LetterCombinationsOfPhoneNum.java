package String;
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
class LetterCombinationsOfPhoneNum {
    private static final String[] keys={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        //System.out.println(letterCombinations("234"));


    }
//    public static List<String> letterCombinations(String digits){
//    	List<String> result=new ArrayList<String>();
//    	if(digits.length()==0 || digits==null){
//    		return result;
//    	}
//    	StringBuffer br=new StringBuffer();
//    	helper(result,br,digits);
//    	return result;
//    }
//    public static void helper(List<String> result, StringBuffer br, String digits){
//    	if(br.length()==digits.length()){
//    		result.add(br.toString());
//    		return;
//    	}
//    	String c=keys[digits.charAt(br.length())-'0'];
//    	for(int i=0;i<c.length();++i){
//    		br.append(c.charAt(i));
//    		helper(result,br,digits);
//    		br.deleteCharAt(br.length()-1);
//    	}
//    }
    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        StringBuffer br=new StringBuffer();
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        helper(digits,result,br,0,map);
        return result;
    }
    public static void helper(String digits,List<String> result,StringBuffer br,int pos,Map<Integer,String> map){
    	System.out.println(pos);
        if(pos == digits.length()){
            result.add(br.toString());
            return;
        }
        String str=map.get(digits.charAt(pos)-'0');
        for(int i=0;i<str.length();++i){
            br.append(str.charAt(i));
            helper(digits,result,br,pos+1,map);
            br.deleteCharAt(br.length()-1);
        }
    }
}
