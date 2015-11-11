package binarytree;
import binarytree.TreeNode;
import java.util.*;
/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
	17
  4    13
20 8  11  9
may have negative numbers.
 */
class keyToTMap<K,V>{
	Map<K, TreeMap<Integer, V>> keyToBSTMap = new HashMap<K, TreeMap<Integer, V>>();

    public V get(K k, Integer time){
            if(keyToBSTMap.containsKey(k) == false) return null;
            if(keyToBSTMap.get(k).containsKey(time))
                    return  keyToBSTMap.get(k).get(time);
            else
                    return  keyToBSTMap.get(k).lowerEntry(time).getValue();
    }

    public void put(K k , Integer time, V value){
            if(keyToBSTMap.containsKey(k)) keyToBSTMap.get(k).put(time, value);
            else{
                    TreeMap<Integer, V> t = new TreeMap<Integer, V>();
                    t.put(time, value);
                    keyToBSTMap.put(k, t);


            }
            keyToBSTMap.get(k).put(time, value);
    }
}
public class BTMaximumPathSum {
	private static int maxvalue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keyToTMap<String, String> entry = new keyToTMap<String, String>();
		entry.put("k1", 10, "v1");
		System.out.println(entry.get("k1",15));
		TreeNode root=new TreeNode(17);
		TreeNode one=new TreeNode(4);
		TreeNode two=new TreeNode(13);
		TreeNode three=new TreeNode(20);
		TreeNode four=new TreeNode(8);
		TreeNode five=new TreeNode(11);
		TreeNode six=new TreeNode(9);
		root.left=one;
		root.right=two;
		one.left=three;
		one.right=four;
		two.left=five;
		two.right=six;
		System.out.println(maxPathSum(root));
	}
	public static int maxPathSum(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	maxSum(root);
    	return maxvalue;
    }
    public static int maxSum(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	int left=Math.max(0,maxSum(root.left));
    	int right=Math.max(0,maxSum(root.right));
    	maxvalue=Math.max(maxvalue,root.val+left+right);
    	return Math.max(left,right)+root.val;
    }

}
