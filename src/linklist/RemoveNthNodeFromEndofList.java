package linklist;
/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        while(n>0 && fast!= null){
            fast=fast.next;
            n--;
        }
        if(fast ==null){
            return head.next;
        }
        ListNode slow=head;
        while(fast.next != null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
