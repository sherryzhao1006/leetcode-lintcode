package Math;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(int x) {
    	if(x>=0 && x<=9){
    		return true;
    	}
    	int result=0;
    	int tmp=x;
    	while(tmp>0){
    		result=result*10+tmp%10;
    		tmp=tmp/10;
    	}
    	return result==x;
    }

}
