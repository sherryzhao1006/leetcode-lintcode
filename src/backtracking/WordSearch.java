package backtracking;
/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        if(word.length() == 0){
            return false;
        }
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j]==word.charAt(0)){
                    boolean result=help(board,word,i,j,0);
                    if(result){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean help(char[][] board,String word,int i,int j,int pos){
        if(pos==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(pos)){
            return false;
        }
        board[i][j]='#';
        boolean result=help(board,word,i-1,j,pos+1) || help(board,word,i+1,j,pos+1) || help(board,word,i,j-1,pos+1) || help(board,word,i,j+1,pos+1);
        board[i][j]=word.charAt(pos);
        return result;
    }

}
