package backtracking;
import java.util.*;
public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,1,2};
		permuteUnique(nums);
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> sub=new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visit=new boolean[nums.length];
        helper(result,sub,nums,visit);
        return result;
    }
    public static void helper(List<List<Integer>> result,List<Integer> sub,int[] nums,boolean[] visit){
        if(sub.size() == nums.length){
            result.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if((i != 0 && nums[i]==nums[i-1] && visit[i-1]) || visit[i]){
                continue;
            }
            sub.add(nums[i]);
            visit[i]=true;
            System.out.print(i+":");
            for(boolean bl:visit) System.out.print(bl+" ");
            System.out.println();
            helper(result,sub,nums,visit);
            System.out.println("------");
            visit[i]=false;
            sub.remove(sub.size()-1);
        }
    }
}
