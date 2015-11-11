

public class sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Sqrt(3));
		//int[] arr=new int[]{1,2,3,4,999999999};
		//System.out.println(sumPairs(arr));
	}
	public static int Sqrt(int x){
		if(x<0){
			throw new IllegalArgumentException();
		}
		if(x<=1){
			return x;
		}
		long start=0,end=x;
		while(start+1<end){
			long mid=start+(end-start)/2;
			if(mid*mid == x){
				return (int)mid;
			}
			else if(mid *mid<x){
				start=mid;
			}else{
				end=mid;
			}
		}
		if(end*end == x){
			return (int)end;
		}
		return (int)start;
	}

}
