/*
 * 注意：此代码为到（0，0）的距离，且是二维，且comparator是判断p2是否大于p1
 * 如果是小于，则p1-p2
 * 如果不是（0，0），在dist那里做修改
 * 如果是三维则都增加就可
 */
import java.io.*;
import java.util.*;
public class GetKClosetPoints {
	static int size=5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			PriorityQueue<Point> pq = new PriorityQueue<Point>(size, new ReversePointComparator());
//			Scanner sc = new Scanner("Points.txt");
//			int n = sc.nextInt();
//			Point num;
//			for(int i=0; i<size && i<n; i++) {
//				num = new Point(sc.nextDouble(), sc.nextDouble());
//				pq.add(num);
//			}
//			for(int i=size; i<n; i++)
//			{
//				num = new Point(sc.nextDouble(), sc.nextDouble());
//				if(num.getDist() < pq.peek().getDist())
//				{
//					pq.poll();
//					pq.add(num);
//				}
//			}
//			Point [] pts = new Point[pq.size()];
//			pts = pq.toArray(pts);
//			for(int i=0; i<pts.length; i++)
//				System.out.print(pts[i] + " ");
//			System.out.println();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try{
			File myfile=new File("points.txt");
			FileReader fileReader=new FileReader(myfile);
			BufferedReader is=new BufferedReader(fileReader);
			String line=null;
			PriorityQueue<Point> pq=new PriorityQueue<Point>(size,new PointComparator());
			Point num;
			int count=0;
			int n=size;
			if((line=is.readLine()) != null){
				n=Integer.parseInt(line);
			}
			while((line = is.readLine()) != null && count<n){
				String[] sp=line.split(" ");
				num=new Point(Double.parseDouble(sp[0]),Double.parseDouble(sp[1]));
				if(pq.size()<size){
					pq.add(num);
				}
				else{
					if(pq.peek().getDist()>num.getDist()){
						pq.poll();
						pq.add(num);
					}
				}
				count++;
			}
			Point[] pts=new Point[pq.size()];
			pts=pq.toArray(pts);
			System.out.println("result:");
			for(Point p:pts){
				System.out.println(p.x+" "+p.y+" "+p.dist);
			}
			is.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
class PointComparator implements Comparator<Point>{
	public int compare(Point p1,Point p2){
		return (int)(p2.getDist() - p1.getDist());
	}
}
class Point{
	double x;
	double y;
	double dist;
	public Point(double x,double y){
		this.x=x;
		this.y=y;
		this.dist=Math.sqrt(x*x+y*y);
		System.out.println(x+" "+y+" "+dist);
	}
	public double getDist(){
		return dist;
	}
}