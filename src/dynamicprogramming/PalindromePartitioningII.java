package dynamicprogramming;
/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int minCut(String s) {
    	if(s == null || s.length() == 0){
    		return 0;
    	}
    	int n=s.length();
    	int[] dp=new int[n+1];
    	boolean[][] isPal=new boolean[n][n];
    	for(int i=0;i<=n;++i){
    		dp[i]=i-1;
    	}
    	for(int i=2;i<=n;++i){
    		for(int j=i-1;j>=0;--j){
    			if(s.charAt(i-1) == s.charAt(j) && (i-j<3 || isPal[j+1][i-2])){
    				isPal[j][i-1]=true;
    				dp[i]=Math.min(dp[i], dp[j]+1);
    			}
    		}
    	}
    	return dp[n];
    }
}
