package linklist;
/*
 * For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode three=new ListNode(3);
		ListNode four=new ListNode(4);
		ListNode five=new ListNode(5);
		head.next=second;
		second.next=three;
		three.next=four;
		four.next=five;
		five.next=null;
		head=swapPairs(head);
		while(head != null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
    public static ListNode swapPairs(ListNode head) {
    	if(head == null || head.next== null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode run=dummy;
    	while(run.next != null && run.next.next != null){
    		ListNode next=run.next.next.next;
    		ListNode start=run.next;
    		run.next=start.next;
    		run.next.next=start;
    		start.next=next;
    		run=run.next.next;
    	}
    	return dummy.next;
    }

}
