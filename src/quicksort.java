/*
 * Average time complexity:O(nlogn)
 * The steps are:

Pick an element, called a pivot, from the array.
Reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
 */

public class quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{-1,-2,-3,-100,-1,-50,2,4,5,6,7,8,8};
		quicksort(nums,0,nums.length-1);
		System.out.println("After sort:");
		for(int i:nums){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void quicksort(int[] nums,int start,int end){
		if(start>=end){
			return;
		}
		int left=start+1,right=end;
		int pivot=nums[start];
		int index=start;
		while(left<=right){
			while(left<=right && nums[left]<=pivot){
				left++;
			}
			while(left<=right && nums[right]>pivot){
				right--;
			}
			if(left>right){
				break;
			}
			int tmp=nums[left];
			nums[left]=nums[right];
			nums[right]=tmp;
		}
		int tmp=nums[right];
		nums[right]=pivot;
		nums[index]=tmp;
		quicksort(nums,start+1,right-1);
		quicksort(nums,right+1,end);
	}
}
