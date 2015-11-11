package binarytree;
/**
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric
* around its center).
* 
* For example, this binary tree is symmetric:
* 
*     1
*    / \
*   2   2
*  / \ / \
* 3  4 4  3
* 
* But the following is not:
*     1
*    / \
*   2   2
*    \   \
*    3    3
* 
* Note:
* Bonus points if you could solve it both recursively and iteratively.
* 
* Tags: Tree, DFS, Stack
*/
public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(2);
		TreeNode leftleft=new TreeNode(3);
		TreeNode leftright=new TreeNode(4);
		TreeNode rightleft=new TreeNode(4);
		TreeNode rightright=new TreeNode(3);
		root.left=left;
		root.right=right;
		left.left=leftleft;
		left.right=leftright;
		right.left=rightleft;
		right.right=rightright;
		System.out.println(isSymmetric(root));

	}
	public static boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return isSymmetricSub(root.left,root.right);
	}
	
	public static boolean isSymmetricSub(TreeNode left,TreeNode right){
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null){
			return false;
			}
		if(left.val == right.val){
			return isSymmetricSub(left.left,right.right) && isSymmetricSub(left.right,right.left);
		}
		else return false;
		}
}
		

