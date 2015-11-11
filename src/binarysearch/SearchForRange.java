package binarysearch;
/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * Tags: Array, Binary Search
 */
public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] range = searchRange(A, 3);
        System.out.println(range[0] + " ~ " + range[1]);
	}
	public static int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        if(nums.length == 0 || nums == null){
            return result;
        }
        int start=0,end=nums.length-1;
        int mid;
        while(start+1<end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                end=mid;
            }
            else if(nums[mid]<target){
                start=mid;
            }
            else end=mid;
        }
        if(nums[start]==target){
            result[0]=start;
        }
        else if(nums[end]==target){
            result[0]=end;
        }
        else return result;
        start=0;
        end=nums.length-1;
        while(start+1<end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                start=mid;
            }
            else if(nums[mid]>target){
                end=mid;
            }
            else start=mid;
        }
        if(nums[end]==target){
            result[1]=end;
        }
        else if(nums[start]==target){
            result[1]=start;
        }
        else return result;
        return result;
	}

}
