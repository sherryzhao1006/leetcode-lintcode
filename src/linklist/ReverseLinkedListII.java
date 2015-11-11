package linklist;
/*
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 */
public class ReverseLinkedListII {

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
		head=new ListNode(3);
		head.next=new ListNode(5);
		head=reverseBetween1(head,1,1);
		while(head != null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null || head.next == null) 
            return head;       
        ListNode dummy = new ListNode(-1);
        dummy.next = head;                
        int count = 0;
        ListNode run=dummy;
        while(count<m-1){
        	run=run.next;
        	count++;
        }
        ListNode start=run.next;
        ListNode then=start.next;
        while(count<n){
        	start.next=then.next;
        	then.next=run.next;
        	run.next=then;
        	then=start.next;
        	count++;
        }
        return dummy.next;
    }
    public static ListNode reverseBetween1(ListNode head, int m, int n) {
    	/*
    	 * 思路：先找到要交换的起始点的前面一点，再按照reverse的方法交换，最后链接
    	 */
    	if(head == null || head.next == null){
    		return head;
    	}
    	int count=0;
    	ListNode dummy=new ListNode(0);
    	dummy.next=head;
    	ListNode run=dummy;
    	while(count<m-1){
    		run=run.next;
    		count++;
    	}
    	ListNode curr=run.next;
    	ListNode prev=null;
    	ListNode last=curr;
    	while(curr != null && count<n){
    		ListNode next=curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=next;
    		count++;
    	}
    	run.next=prev;
    	last.next=curr;
    	
    	return dummy.next;
    }


}
