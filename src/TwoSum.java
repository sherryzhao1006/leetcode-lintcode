
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
		for(List<Integer> sub:sumwithoutdup(num,13)){
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
		Set<Integer> set=new HashSet<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;++i){
			int left=target-numbers[i];
			if(set.contains(left)){
				if(!map.containsKey(left) && !map.containsKey(numbers[i])){
					map.put(left, numbers[i]);
				}
			}//else{
				set.add(numbers[i]);
			//}
		}
		for(int i:map.keySet()){
			List<Integer> sub=new ArrayList<Integer>();
			sub.add(i);
			sub.add(map.get(i));
			result.add(sub);
		}
		return result;
	}
	//Input array already sorted
	public int[] SumSorted(int[] num,int target){
		int[] result=new int[2];
		if(num == null || num.length == 0){
			return result;
		}
		int i=0,j=num.length-1;
		while(i<j){
			long sum=num[i]+num[j];
			if( sum  == target){
				result[0]=i+1;
				result[2]=j+1;
				return result;
			}else if(sum<target){
				i++;
			}else{
				j--;
			}
		}
		return result;
	}

}
