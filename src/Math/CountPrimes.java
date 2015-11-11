package Math;
import java.util.*;
/*
 * Description:

Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int countPrimes(int n) {
    	if(n<=2){
    		return 0;
    	}
    	boolean[] check=new boolean[n+1];
    	Arrays.fill(check,true);
    	for(int i=2;i<=Math.sqrt(n);++i){
    		if(check[i]){
    			for(int j=2*i;j<=n;j=j+i){
    				check[j]=false;
    			}
    		}
    	}
    	int count=0;
    	for(int i=2;i<=n;++i){
    		if(check[i]){
    			count++;
    		}
    	}
    	return count;
    }

}
