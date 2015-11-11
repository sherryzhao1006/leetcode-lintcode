

/**
 * Given a string S, find the longest palindromic substring in S. You may
 * assume that the maximum length of S is 1000, and there exists one unique
 * longest palindromic substring.
 *
 * Tags: String
 */
class LongestPalindromicSubstring {
/* if char from 1 to 3 is palindrome, but 1to 4 is not, then check whether 0 to 4 is
 * then record the position and return
 */
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s){
    	if(s == null || s.length() == 0){
    		return "";
    	}
    	if(s.length() == 1){
    		return s;
    	}
    	int n=s.length();
    	boolean[][] dp=new boolean[n][n];
    	int max=Integer.MIN_VALUE;
    	int start=0, end=0;
    	for(int i=0;i<n;++i){
    		dp[i][i]=true;
    	}
    	for(int i=0;i<n;++i){
    		for(int j=0;j<i;++j){
    			if(s.charAt(i) == s.charAt(j) && (i-j<3 || dp[j+1][i-1])){
    				dp[j][i]=true;
    				if(max<i-j+1){
    					max=i-j+1;
    					start=j;
    					end=i;
    				}
    			}
    		}
    	}
    	return s.substring(start,end+1);
    }
}
