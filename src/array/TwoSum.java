package array;
import java.util.*;
/*
 * Example
numbers=[2, 7, 11, 15], target=9

return [1, 2]
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[]{0,1,2,2,2,3,4,5,6,7,7,7,7,7,8,8,10,12};
		for(List<Integer> sub:sumwithoutdup(num,14)){
			for(int i: sub){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static int[] twoSum(int[] numbers, int target){
		int[] result=new int[2];
		if(numbers == null || numbers.length == 0){
			return result;
		}
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;++i){
			if(map.containsKey(target-numbers[i])){
				result[0]=map.get(target-numbers[i])+1;
				result[1]=i+1;
			}
			else{
				map.put(numbers[i], i);
			}
		}
		return result;
	}
	public static List<List<Integer>> sumwithoutdup(int[] numbers,int target){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(numbers == null || numbers.length == 0){
			return result;
		}
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;++i){
			if(map.containsKey(numbers[i]) && 2*numbers[i] != target) continue;
			int left=target-numbers[i];
			if(map.containsKey(left)){
				if(numbers[i] == left && i != map.get(left)+1) continue;
					List<Integer> sub=new ArrayList<Integer>();
					sub.add(left);
					sub.add(numbers[i]);
					result.add(sub);
			}
			if(!map.containsKey(numbers[i]))
				map.put(numbers[i], i);
			
		}
		return result;
	}

}
