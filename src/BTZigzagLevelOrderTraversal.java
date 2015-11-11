
import binarytree.TreeNode;
import java.util.*;
/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * 
 */
public class BTZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        boolean zig=false;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> sub=new ArrayList<Integer>();
            for(int i=0;i<size;++i){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(zig){
                    sub.add(0,node.val);
                }
                else{
                    sub.add(node.val);
                }
            }
            zig=!zig;
            result.add(sub);
        }
        return result;
    }

}
