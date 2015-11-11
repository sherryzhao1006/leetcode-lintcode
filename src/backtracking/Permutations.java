package backtracking;
import java.util.*;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Tags: Backtracking
 */
public class Permutations {

	public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 3, 2}));
    }
	public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(num==null || num.length==0){
            return result;
        }
        List<Integer> sub=new ArrayList<Integer>();
        help(result,sub,num);
        return result;
    }
    public static void help(List<List<Integer>> result,List<Integer> sub,int[] num){
        if(sub.size()==num.length){
            result.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int i=0;i<num.length;++i){
            if(!sub.contains(num[i])){
                sub.add(num[i]);
                help(result,sub,num);
                sub.remove(sub.size()-1);
            }
        }
    }
}
