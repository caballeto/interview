package interviewbit.LinkedLists;



public class _remove_dups {
 class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }

 public ListNode deleteDuplicates(ListNode node) {
   if (node == null) return null;
   ListNode temp = node;

   while (temp.next != null) {
     if (temp.val == temp.next.val) {
       temp.next = temp.next.next;
     } else {
       temp = temp.next;
     }
   }

   return node;
 }
}
