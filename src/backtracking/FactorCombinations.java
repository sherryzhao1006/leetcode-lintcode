package backtracking;
import java.util.*;
/*
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 */
public class FactorCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result=getFactors(8);
		for(List<Integer> i:result){
			for(Integer a:i){
				System.out.println(a);
			}
			System.out.println();
		}
	}

   	public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(n<=1){
        	return result;
        }
        List<Integer> sub=new ArrayList<Integer>();
        helper(result,sub,2,n,n);
        return result;
    }
	public static void helper(List<List<Integer>> result,List<Integer> sub,int start, int left,int ori){
		if(left == 1){
			result.add(new ArrayList<Integer>(sub));
			return;
		}
		for(int i=start;i<=left && i<ori;++i){
			if(left%i==0){
				sub.add(i);
				helper(result,sub,i,left/i,ori);
				sub.remove(sub.size()-1);
			}
		}
	}
}
