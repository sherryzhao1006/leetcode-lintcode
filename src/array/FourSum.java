package array;
import java.util.*;
/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ² b ² c ² d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	if(num == null || num.length<4){
    		return result;
    	}
    	Arrays.sort(num);
    	for(int i=0;i<num.length;++i){
    		if(i!= 0 && num[i]==num[i-1]){
    			continue;
    		}
    		for(int j=i+1;j<num.length;++j){
    			if(j!= i+1&& num[j]==num[j-1]){
    				continue;
    			}
    			int left=j+1,right=num.length-1;
    			while(left<right){
    				int sum=num[i]+num[j]+num[left]+num[right];
    				if(sum == target){
    					List<Integer> sub=new ArrayList<Integer>();
    					sub.add(num[i]);
    					sub.add(num[j]);
    					sub.add(num[left]);
    					sub.add(num[right]);
    					result.add(sub);
    					left++;
    					right--;
    					while(left<right && num[left]==num[left-1]){
    						left++;
    					}
    					while(left<right && num[right]==num[right+1]){
    						right--;
    					}
    				}
    				else if(sum<target){
    					left++;
    				}
    				else{
    					right--;
    				}
    			}
    		}
    	}
    	return result;
    }
	
}
