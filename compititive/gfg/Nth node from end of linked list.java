package gfg;

class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {   
        Node temp = head;
        Node temp1 = head;
        while(n>0){
            if(temp1 ==null){
                return -1;
            }
            temp1 = temp1.next;
            n--;
        }
        while(temp1!=null){
             temp1 = temp1.next;
              temp=  temp.next;
        }
        return temp.data;
        
    }
}
