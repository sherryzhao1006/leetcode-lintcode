package array;
import java.util.*;
/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[]{1,1,1,1,2,2,2,3,3,4};
		removeDuplicates(num);
		for(int i:num){
			System.out.print(i+" ");
		}
        List<Iterator<Integer>> Iters=new ArrayList<Iterator<Integer>>();
        List<Integer> onelist=new ArrayList<Integer>();
        ListIterator<Integer> one=onelist.listIterator();
        one.add(2);	}
	public static int removeDuplicates(int[] nums){
		if(nums == null || nums.length <=2){
			return nums.length;
		}
		int length=2;
		int run=2;
		while(run<nums.length){
			if(nums[run]!=nums[length-2]){
				nums[length++]=nums[run];
			}
			run++;
		}
		return length;
	}

}
