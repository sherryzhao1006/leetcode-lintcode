package backtracking;
import java.util.*;
/**
 * The set [1,2,3,É,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * Tags: Backtracking, Math
 */
public class PermutationSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 1)); // 123
        System.out.println(getPermutation(4, 2)); // 132
        System.out.println(getPermutation(4, 3)); // 213
        System.out.println(getPermutation(4, 4)); // 231
        System.out.println(getPermutation(4, 5)); // 312
        System.out.println(getPermutation(4, 6)); // 321
	}
	public static String getPermutation(int n, int k) {
        List<Integer> num=new ArrayList<Integer>();
        for(int i=1;i<=n;++i){
        	num.add(i);
        }
        int[] factor=new int[n];
        factor[0]=1;
        for(int i=1;i<n;++i){
        	factor[i]=factor[i-1] * i;
        }
        k=k-1;
        StringBuffer br=new StringBuffer();
        for(int i=n;i>0;--i){
        	int pos=k/factor[i-1];
        	k=k%factor[i-1];
        	br.append(num.get(pos));
        	num.remove(pos);
        }
        return br.toString();
    }

}
