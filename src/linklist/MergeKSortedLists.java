package linklist;

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode mergeKLists(ListNode[] lists) {  
    	if(lists == null || lists.length == 0){
    		return null;
    	}
    	return split(lists,0,lists.length-1);
    }
    public ListNode split(ListNode[] lists,int start, int end){
    	if(start>end){
    		return null;
    	}
    	if(start == end){
    		return lists[start];
    	}
    	int mid=start+(end-start)/2;
    	ListNode left=split(lists,start,mid);
    	ListNode right=split(lists,mid+1,end);
    	return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right){
    	ListNode dummy=new ListNode(0);
    	ListNode run=dummy;
    	while(left != null && right != null){
    		if(left.val<right.val){
    			run.next=left;
    			left=left.next;
    		}
    		else{
    			run.next=right;
    			right=right.next;
    		}
    		run=run.next;
    	}
    	if(left != null){
    		run.next=left;
    	}
    	if(right != null){
    		run.next=right;
    	}
    	return dummy.next;
    }

}
