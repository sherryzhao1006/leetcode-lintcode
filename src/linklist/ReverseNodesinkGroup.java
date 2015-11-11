package linklist;
/*
 * Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup {

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
		head=reverseKGroup(head,3);
		while(head != null){
			System.out.print(head.val+" ");
			head=head.next;
		}
	}
    public static ListNode reverseKGroup(ListNode head, int k) {
    	ListNode cur=head;
    	int count=0;
    	while(count<k && cur!= null){
    		cur=cur.next;
    		count++;
    	}
    	if(count <k){
    		return head;
    	}
    	System.out.println(cur.val);
    		ListNode nextpart=cur;
    		ListNode prev=null;
    		ListNode run=head;
    		while(run != nextpart){
    			ListNode next=run.next;
    			run.next =prev;
    			prev=run;
    			run=next;
    		}
    		head.next=reverseKGroup(nextpart,k);
    		return prev;
    	
    }
}
