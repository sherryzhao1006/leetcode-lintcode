package linklist;
/*
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode removeElements(ListNode head, int val) {
    	if(head == null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode run=dummy;
    	while(run.next != null){
    		if(run.next.val == val){
    			run.next=run.next.next;
    		}
    		else{
    			run=run.next;
    		}
    	}
    	return dummy.next;
    }
}
