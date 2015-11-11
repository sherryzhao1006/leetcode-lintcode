package linklist;
/*
 * For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	ListNode run=dummy;
    	dummy.next=head;
    	while(run.next != null && run.next.next != null){
    		if(run.next.val == run.next.next.val){
    			int val=run.next.val;
    			while(run.next != null && run.next.val == val){
    				run.next=run.next.next;
    			}
    		}
    		else{
    			run=run.next;
    		}
    	}
    	return dummy.next;
    }

}
