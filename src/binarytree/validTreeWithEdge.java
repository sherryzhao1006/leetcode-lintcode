package binarytree;
import java.util.*;
public class validTreeWithEdge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges=new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}};
		int[][] edges1=new int[][]{{0,1},{2,3},{2,4}};
		System.out.println(validTree(5,edges));
		System.out.println(validTree(5,edges1));

	}
	public static boolean validTree(int n,int[][] edges){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<n;++i){
			map.put(i, i);
		}
		for(int i=0;i<edges.length;++i){
			System.out.println(edges[i][0]+" "+edges[i][1]);
			int f1=find(map,edges[i][0]);
			int f2=find(map,edges[i][1]);
			if(f1 != f2){
				union(map,f1,f2);
			}
			else{
				return false;
			}
		}
		return n==edges.length+1;
	}
	public static int find(Map<Integer,Integer> map,int edge){
		System.out.print(edge);
		while(edge != map.get(edge)){
			edge=map.get(edge);
		}
		System.out.print(" "+edge);
		return edge;
	}
	public static void union(Map<Integer,Integer>map, int f1,int f2){
		map.put(f1, f2);
	}

}
