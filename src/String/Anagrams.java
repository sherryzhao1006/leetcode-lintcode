package String;
import java.util.*;
/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * Tags: Hashtable, String
 */
class Anagrams {
    public static void main(String[] args) {
        String[] strs = { "dog", "dot", "cog", "log", "god", "tod"};
        List<String> res = anagrams(strs);
        System.out.println(res.toString());
    }
    public static List<String> anagrams(String[] strs){
    	List<String> result= new ArrayList<String>();
    	if(strs.length==0 || strs==null){
    		return result;
    	}
    	Map<String,Integer> map=new HashMap<String,Integer>();
    	for(int i=0;i<strs.length;++i){
    		char[] word=strs[i].toCharArray();
    		Arrays.sort(word);
    		String key=new String(word);
    		if(map.containsKey(key)){
    			result.add(strs[i]);
    			if(map.get(key)>=0){
    				result.add(strs[map.get(key)]);
    				map.put(key, -1);
    			}
    		}
    		else map.put(key, i);
    	}
    	return result;
    }
}
