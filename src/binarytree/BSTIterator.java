package binarytree;
import binarytree.TreeNode;
import java.util.*;
/*
 * mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class BSTIterator {
	private static Stack<TreeNode> stack=new Stack<TreeNode>();
	TreeNode curr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public BSTIterator(TreeNode root){
		curr=root;
	}
	public boolean hasNext(){
		return curr!=null || !stack.empty();
	}
	public int next(){
		while(curr != null){
			stack.push(curr);
			curr=curr.left;
		}
		curr=stack.pop();
		TreeNode node=curr;
		curr=curr.right;
		return node.val;
	}

}
