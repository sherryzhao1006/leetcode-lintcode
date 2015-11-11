package array;
/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxSubArray(int[] A) {
    	if(A == null || A.length== 0){
    		return 0;
    	}
    	int n=A.length;
    	int[] global=new int[n];
    	int[] local=new int[n];
    	global[0]=A[0];
    	local[0]=A[0];
    	for(int i=1;i<n;++i){
    		local[i]=Math.max(local[i-1]+A[i], A[i]);
    		global[i]=Math.max(local[i], global[i-1]);
    	}
    	return global[n-1];
//    	if( A== null || A.length == 0){
//    		return 0;
//    	}
//    	int n=A.length;
//    	int[] local=new int[n];
//    	int[] global=new int[n];
//    	local[0]=A[0];
//    	global[0]=A[0];
//    	for(int i=1;i<A.length;++i){
//    		local[i]=Math.max(A[i], local[i-1]+A[i]);
//    		global[i]=Math.max(local[i], global[i-1]);
//    	}
//    	return global[n-1];
    }
}
