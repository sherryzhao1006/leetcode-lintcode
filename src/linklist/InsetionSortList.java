package linklist;

public class InsetionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode dummy=new ListNode(0);
    	dummy.next =head;
    	while(head != null && head.next != null){
    		if(head.val<=head.next.val){
    			head=head.next;
    		}
    		else{
    		ListNode run=dummy;
    		while(run.next.val<=head.next.val){
    			run=run.next;
    		}
    		ListNode next=run.next;
    		run.next=head.next;
    		head.next=head.next.next;
    		run.next.next=next;
    		}
    	}
    	return dummy.next;
    }

}
