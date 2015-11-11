package backtracking;
import java.util.*;
/*Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]*/
public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates=new int[4];
		candidates[0]=2;
		candidates[1]=3;
		candidates[2]=6;
		candidates[3]=7;
		System.out.println(combinationSum(candidates,7));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        List<Integer> sub=new ArrayList<Integer>();
        Arrays.sort(candidates);
        help(result,sub,candidates,target,0);
        return result;
    }
    public static void help(List<List<Integer>> result,List<Integer> sub,int[] candidates,int target,int pos){
        if(target==0){
            result.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int i=pos;i<candidates.length;++i){
            int newtarget=target-candidates[i];
            if(newtarget>=0){
                sub.add(candidates[i]);
                help(result,sub,candidates,newtarget,i);
                sub.remove(sub.size()-1);
            }
            else break;
        }
    }
}
