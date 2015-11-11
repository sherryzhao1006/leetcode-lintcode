
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{2,3,5,6,7,8,9,10,11,12,13,14,15};
		System.out.println(missing2(nums));
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
	public static int missing2(int[] nums){
		if(nums == null|| nums.length == 0){
			return 0;
		}
		int result=nums[0];
		int max=nums[0];
		int min=nums[0];
		for(int i=1;i<nums.length;++i){
			result^=nums[i];
			max=Math.max(nums[i], max);
			min=Math.min(nums[i], min);
		}
		System.out.println(min+" "+max);
		for(int i=min;i<=max;++i){
			result^=i;
		}
		System.out.println(result);
		
		return result==0?max+1:result;
	}

}
