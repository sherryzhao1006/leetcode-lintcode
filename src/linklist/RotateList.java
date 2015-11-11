package linklist;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head=rotateRight(head,1);
		while(head != null){
			System.out.print(head.val);
			head=head.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len=getLength(head);
        k=k%len;
        System.out.println(len+" "+k);
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k;++i){
        	System.out.println(fast.val);
            fast=fast.next;
        }
        if(fast == null) return head;
        while(fast.next != null){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next =head;
        fast=slow.next;
        slow.next=null;
        return fast;
    }
    public static int getLength(ListNode head){
        int len=0;
        while(head!= null){
            len++;
            head=head.next;
        }
        return len;
    }
}
