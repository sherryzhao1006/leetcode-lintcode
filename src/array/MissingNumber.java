package array;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int missingNumber(int[] nums){
		int result=nums[0];
		for(int i=1;i<nums.length;++i){
			result=result^nums[i];
		}
		for(int i=0;i<=nums.length;++i){
			result^=i;
		}
		return result;
	}

}
