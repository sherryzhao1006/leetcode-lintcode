package linklist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=new ListNode(0);
		ListNode l2=new ListNode(0);
		addTwoNumbers(l1,l2);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode dummy=new ListNode(0);
        ListNode run=dummy;
        int carry=0;
        while(l1 != null || l2 != null || carry == 1){
            int sum=(l1 != null?l1.val:0)+(l2 != null?l2.val:0)+carry;
            run.next=new ListNode(sum%10);
            carry=sum/10;
            run=run.next;
            System.out.print(l1.val+" "+l2.val+" "+run.val);
            l1=(l1 == null?null:l1.next);
            l2=(l2 == null? null:l2.next);
        }
        return dummy.next;
    }

}
