package String;
import java.util.*;
/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest
 * substring is "b", with the length of 1.
 * 
 * Tags: Hashtable, Two pointers, String
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		  System.out.println(lengthOfLongestSubstring("abcabcbb"));
         System.out.println(lengthOfLongestSubstring("bbbbb"));
         System.out.println(lengthOfLongestSubstring(""));
         System.out.println(lengthOfLongestSubstring("fdjskajfhh"));
         System.out.println(lengthOfLongestSubstring("iiiiiiioooooooooooooo"));
         System.out.println(lengthOfLongestSubstring("aeiou"));
System.out.println(lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
System.out.println(lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
	}
	public static int lengthOfLongestSubstring(String s){
		if(s.length()==0 || s==null){
			return 0;
		}
		HashSet<Character> set=new HashSet<Character>();
		int left=0,max=0,i;
		for(i=0;i<s.length();++i){
			if(set.contains(s.charAt(i))){
				while(left<i && s.charAt(i)!=s.charAt(left)){
					set.remove(s.charAt(left));
					left++;
				}
				left++;
			}
			else{
				set.add(s.charAt(i));
				max=Math.max(max, i-left+1);
			}
		}
		return max;
	}

}
