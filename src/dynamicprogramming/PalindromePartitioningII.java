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
/*dp[i]: the min cut before the ith character
isPal[j][i]:whether the string between j and i is palindrome
Two methods: 1)i from 2 to n, to calculate dp[i] need to know string from j to i-1
2)i from 0 to n-1, but pal from 0 to i
*/
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
        for(int i=0;i<n;++i){
            for(int j=0;j<=i;++j){
                if(s.charAt(i) ==s.charAt(j) && (i-j<=2 || isPal[j+1][i-1])){
                    isPal[j][i]=true;
                    dp[i+1]=Math.min(dp[i+1],dp[j]+1);
                }
            }
        }
        return dp[n];
    }
}
