package dynamicprogramming;
import java.util.*;
/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int minimumTotal(List<List<Integer>> triangle){
		if(triangle.size() == 0 || triangle == null){
			return 0;
		}
		int n=triangle.size();
		int[][] sum=new int[n][n];
		for(int i=0;i<n;++i){
			sum[n-1][i]=triangle.get(n-1).get(i);
		}
		for(int i=n-2;i>=0;--i){
			for(int j=0;j<=i;++j){
				sum[i][j]=Math.min(sum[i+1][j],sum[i+1][j+1])+triangle.get(i).get(j);
			}
		}
		return sum[0][0];
	}

}
