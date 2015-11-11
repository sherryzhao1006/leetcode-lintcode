import java.util.*;
public class DataStreamMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int[] medianII(int[] nums) {
        //heap:peek是最大 priorityqueue：peek是最小，heap变成queue就是comparator改变
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        int[] output = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            if(maxHeap.isEmpty()) {
                maxHeap.add(nums[i]);
            } else {
                if(nums[i] < maxHeap.peek()){
                    maxHeap.add(nums[i]);
                } else {
                    minHeap.add(nums[i]);
                }
                if(maxHeap.size() > minHeap.size()+1) {
                    minHeap.add(maxHeap.poll());
                }
                if(minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
            output[i] = maxHeap.peek();
        }
        return output;
    }
}
