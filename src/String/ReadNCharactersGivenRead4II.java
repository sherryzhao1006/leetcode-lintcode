package String;
import String.Reader4;


public class ReadNCharactersGivenRead4II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read s=new read();
		char[] buf=new char[10];
		char[]buf1=new char[12];
		System.out.println(s.bufsize+" "+s.offset+" "+s.read(buf,9));
		System.out.println(s.bufsize+" "+s.offset+" "+s.read(buf1,10));
	}
	

}

class read extends Reader4{
	char[] buffer=new char[4];//input of read4
	int offset=0;//keep track of the offset index where data befins in the nextread call
	int bufsize=0;//the size of remider from last call
	public int read(char[] buf,int n){
		int read=0;
		boolean eof=false;
		while(!eof && read<n){
			int curr=0;
			if(bufsize>0){
				curr=bufsize;
			}else{
				curr=super.read4(buffer);
			}
			if(bufsize == 0 && curr<4){
				eof=true;
			}
			int length=Math.min(curr, n-read);
			for(int i=0;i<length;++i){
				buf[read+i]=buffer[offset+i];
			}
			offset=(offset+length)%4;
			bufsize=curr-length;
			read+=length;
		}
		return read;
	}
}
