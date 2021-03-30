
class Solution{
    Node divide(int N, Node head){
        Node even = new Node(0);
        Node  tempev = even;
        Node odd = new Node(0);
        Node tempod = odd;
        for(int i =0;i<N;i++){
            Node temp = new Node(head.data);
            head= head.next;
            if(temp.data %2==0){
                even.next  = temp;
                
                even = even.next;
            }else{
                odd.next  = temp;
                odd = odd.next;
            }
        }
        even.next = tempod.next;
        tempod.next = null;
        Node list = tempev.next;
        tempev.next = null;
        return list;
        
    }
}