package backtracking;
import java.util.*;
/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
public class CombinationSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combinationSum3(2,6));
	}
	public static List<List<Integer>> combinationSum3(int k,int n){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(k==0 || n==0){
			return result;
		}
		List<Integer> sub=new ArrayList<Integer>();
		help(result,sub,k,n,1);
		return result;
	}
	public static void help(List<List<Integer>> result,List<Integer> sub,int k,int n,int num){
		if(k==0){
			if(n!=0){
				return;
			}
			result.add(new ArrayList<Integer>(sub));
			return;
		}
		if(k<0 || n<0){
			return;
		}
		for(int i = num; i <10; ++i){
        sub.add(i);
        help(result,sub,k - 1, n - i, i + 1);
        sub.remove(sub.size()-1);
		}
	}

}
