package String;
import java.util.*;
/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example:
 * 
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * Tags: Backtracking, String
 */
class RestoreIPAddress {
    public static void main(String[] args) {
        System.out.println(restoreIPAddresses("25525511135"));
        System.out.println(restoreIPAddresses("010010"));
    }
    public static List<String> restoreIPAddresses(String s){
    	List<String> result=new ArrayList<String>();
    	if(s.length()<4 || s.length()>12){
    		return result;
    	}
    	List<String> sub=new ArrayList<String>();
    	helper(result,sub,s,0);
    	return result;
    }
    public static void helper(List<String> result, List<String> sub,
    		String s,int pos){
    	if(sub.size()==4){
    		if(pos!=s.length()){
    			return;
    		}
    		StringBuffer br=new StringBuffer();
    		for(String tmp:sub){
    			br.append(tmp);
    			br.append(".");
    		}
    		br.deleteCharAt(br.length()-1);
    		result.add(br.toString());
    		return;
    	}
    	for(int i=pos;i<s.length() && i<=pos+3;++i){
    		String tmp=s.substring(pos,i+1);
    		if(isValid(tmp)){
    			sub.add(tmp);
    			helper(result,sub,s,i+1);
    			sub.remove(sub.size()-1);
    		}
    	}
    }
    public static boolean isValid(String s){
    	if(s.charAt(0)=='0'){
    		return s.equals("0");
    	}
    	int digit=Integer.parseInt(s);
    	return digit>=0 && digit<=255;
    }
}
