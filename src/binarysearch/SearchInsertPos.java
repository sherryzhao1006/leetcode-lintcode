package binarysearch;
/*
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ->2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * 
 * Tags: Array, Binary Search
 */
public class SearchInsertPos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,3,5,6};
		System.out.println(searchInsert(nums,5));
	}
	public static int searchInsert(int[] nums, int target) {
        if(nums.length==0 ||nums==null) return -1;
        int start=0,end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                start=mid;
            }
            else if(nums[mid]>target){
                end=mid;
            }
        }
        if(nums[start]>=target) return start;
        else if(nums[end]>=target) return end;
        else return end+1;
    }

}
