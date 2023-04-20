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
    public void reorderList(ListNode head) {
        ListNode list1 = new ListNode();
        ListNode tail1 = list1;
        ListNode list2 = new ListNode();
        ListNode tail2 = list2;
        ListNode ans = new ListNode();
        ListNode tail = ans;
        ListNode temp = head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        for(int i=0;i<(length/2);i++){
            tail1.next=head;
            head=head.next;
            tail1=tail1.next;
        }
        tail1.next=null;
        list2.next=head;
        list1=list1.next;
        list2=list2.next;        
        list2 = reverseList(list2);
        printLinkedList(list1);
        printLinkedList(list2);
        while(list1!=null){
            tail.next=list1;
            list1=list1.next;
            tail=tail.next;
            if(list2==null){
                break;
            }
            tail.next = list2;
            list2 = list2.next;
            tail=tail.next;
        }
        
        head=ans.next;
        
        
    }
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = null;
        ListNode r = head;
        while (r != null) {
            p = q;
            q = r;
            r = r.next;
            q.next = p;
        }
        return q;
    }
    
    void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}