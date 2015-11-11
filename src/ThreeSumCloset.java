

import java.util.Arrays;

/*
 * 3Sum Closest My Submissions Question Solution 
Total Accepted: 54110 Total Submissions: 198551 Difficulty: Medium
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumCloset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
	}
    public static int threeSumClosest(int[] num, int target) {
    	if(num == null || num.length==0){
    		return 0;
    	}
    	int sum=num[0]+num[1]+num[2];
    	int result=sum;
    	Arrays.sort(num);
    	for(int i=0;i<num.length;++i){
    		if(i!= 0 && num[i] == num[i-1]){
    			continue;
    		}
    		int left=i+1,right=num.length-1;
    		while(left<right){
    				sum=num[i]+num[left]+num[right];
    				if(sum == target){
    					return target;
    				}
    				if(Math.abs(target-sum)<Math.abs(target-result)){
    					result=sum;
    				}
    				if(sum>target){
    					right--;
    				}
    				else{
    					left++;
    				}
    			}
    		}
    	return result;
    }

}
