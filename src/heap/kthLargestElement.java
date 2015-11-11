package heap;
import java.util.*;
public class kthLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int kthLargestElement(int k, ArrayList<Integer> numbers){
		if(numbers == null || numbers.size() == 0){
			return 0;
		}
		return helper(k, numbers,0,numbers.size()-1);
	}
	public static int helper(int k,ArrayList<Integer> numbers, int start,int end){
		int pivotIndex=start;
		int pivot=numbers.get(start);
		int r=end;
		while(start<=end){
			while(start<=end && numbers.get(start)<=pivot){
				start++;
			}
			while(start<=end && numbers.get(end)>pivot){
				end--;
			}
			if(start<=end){
				int tmp=numbers.get(start);
				numbers.set(start,numbers.get(end));
				numbers.set(end,tmp);
			}
		}
		int tmp=numbers.get(pivotIndex);
		numbers.set(pivotIndex, numbers.get(end));
		numbers.set(end, tmp);
		if(end+1<numbers.size()-k+1){
			return helper(k,numbers,end+1,r);
		}
		else if(end+1>numbers.size()-k+1){
			return helper(k,numbers,pivotIndex,end-1);
		}
		else{
			return numbers.get(r);
		}
	}

}
