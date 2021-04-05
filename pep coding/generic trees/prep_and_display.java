import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
public class prep_and_display {
    public static class Node{
        int Data;
        ArrayList <Node> children;
        Node(){
            children = new ArrayList<>();
        }
        Node(int data){
            this();
            this.Data = data;
        }
    }
    public static Node consturct(Integer input[]){
        Node root = new Node(input[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);
        for(int i = 1;i<input.length;i++){
            Integer val = input[i];
            if (val==null){
                st.pop();
            }else{
                Node n1 = new Node(val);
                st.peek().children.add(n1);
                st.push(n1);
            }
        }
        return root;
    }
    /////display
    public static void display(Node root){
        System.out.print(root.Data +"- >");
        for(Node child:root.children){
            System.out.print(child.Data +" ");
        }
        System.out.println(".");
        for(Node child:root.children){
            display(child);
        }
    }
    /////size of generic tree
    public static int size(Node node){
        int res = 0;
        for(Node child:node.children){
            res += size(child);
        }
        res ++;
return res;
    }
    ////max of generic tree
    public static int max(Node node) {
        int res = Integer.MIN_VALUE;
        for( Node child:node.children){
            res = Math.max(res,max(child));
        }
        return Math.max(res,node.Data);
      }
      /////maximum height of the generic tree deepest node se yha tak
      public static int height(Node node) {
        int h = -1;
        for(Node child : node.children){
            int res = height(child);
            if(res>h){
                h= res;
            }
        }
        return h+1;
      }
      ////////////the level print of the generic treee
      public static void levelprint(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            Node tmp =  q.remove();
            System.out.print(tmp.Data+" ");
            for(Node child : tmp.children){
                q.add(child);
            }
        }
        System.out.println(".");
      }
      /////////remoce cell nodes/////////////
      public static void removeLeaves(Node node){
          //////array list me ulta triverse karte hai taki hmara index na chla jaye kyoki agar age se karenge to peche ka sara content ek ek pehe shift ho jayega //
        for(int i = node.children.size()-1;i>=0;i--){
            Node child = node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(i);
            }
        }
        ///////fir oske har ek children par check karke ayenge////
        for(Node child : node.children){
            removeLeaves(child);
        }
      }
      ////////////mirror the tree///////////
      public static void mirror(Node node){
          //////////jo bhi children ki child ki jo arraylist hai ose reverse karo//////////////////
        Collections.reverse(node.children);
        /////////har ek child ko ja ke reverse kar do;
        for(Node child:node.children){
            mirror(child);
        }
      }
      //////////////Are Trees Similar In Shape///////////////////
      public static boolean areSimilar(Node n1, Node n2) {
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        ////data compare nahi karna 
        // for(int idx = 0;idx<n1.children.size();i++){
        //     if(n1.children.get(idx)!=n2.children.get(idx)){
        //         return false;
        //     }
        // }
        boolean a ;
        int i =n1.children.size()-1;
        while(i>=0){
            Node child1 = n1.children.get(i);
             Node child2 = n2.children.get(i);
             a = areSimilar(child1, child2);
           if(a==false){
               return false;
           }
           i--;
        }
        return true;
      }

      ////////////is two trees are mirror of each other////////////
      public static boolean areMirror(Node n1, Node n2) {
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        int i = n1.children.size()-1;
        
        while(i>=0){
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(n1.children.size()-1-i);
            if(areMirror(child1,child2)==false){
                return false;
            }
            i--;
        }
        return true;
      }
      /////////////////// is symmetric ke liye vo khud ka hi mirror image hona chaie
  public static boolean IsSymmetric(Node node) {
    return areMirror(node,node);
}
///////////////// Ceil And Floor In Generic Tree //////////////////
static int ceil = Integer.MAX_VALUE;
static int floor = Integer.MIN_VALUE;
public static void ceilAndFloor(Node node, int data) {
    ///know category
   /////for min category
    if(node.Data<data){
        ////agar floor ki value se bda hai
        if(node.Data>floor){
            floor = node.Data;
        }
    }
    ////for max category
    if(node.Data>data){
        ///////////agar ceil bada hai node data se
        if(node.Data<ceil){
            ceil = node.Data;
        }
    }
    
  for(Node child: node.children){
      ceilAndFloor(child,data);
  }
}
      ////////////zones /////////////////
      public static void zones(Node node){
          System.out.println("Node pre area "+node.Data);
          for(Node child:node.children){
              System.out.println("CHild pre area "+ child.Data);
                zones(child);
              System.out.println("CHild post area "+ child.Data);

          }
          System.out.println("Node post area "+ node.Data);

      }
    public static void main(String[] args) {
        Integer input[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};
        Node root = consturct(input);
        display(root);
        int s = size(root);
        System.out.println(s);
        int max = max(root);
        System.out.println(max);
        int hei = height(root);
        System.out.println(hei);
        levelprint(root);
        zones(root);
    }
}
