import java.util.*;

public class binarytree {

    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    } 
    public static  class Pair{
        Node node;
        int state;
        Pair(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer input[]){
        ////////////ek stack prepare karenge jisme hm node and state dalwayenge
            Stack<Pair> st= new Stack<>();
            Node root = new Node(input[0]);
            st.push(new Pair(root,1)); 
            int idx =1;
            while(st.size()>0){
                Pair top= st.peek();
                if(top.state==1){
                Integer val = input[idx++];
                if(val == null){
                    top.state++;
                }else{
                    Node newNode = new Node(val);
                    top.node.left = newNode;
                    top.state++;
                    st.push(new Pair(newNode,1));
                }

                }else if(top.state==2){
                    Integer val = input[idx++];
                if(val == null){
                    top.state++;
                }else{
                    Node newNode = new Node(val);
                    top.node.right = newNode;
                    top.state++;
                    st.push(new Pair(newNode,1));
                }


                }else{
                    st.pop();
                }
            }
            return root;
        }



        public static void display(Node node) {
            if (node == null) {
              return;
            }
        
            String str = "";
            str += node.left == null ? "." : node.left.data + "";
            str += " <- " + node.data + " -> ";
            str += node.right == null ? "." : node.right.data + "";
            System.out.println(str);
        
            display(node.left);
            display(node.right);
          }

          public static int size(Node node) {
              if(node ==null){
                  return 0;
              }
            int le = size(node.left);
            int ri = size(node.right);
            return ri+le+1;
          }
        
          public static int sum(Node node) {
              if(node==null){
                  return 0;
              }
            int mxle = sum(node.left);
            int mxri = sum(node.right);
            return mxle+mxri+node.data;
          }
        
          public static int max(Node node) {
            if(node == null){
                return 0;
            }
                int le = max(node.left);
            int ri = max(node.right);
            return Math.max(Math.max(le,ri),node.data);
          }
        
          public static int height(Node node) {
              if(node == null){
                return -1;
            }
            int le = height(node.left);
            int ri = height(node.right);
            return Math.max(le,ri)+1;
          }

        ///////// level order ////
          public static void levelOrder(Node node) {
            Queue<Node> main = new ArrayDeque<>();
            Queue <Node> helper = new ArrayDeque<>();
            main.add(node);
            while(main.size()>0){
                ///remove
                Node t = main.remove();
                ////print 
                System.out.print(t.data+" ");
                ///add
                if(t.left!=null){
                    helper.add(t.left);
                }
                 if(t.right!=null){
                    helper.add(t.right);
                }
                if(main.size()==0){
                
                
                    System.out.println();
                    Queue<Node> temp = main;
                    main = helper;
                    helper = temp;
                }
            }
          }


    public  static void main(String args[]){
        Integer input[] = {10,20,40,null,null,50,80,null,null,null,30,60,null,90,null,null,70,null,null};
        Node root = construct(input);
        display(root);
    }
}
