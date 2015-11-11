package binarytree;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import binarytree.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Tags: Tree, Stack
 */
public class BTPreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        System.out.println(preorderTraversal(root));
	}
	public static List<Integer> preorderTraversal(TreeNode root){
		List<Integer> result=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(root == null){
			return result;
		}
		stack.push(root);
		while(!stack.empty()){
			TreeNode node=stack.pop();
			result.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left!=null){
				stack.push(node.left);
			}
		}
		return result;
	}

}
