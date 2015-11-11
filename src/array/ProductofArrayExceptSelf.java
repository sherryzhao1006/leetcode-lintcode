package array;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
        	return null;
        }
        int n=nums.length;
        int[] result=new int[n];
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;++i){
        	left[i]=left[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;--i){
        	right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<n;++i){
        	result[i]=left[i]*right[i];
        }
        return result;
    }
}
