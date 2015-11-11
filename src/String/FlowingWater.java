package String;


	import java.util.*;
	import java.io.*;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;


	class Point {
	    int x;
	    int y;
	    public Point(int x,int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	public class FlowingWater {

	    public List<Point> flowing_water(int[][] mat) {
	        int n = mat.length;
	        int m = mat[0].length;

	        Map<Point,Boolean> pSet = new HashMap<Point,Boolean>();
	        Map<Point,Boolean> aSet = new HashMap<Point,Boolean>();

	        //放第一行
	        for(int i=0; i < m; i++) {
	            Point currPoint = new Point(0,i);
	            if(pSet.containsKey(currPoint)) {
	                pSet.put(currPoint,true);
	                dfs(pSet,currPoint,mat);
	            }
	        }
	        System.out.println(pSet);
	        //放第一列
	        for(int i=0; i < n; i++) {
	            Point currPoint = new Point(i,0);
	            if(!pSet.containsKey(currPoint)){
	                pSet.put(currPoint,true);
	                dfs(pSet,currPoint,mat);
	            }
	        }
	        System.out.println(pSet);
	        //放最后一行
	        for(int i=0; i < m; i++) {
	            Point currPoint = new Point(n-1,i);
	            if(!aSet.containsKey(currPoint)) {
	                aSet.put(currPoint,true);
	                dfs(aSet,currPoint,mat);
	            }
	        }
	        //放最后一列
	        for(int i=0; i < n;i++) {
	            Point currPoint = new Point(i,m-1);
	            if(!aSet.containsKey(currPoint)) {
	                aSet.put(currPoint,true);
	                dfs(aSet,currPoint,mat);
	            }
	        }
	        //loop through two set and find intersection
	        List<Point> res = new ArrayList<Point>();
	        for(Point pPoint : pSet.keySet()) {
	            if(aSet.containsKey(pPoint)) {
	                res.add(pPoint);
	            }
	        }
	        return res;
	    }
	    public void dfs(Map<Point,Boolean> set,Point currPoint, int[][] mat) {
	        //right,left,top,bottom
	        int[][] dir = {
	                {0,0,-1,1},
	                {1,-1,0,0}
	        };
	        for(int i=0; i < dir[0].length; i++) {
	            int newX = currPoint.x+ dir[0][i];
	            int newY = currPoint.y+ dir[1][i];
	            if(newX >=0 && newX < mat.length && newY >=0 && newY < mat[0].length) {
	                Point nextPoint = new Point(newX,newY);
	                if(set.containsKey(nextPoint) || mat[currPoint.x][currPoint.y] > mat[nextPoint.x][nextPoint.y] ) {
	                    continue;
	                }
	                set.put(nextPoint,true);
	                dfs(set,nextPoint,mat);
	            }
	            else continue;
	        }
	    }
	    public static void main(String[] args) {
	        int[][] m = {
	                {1,2,2,3,5},
	                {3,2,3,4,4},
	                {2,4,5,3,1},
	                {6,7,1,4,5},
	                {5,1,1,2,4}
	        };
	        FlowingWater s = new FlowingWater();
	        List<Point> res = s.flowing_water(m);
	        System.out.println(res);
	    }
	}

