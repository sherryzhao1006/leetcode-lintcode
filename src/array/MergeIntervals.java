package array;
import java.util.*;
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0 || intervals.size() == 1){
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());       
        int pos=0;
        Interval inter=intervals.get(0);
        for(int i=1;i<intervals.size();++i){
            if(intervals.get(i).start>inter.end){
                result.add(inter);
                inter=intervals.get(i);
                pos++;
            }
            else if(intervals.get(i).end<inter.start){
                result.add(intervals.get(i));
                pos++;
            }
            else{
                inter.start=Math.min(inter.start,intervals.get(i).start);
                inter.end=Math.max(inter.end,intervals.get(i).end);
            }
        }
        result.add(pos,inter);
        return result;
    }
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
