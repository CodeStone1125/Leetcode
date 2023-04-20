/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int sum = 0;
        int prod = 0;
        while((l1!=null)&&(l2!=null)){
            sum = (l1.val+l2.val+prod) % 10;
            tail.next = new ListNode(sum);
            prod = (l1.val+l2.val+prod) / 10;
            l1=l1.next;
            l2=l2.next;
            tail=tail.next;
        }
        
        if(l1!=null){
            while(l1!=null){
                tail.next = new ListNode(((l1.val+prod)%10));
                prod=((l1.val+prod) / 10);
                l1=l1.next;
                tail=tail.next;
            }
        }
        else if(l2!=null){
            while(l2!=null){
                tail.next = new ListNode(((l2.val+prod)%10));
                prod=((l2.val+prod) / 10);
                l2=l2.next;
                tail=tail.next;
            }
        }
        while(prod!=0){
                tail.next = new ListNode(prod%10);
                prod= prod / 10;
                tail=tail.next;
        }
        return dummy.next;
    }
    

}