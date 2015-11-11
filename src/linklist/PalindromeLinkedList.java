package linklist;
/*
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null){
    		return true;
    	}
    	ListNode mid=findMid(head);
    	ListNode part=mid.next;
    	mid.next=null;
    	part=reverse(part);
    	while(head != null && part != null){
    		if(head.val != part.val){
    			return false;
    		}
    		head=head.next;
    		part=part.next;
    	}
    	return true;
    }
    public ListNode findMid(ListNode head){
    	ListNode slow=head,fast=head.next;
    	while(fast.next != null && fast.next.next != null){
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	return slow;
    }
    public ListNode reverse(ListNode part){
    	ListNode pre=null;
    	while(part != null){
    		ListNode next=part.next;
    		part.next=pre;
    		pre=part;
    		part=next;
    	}
    	return pre;
    }

}
