package backtracking;
import java.util.*;
/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
  */
public class ParlindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("aab"));
        System.out.println(partition("aa"));
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> result=new ArrayList<List<String>>();
        if( s== null || s.length() == 0){
        	return result;
        }
        List<String> sub=new ArrayList<String>();
        helper(s,0,result,sub);
        return result;
    }
	public static void helper(String s,int pos,List<List<String>> result,List<String> sub){
		if(pos == s.length()){
			result.add(new ArrayList<String>(sub));
			return;
		}
		for(int i=pos;i<s.length();++i){
			if(isPal(s,pos,i)){
				sub.add(s.substring(pos,i+1));
				helper(s,i+1,result,sub);
				sub.remove(sub.size()-1);
			}
			else continue;
		}
	}
	public static boolean isPal(String s,int start,int end){
		while(start<end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
