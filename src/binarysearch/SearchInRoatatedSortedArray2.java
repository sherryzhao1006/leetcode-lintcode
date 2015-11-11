package binarysearch;
/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * Tags: Array, Binary Search
 */
public class SearchInRoatatedSortedArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{2,4,5,6,7,1,1,1,2,2};
		System.out.println(search(nums,5));
	}
	public static boolean search(int[] nums, int target) {
        if(nums.length==0 || nums==null) return false;
        int start=0,end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[start]<nums[mid]){
                if(nums[start]<=target && target<nums[mid]){
                    end=mid;
                }
                else start=mid;
            }
            else if(nums[start]>nums[mid]){
                if(nums[mid]<target &&target<=nums[end]){
                    start=mid;
                }
                else end=mid;
            }
            else start++;
        }
        if(nums[start]==target || nums[end]==target) return true;
        return false;
    }

}
