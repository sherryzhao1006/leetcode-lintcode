import java.util.*;
public class EvenLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list=new int[]{1000,500,200,1,5,10,50,70,70,100};
		for(List<Integer> sub:makeLists(list)){
			for(int i:sub){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static List<List<Integer>> makeLists(int[] list){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(list == null || list.length == 0){
			return result;
		}
		List<Integer> l1=new ArrayList<Integer>();
		int t1=0;
		List<Integer> l2=new ArrayList<Integer>();
		int t2=0;
		Arrays.sort(list);
		for(int i=list.length-1;i>=0;i--){
			if(t1<t2 && l1.size()<list.length/2){
				l1.add(list[i]);
				t1+=list[i];
			}else{
				l2.add(list[i]);
				t2+=list[i];
			}
		}
		result.add(l1);
		result.add(l2);
		return result;
	}
}
