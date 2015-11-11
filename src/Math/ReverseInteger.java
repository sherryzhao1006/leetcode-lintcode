package Math;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int reverse(int x){
	int sign=1;
	if(x>=-9 && x<=9){
		return x;
	}
	if(x<0){
		sign=-1;
		x=Math.abs(x);
	}
	int result=0;
	while(x>0){
		int tail=x%10;
        int tmp=result*10+tail;
        if((tmp-tail)/10 != result){
            return 0;
        }
        result=tmp;
        x=x/10;
	}
	result=result*sign;
	return result;
}

}
