package String;
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

	}

}
class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
	public int read(char[] buf, int n) {
        char[] buffer=new char[4];
        boolean EOF=false;
        int read=0;
        while(!EOF && read<n){
            int now=read4(buffer);
            if(now < 4){
                EOF=true;
            }
            int length=Math.min(now,n-read);//判断是读到的少还是剩下来少
            for(int i=0;i<length;++i){
                buf[read+i]=buffer[i];
            }
            read+=length;
        }
        return read;
    }
}
