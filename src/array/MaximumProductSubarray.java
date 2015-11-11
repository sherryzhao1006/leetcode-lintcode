package array;
/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxProduct(int[] A) {
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	if(A.length ==1){
    		return A[0];
    	}
    	int max=A[0],min=A[0];
    	int result=A[0];
    	for(int i=1;i<A.length;++i){
    		int tmp=max;
    		max=Math.max(Math.max(min*A[i],max*A[i]),A[i]);
    		min=Math.min(Math.min(tmp*A[i], min*A[i]),A[i]);
    		result=Math.max(result, max);
    	}
    	return result;
    }

}
