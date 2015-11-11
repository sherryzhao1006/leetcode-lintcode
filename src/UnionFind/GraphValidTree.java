package UnionFind;
import java.util.*;
/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean validTree(int n, int[][] edges) {
        if(n == 0 || n == 1){
        	return true;
        }
        Map<Integer,Integer> father=new HashMap<Integer,Integer>();
        for(int i=0;i<n;++i){
        	father.put(i,i);
        }
        for(int i=0;i<edges.length;++i){
        	int fa=getFather(father,edges[i][0]);
        	int ch=getFather(father,edges[i][1]);
        	if(fa != ch){
        		union(father,fa,ch);
        	}
        	else return false;
        }
        return n == edges.length+1;
        
    }
	public static int getFather(Map<Integer,Integer> map, int i){
		while(i != map.get(i)){
			i=map.get(i);
		}
		return i;
	}
	public static void union(Map<Integer,Integer> map, int fa,int ch){
		map.put(fa, ch);
	}
}
