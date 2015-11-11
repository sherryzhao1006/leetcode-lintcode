package backtracking;
import java.util.*;
/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */
public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int tar = 8;
        System.out.println(combinationSum2(candidates, tar));
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> sub=new ArrayList<Integer>();
        help(result,sub,candidates,target,0);
        return result;
    }
    public static void help(List<List<Integer>> result,List<Integer>sub, int[] candidates,int target,int pos){
        if(target==0){
            result.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int i=pos;i<candidates.length;++i){
            int newtarget=target-candidates[i];
            if(newtarget>=0){
                sub.add(candidates[i]);
                help(result,sub,candidates,newtarget,i+1);
                sub.remove(sub.size()-1);
            }
            else break;
            while(i<candidates.length -1 && candidates[i] == candidates[i+1]){
                i++;
            }
        }
    }
}
