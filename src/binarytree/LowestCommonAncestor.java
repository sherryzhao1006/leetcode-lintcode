package binarytree;
import binarytree.TreeNode;
/*
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(4);
		TreeNode one=new TreeNode(3);
		root.left=one;
		TreeNode two=new TreeNode(7);
		root.right=two;
		TreeNode three=new TreeNode(5);
		TreeNode four=new TreeNode(6);
		two.left=three;
		two.right=four;
		System.out.println(lowestCommonAncestor(root,one,three).val);
	}
	public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode A,TreeNode B){
		if(root == null || A == null || B == null){
			return null;
		}
		return getAncestor(root,A,B);
	}
	public static TreeNode getAncestor(TreeNode root,TreeNode A,TreeNode B){
		if(root == null || root == A || root == B){
			return root;
		}
		//Divided
		TreeNode left=getAncestor(root.left,A,B);
		TreeNode right=getAncestor(root.right,A,B);
		//Conquer
		if(left != null && right != null){
			return root;
		}
		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}
		return null;
		
	}
	//Binary search tree
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null || root == A || root == B){
            return root;
        }
        if(root.val>A.val && root.val>B.val){
            return lowestCommonAncestorBST(root.left,A,B);
        }
        if(root.val<A.val && root.val<B.val){
           return lowestCommonAncestorBST(root.right,A,B);
        }
        return root;
    }

}
