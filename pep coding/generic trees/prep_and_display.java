import java.util.ArrayDeque;
import java.util.ArrayList;
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
