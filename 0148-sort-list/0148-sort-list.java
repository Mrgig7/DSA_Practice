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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode mid=helper(head);
        ListNode l = head;
        ListNode r = mid.next;
        mid.next=null;
        l=sortList(l);
        r=sortList(r);
        return res(l,r); 
    }

    private ListNode helper(ListNode head){
       
        ListNode s = head;
        ListNode f = head;
        ListNode p = head;

        while(f!=null && f.next!=null){
            p = s;
            s = s.next;
            f = f.next.next;
        }
        return p;
    }
    
    private ListNode res(ListNode l1, ListNode l2){
        ListNode dum = new ListNode(0);
        ListNode cur = dum;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null)cur.next=l1;
        else cur.next = l2;

        return dum.next;
    }

}