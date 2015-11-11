package backtracking;
import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * Tags: Array, Backtracking
 */
public class Subsets2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 2};
        System.out.println(subsetsWithDup(num));
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> sub=new ArrayList<Integer>();
        Arrays.sort(nums);
        help(result,sub,nums,0);
        return result;
	}
	public static void help(List<List<Integer>> result,List<Integer> sub,int[] nums,int pos){
        result.add(new ArrayList<Integer>(sub));
        for(int i=pos;i<nums.length;++i){
            if(i != pos && nums[i] == nums[i-1] ){
                continue;
            }
            sub.add(nums[i]);
            help(result,sub,nums,i+1);
            sub.remove(sub.size()-1);
        }
    }
}
