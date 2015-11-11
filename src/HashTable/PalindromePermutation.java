package HashTable;
import java.util.*;
public class PalindromePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean canPermutePalindrome(String s){
		boolean odd=false;
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();++i){
			char a=s.charAt(i);
			if(map.containsKey(a)){
				map.put(a, map.get(a)+1);
			}else map.put(a,1);
		}
		for(char a:map.keySet()){
			if(map.get(a)%2 != 0){
			    if(odd)
				    return false;
				odd =true;
			}
		}
		return true;
	}

}
