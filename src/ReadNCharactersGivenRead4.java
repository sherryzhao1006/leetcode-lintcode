public class ReadNCharactersGivenRead4 {
/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.

[分析]
每次只能读如4个字符，但是n不一定是n的整数倍。直接一个while循环，然后在里面判断读出来的buff长度是不是小于4。另外，文件的字符数可能少于n。所以需要有eof变量在循环体中做判断。

[注意事项]
1）最后一次读出来的buff长度有可能等于4，所以在while循环的判断条件中，需要加上 readBytes < n [Code]
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		so s=new so();
		char[] buf=new char[10];
		System.out.println(s.read(buf, 10));
	}

}
class Reader4{
	public int read4(char[] buf){
		return 4;
	}
}
class so extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	char[] buffer=new char[4];//input of read4
    	boolean eof=false;//end of file
    	int read=0;//bytes already read;
    	while(!eof && read<n){
    		int curr=read4(buffer);
    		if(curr != 4){
    			eof=false;
    		}
    		int length=Math.min(curr, n-read);
    		for(int i=0;i<length;++i){
    			buf[read+i]=buffer[i];
    		}
    		read+=length;
    	}
    	return read;
    }
}