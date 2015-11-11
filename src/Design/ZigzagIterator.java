package Design;
import java.util.*;
/*
 * Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {
	Iterator<Integer> it1;
	Iterator<Integer> it2;
	int turns;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1=v1.iterator();
        it2=v2.iterator();
        turns=0;
    }

    public int next() {
    	turns++;
        if(it1.hasNext() && it2.hasNext()){
        	if(turns%2 == 1){
        		return it1.next();
        	}else{
        		return it2.next();
        	}
        }else if(it1.hasNext()){
        	return it1.next();
        }else if(it2.hasNext()){
        	return it2.next();
        }
        return 0;
    }

    public boolean hasNext() {
        return it1.hasNext()||it2.hasNext();
    }
}
/*
 * 后续 Follow Up
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
*/
/*public class ZigzagIterator implements Iterator<Integer> {
    
    List<Iterator<Integer>> itlist;
    int turns;

    public ZigzagIterator(List<List<Integer>> list) {
        this.itlist = new LinkedList<Iterator<Integer>>();
        // 将非空迭代器加入列表
        for(List<Integer> it : list){
        	itlist.add(it.iterator());
        }
        turns = 0;
    }

    public Integer next() {
        Integer res = 0;
        // 算出本次使用的迭代器的下标
        int pos = turns % itlist.size();
        Iterator<Integer> curr = itlist.get(pos);
        res = curr.next();
        // 如果这个迭代器用完，就将其从列表中移出
        if(!curr.hasNext()){
            itlist.remove(turns % itlist.size());
            // turns变量更新为上一个下标
            turns = pos - 1;
        }
        turns++;
        return res;
    }

    public boolean hasNext() {
        return itlist.size() > 0;
    }
}
*/
