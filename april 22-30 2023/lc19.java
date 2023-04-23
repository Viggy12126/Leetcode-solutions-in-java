public class lc19 {
    public int length(ListNode head){

        int len=0;

        while(head!=null){
            head=head.next;
            len++;
        }

        return len;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp=head;
        int len=length(head);
        // System.out.println("len is "+" "+len);
       
       if(len-n==0)
       return head.next;

       int i=0;
       while(i<len-n-1){
           temp=temp.next;
           i++;
       }
// System.out.println(temp.val);
       temp.next=temp.next.next;

       return head;

    }
}
