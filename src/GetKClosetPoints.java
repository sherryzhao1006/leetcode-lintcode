public interface PointsOnAPlane {
    /**
     * Stores a given point in an internal data structure
     */
    void addPoint(Point point);
 
    /**
     * For given 'center' point returns a subset of 'p' stored points
     * that are closer to the center than others.
     *
     * E.g.
     * Stored:
     * (1, 1)
     * (0, 3)
     * (0, 4)
     * (0, 5)
     * (0, 6)
     * (0, 7)
     *
     * findNearest(new Point(0, 0), 3) -> (1, 1), (0, 3), (0, 4)
     */
    
    Collection<Point> findNearest(Point center, int p);
 
    static class Point {
        final int x;
        final int y;
        double d;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public double getDist(Point center){
          return Math.sqrt((x-center.x)*(x-center.x)+(y-center.y)*(y-center.y));
        }
    }
}
class PointComparator implements Comparator<Point> {
    Point center = null;
   
    public PointComparator(Point center) {
        this.center = center;
    }
   
    @Override
    public int compare(Point p1, Point p2) {
        double dist1 = p1.getDist(center);
        double dist2 = p2.getDist(center);
        int diff = Double.compare(dist1,dist2);
        return diff;
    }
}

public class myPointsOnAPlane implements PointsOnAPlane{
   
    private List<Point> pts ;
    public myPointsOnAPlane() {
        pts = new ArrayList<Point>();
    }
    @Override
    void addPoint(Point point) {
        pts.add(point);
    }
   
    @Override
    Collection<Point> findNearest(Point center, int p) {

        PriorityQueue<Point> q = new PriorityQueue<Point>(p, new PointComparator(center));
        for(int i=0; i < pts.size(); i++) {
            if(i < p) {
                q.add(pts.get(i));
            } else {
                Point mycurrPoint = pts.get(i);
                if(mycurrPoint.getDist(center) < q.peek().getDist(center)) {
                    q.poll();
                    q.add(mycurrPoint);
                }
            }
        }
        return q;
    }
}


Add :
time : O(1)


findNearest:
time : O(n*(logp))
space : O(p)
================================================================================================
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
	public void setDist(Point)
	public double getDist(){
		return dist;
	}
}
