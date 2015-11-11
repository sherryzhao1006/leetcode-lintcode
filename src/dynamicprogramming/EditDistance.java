package dynamicprogramming;
/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int minDistance(String word1, String word2) {
    	if(word1 == null && word2 == null){
    		return 0;
    	}
    	int m=word1.length();
    	int n=word2.length();
    	int[][] dp=new int[m+1][n+1];//word1到m和word2到n需要的最小的距离
    	for(int i=0;i<=m;++i){
    		dp[i][0]=i;
    	}
    	for(int j=0;j<=n;++j){
    		dp[0][j]=j;
    	}
    	for(int i=1;i<=word1.length();++i){
            for(int j=1;j<=word2.length();++j){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
    				dp[i][j]=dp[i-1][j-1];
    			}
    			else{
    				dp[i][j]=Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1])+1;
    			}
            }
        }
        return dp[m][n];
    	
    }
}
