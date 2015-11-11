package binarysearch;
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,1,2,3,3,4,5,6,7,1,1};
		System.out.println(findMin(nums));
	}
	public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int left=0,right=nums.length-1;
        while(left+1<right){
        	int mid=left+(right-left)/2;
        	if(nums[mid]==nums[right]){
        		right--;
        	}
        	else if(nums[mid]<nums[right]){
        		right=mid;
        	}
        	else{
        		left=mid+1;
        	}
        }
        if(nums[left]<nums[right]){
        	return nums[left];
        }
        return nums[right];
    }

}
