package backtracking;
import java.util.*;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * Tags: Array, Backtracking, Bit Manipulation
 */
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> l : res) {
            System.out.println(l.toString());
        }
	}
	public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(S == null || S.length == 0){
            return result;
        }
        List<Integer> sub= new ArrayList<Integer>();
        Arrays.sort(S);
        help(result,sub,S,0);
        return result;
    }
    public static void help(List<List<Integer>> result,List<Integer> sub,int[] S,int pos){
        result.add(new ArrayList<Integer>(sub));
        for(int i=pos;i<S.length;++i){
            sub.add(S[i]);
            help(result,sub,S,i+1);
            sub.remove(sub.size()-1);
        }
    }

}
