package linklist;
/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode run=head;
    	while(run != null && run.next!= null){
    		if(run.val == run.next.val){
    			run.next=run.next.next;
    		}
    		else{
    			run=run.next;
    		}
    	}
    	return head;
    }

}
