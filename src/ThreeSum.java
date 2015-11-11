
import java.util.*;
/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ² b ² c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<List<Integer>> threeSum(int[] num){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		Arrays.sort(num);
		for(int i=0;i<num.length;++i){
			//remove duplicate
			if(i!=0 && num[i]== num[i-1]){
				continue;
			}
			int left=i+1,right=num.length-1;
			while(left<right){
				int sum=num[i]+num[left]+num[right];
				if(sum == 0){
					List<Integer> sub=new ArrayList<Integer>();
					sub.add(num[i]);
					sub.add(num[left]);
					sub.add(num[right]);
					result.add(sub);
					left++;
					right--;
					while(left<right && num[left]==num[left-1]){
						left++;
					}
					while(left<right && num[right] == num[right+1]){
						right--;
					}
				}
				else if(sum<0){
					left++;
				}
				else{
					right--;
				}
			}
		}
		return result;
	}
	

}
