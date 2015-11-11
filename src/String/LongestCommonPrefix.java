package String;
/**
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * Tags: String
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return "";
    	}
    	int i=0;
    	for(;i<strs[0].length();++i){
    		char a=strs[0].charAt(i);
    		for(int j=1;j<strs.length;++j){
    			if(i == strs[j].length() || strs[j].charAt(i) != a){
    				return strs[j].substring(0, i);
    			}
    		}
    	}
    	return strs[0];
    }

}
