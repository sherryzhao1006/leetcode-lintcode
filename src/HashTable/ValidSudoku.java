package HashTable;
import java.util.*;
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        boolean[] visit=new boolean[9];
        //check row
        for(int i=0;i<9;++i){
            Arrays.fill(visit,false);
            for(int j=0;j<9;++j){
                if(board[i][j] == '.'){
                    continue;
                }
                else{
                    int val=board[i][j]-'1';
                    if(visit[val]) return false;
                    visit[val]=true;
                }
            }
            Arrays.fill(visit,false);
            for(int j=0;j<9;++j){
                if(board[j][i]=='.'){
                    continue;
                }
                else{
                    int val=board[j][i]-'1';
                    if(visit[val]) return false;
                    visit[val]=true;
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;++j){
                Arrays.fill(visit,false);
                for(int s=0;s<9;++s){
                    if(board[i*3+s/3][j*3+s%3] == '.') continue;
                    else{
                        int val=board[i*3+s/3][j*3+s%3]-'1';
                        if(visit[val]) return false;
                        visit[val]=true;
                    }
                }
            }
        }
        return true;
    }
}
