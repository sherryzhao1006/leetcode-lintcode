package binarysearch;

public class FastPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int fastPower(int a,int b,int n){
		if(n>=0){
			return helper(a,b,n);
		}
		else{
			return 1/helper(a,b,n);
		}
	}
	public static int helper(int a, int b, int n){
		if(n == 0){
			return 1%b;
		}
		if(n == 1){
			return a%b;
		}
		long tmp=helper(a,b,n/2);
		long sum=(tmp*tmp);
		if(n %2 != 0){
			sum=(sum*a)%b;
		}
		return (int)sum;
	}

}
