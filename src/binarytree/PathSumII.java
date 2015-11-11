package binarytree;
import binarytree.TreeNode;
import java.util.*;
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		List<Integer> sub=new ArrayList<Integer>();
		help(result,sub,root,sum);
		return result;
	}
	public static void help(List<List<Integer>> result,List<Integer> sub, TreeNode node, int sum){
		if(node == null){
			return;
		}
		sub.add(node.val);
		if(node.left == null && node.right == null){
			if(node.val == sum){
				result.add(new ArrayList<Integer>(sub));
				sub.remove(sub.size()-1);
				return;
			}
			else{
				sub.remove(sub.size()-1);
				return;
			}
		}
		else{
			help(result,sub,node.left,sum-node.val);
			help(result,sub,node.right,sum-node.val);
		}
		sub.remove(sub.size()-1);
	}

}
