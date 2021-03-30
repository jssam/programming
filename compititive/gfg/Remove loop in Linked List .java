////tortoise and hase algorithm

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
      Node fast = head;
      Node slow = head;
      while(fast!=null && fast.next!= null){
          fast = fast.next.next;
          slow = slow.next;
          if(fast==slow){
              break;
          }
      }
      if(fast == null|| fast.next==null){
          return;
      }
      fast = head;
      if (slow == fast){
Node temp = slow.next;
while(temp.next!=slow){
    temp = temp.next;
}
temp.next = null;
return;
      }
      while(fast != slow){
          if(fast.next == slow.next){
              slow.next = null;
              break;
          }
          fast = fast.next;
          slow = slow.next;
      }
    }
}