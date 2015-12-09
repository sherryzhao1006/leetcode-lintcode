
/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
 */
public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	if(headA == null || headB == null){
    		return null;
    	}
    	ListNode p1=headA,p2=headB;
    	while(headA != null && headB != null && headA != headB){
    		headA=headA.next;
    		headB=headB.next;
            if(headA == headB){
    			return headA;
    		}
    		if(headA == null){
    			headA=p2;
    		}
    		if(headB == null){
    			headB=p1;
    		}
    	}
    	return headA;
    }
}
