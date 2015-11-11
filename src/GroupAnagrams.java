/*
 * Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
 */
import java.util.*;
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        String[] a = {"tea","and","ate","eat","den"};
	        System.out.println(groupAnagrams(a));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<strs.length;++i){
            char[] convert=strs[i].toCharArray();
            Arrays.sort(convert);
            String after=new String(convert);
            if(!map.containsKey(after)){
                ArrayList<String> list=new ArrayList<String>();
                list.add(strs[i]);
                map.put(after,list);
            }
            else{
            	map.get(after).add(strs[i]);
            }
        }
        for (List<String> temp : map.values()){
        	Collections.sort(temp);
            	result.add(temp);
        }
        return result;
	}
}
