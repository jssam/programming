////ques 1 

import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        System.out.println("Node obj instantiated");
        this.data = data;
    }

    Node(int data , Node next){
        this(data);
        this.next = next;
    }
}
class LinkedList{
    private Node head , tail;
    private int size;

    LinkedList(){
        System.out.println("LinkedList obj instantiated");
        head = tail = null;
        size = 0;
    }

    public void addLast(int val){
        Node temp = new Node(val,null);
        tail.next = temp;
        tail = temp;
        size++;
    }

    public void addFirst(int val){
        if(size==0){
              Node temp = new Node(val,head);
        head =tail = temp;
        size++;
            return;
         
        }
        Node temp = new Node(val,head);
        head = temp;
        size++;
    }

    public void addAt(int idx,int val){
        Node temp = new Node(val,null);
        Node node = head;
        int i = 0;
        while(i<idx||node!=null){
            node = node.next;
            i++;
        }
        Node a = node.next;
        node.next = temp;
        temp.next = a;
        size++;
        
    }

    public void removeFirst(){
         if(size==0){
       System.out.println("List is empty");
            return ;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    public void removeLast(){
        if(size==0){
       System.out.println("List is empty");
            return ;
        }
        if(size==1){
            head= tail = null;
            size--;
            return;
        }
        Node node = head;
        while(node.next!=tail){
            node = node.next;
        }
        node.next = null;
        tail = node;
        size--;
    }

    public void removeAt(int idx){
        if(size==0){
            System.out.println("List is empty");
            return ;
        }
        if(size-idx-1<0){
            System.out.println("Invalid args");
            return ;
        }
        Node node = head;
        int i = 0;
        while(i<idx||node!=null){
            node = node.next;
            i++;
        }
        Node a = node.next.next;
        node.next.next = null;
        node.next = a;
        size--;
    }

    public void display(){
    
        Node a = head;
        while(a != null){
            System.out.print(a.data+" -> ");
            a = a.next;
        }
        System.out.print(".");
        System.out.println();
    }

    public int size(){
        return size;
    }

    public int getFirst(){
        if(size==0){
            System.out.println("List is empty");
            return -1;       
        }
        return head.data;
    }

    public int getLast(){
        if(size()==0){
            System.out.println("List is empty");
            return -1;  
        }
       return tail.data;
    }

    public int getAt(int idx){
        if(size==0){
            System.out.println("List is empty");
            return -1;
        }
        if(size-idx-1<0){
            System.out.println("Invalid args");
            return -1;
        }
        Node node = head;
        int i = 0;
        while(i<idx||node!=null){
            node = node.next;
            i++;
        }
        return node.next.data;
    }

}

public class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        while(!str.equals("quit!")){
            String parts[] = str.split(" ");

            switch(parts[0]){
                case "addAt" : {
                    System.out.println("addAt cmd"+parts[1]+"-->"+parts[2]);
                    list.addAt(Integer.parseInt(parts[1]) , Integer.parseInt(parts[2]));
                }break;
                case "addFirst" : {
                    System.out.println("addFirst cmd"+parts[1]);
                    list.addFirst(Integer.parseInt(parts[1]));
                }break;
                case "addLast" : {
                    System.out.println("addLast cmd"+parts[1]);
                    list.addLast(Integer.parseInt(parts[1]));
                }break;
                case "getFirst" : {
                    System.out.println("getFirst cmd");
                    System.out.println(list.getFirst());
                }break;
                case "getAt" : {
                    System.out.println("getAt cmd"+parts[1]);
                    System.out.println(list.getAt(Integer.parseInt(parts[1])));
                }break;
                case "getLast" : {
                    System.out.println("getLast cmd");
                    System.out.println(list.getLast());
                }break;
                case "removeFirst" : {
                    System.out.println("remove first");
                    System.out.println(list.getFirst());
                    list.removeFirst();
                }break;
                case "removeLast" : {
                    System.out.println("remove last");
                    System.out.println(list.getLast());
                    list.removeLast();
                }break;
                case "removeAt" : {
                    System.out.println("remove at" + parts[1]);
                    System.out.println(list.getAt(Integer.parseInt(parts[1])));
                    list.removeAt(Integer.parseInt(parts[1]));
                }break;
                case "size" : {
                    System.out.println("size : "+list.size());
                }break;
                case "display" : {
                    System.out.println("display : ");
                    list.display();
                }break;
            }
            str = scn.nextLine();
        }

    }
}

////ques 2 ////////////
import java.util.Scanner;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        // code
        int ans=infix_evaluation(exp);
        System.out.println(ans);
        infix_conversions(exp);
        
    }
    public static int infix_evaluation(String exp) {
        Stack<Character>oprtr = new Stack<>();
        Stack<Integer>oprnd = new Stack<>();
        
        for(int i=0;i < exp.length();i++) {
            char ch = exp.charAt(i);
            
            if(ch == '(') {
                oprtr.push(ch);
            }
            else if(ch >= '0' && ch <= '9') {
                oprnd.push(ch-'0');
            }
            else if(ch == ')') {
                //evaluate till '('
                while(oprtr.peek() != '(') {
                    char opr = oprtr.pop();
                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();
                    
                    int ans = operation(opr,v1,v2);
                    oprnd.push(ans);
                }
                oprtr.pop(); // pop out '('
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch =='/') {
                while(oprtr.size() > 0 && oprtr.peek() != '(' && precedence(ch) <= precedence(oprtr.peek())) {
                    char opr = oprtr.pop();
                    int v2 = oprnd.pop();
                    int v1 = oprnd.pop();
                    
                    int ans = operation(opr,v1,v2);
                    oprnd.push(ans);
                }
                oprtr.push(ch);
            }
            
        }
        
        while(oprtr.size() != 0) {
            char opr = oprtr.pop();
            int v2 = oprnd.pop();
            int v1 = oprnd.pop();
            
            int ans = operation(opr,v1,v2);
            oprnd.push(ans);
        }
        
        return oprnd.peek();
        
    }
    
    public static int operation(char opr,int v1,int v2) {
        if(opr == '+') {
            return v1+v2;
        }
        else if(opr == '/') {
            return v1/v2;
        }
        else if(opr == '*') {
            return v1*v2;
        }
        else if(opr == '-') {
            return v1-v2;
        }
        else {
            return 0;
        }
    }
    public static void infix_conversions(String infix) {
        Stack<Character>oprtr = new Stack<>();
        Stack<String>pre = new Stack<>();
        Stack<String>post = new Stack<>();
        
        for(int i=0; i < infix.length();i++) {
            char ch = infix.charAt(i);
            
            if(ch == '(') {
                oprtr.push(ch);
            }
            else if(ch == ')') {
                while(oprtr.peek() != '(') {
                    char opr = oprtr.pop();
                    
                    //create pre value
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preval = opr + preV1 + preV2;
                    
                    pre.push(preval);
                    
                    //create post value
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postval = postV1+postV2+opr;
                    
                    post.push(postval);
                }
                oprtr.pop();
            }
            else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                pre.push(ch + "");
                post.push(ch + "");
            }
            else if(ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                while(oprtr.size() > 0 && oprtr.peek() != '(' && precedence(ch) <= precedence(oprtr.peek())) {
                    char opr = oprtr.pop();
                    
                    //create pre value
                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preval = opr + preV1 + preV2;
                    
                    pre.push(preval);
                    
                    //create post value
                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postval = postV1+postV2+opr;
                    
                    post.push(postval);
                }
                oprtr.push(ch);
            }
        }
        
        while(oprtr.size() > 0) {
            char opr = oprtr.pop();
                    
            //create pre value
            String preV2 = pre.pop();
            String preV1 = pre.pop();
            String preval = opr + preV1 + preV2;
            
            pre.push(preval);
            
            //create post value
            String postV2 = post.pop();
            String postV1 = post.pop();
            String postval = postV1+postV2+opr;
            
            post.push(postval);
        }
        
        System.out.println(post.peek());
        System.out.println(pre.peek());
    }
    
    public static int precedence(char opr) {
        if(opr == '+' || opr == '-') {
            return 1;
        }
        else if(opr == '*' || opr == '/') {
            return 2;
        }
        else {
            return 0;
        }
    }
}

///////ques 3 
import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(maxarea(a));
    
 }
    public static int maxarea(int[]a){
        int[] nsl= nextSmallerLeft(a);
        int[] nsr= nextSmallerRight(a);
        
        
        for(int i=0;i<nsr.length;i++){
            System.out.print(nsr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<nsl.length;i++){
            System.out.print(nsl[i]+" ");
        }
        System.out.println();
        int max = 0;
        
        for(int i=0;i < a.length;i++) {
            int area = a[i] * (nsr[i] - nsl[i] - 1);
            
            if(area > max) {
                max = area;
            }
        }
        
        return max;
    }
    public static int[] nextSmallerLeft(int[]arr) {
        int n = arr.length;
        int[]nsl = new int[n];
        
        Stack<Integer>st = new Stack<>();
        
        nsl[0] = -1;
        st.push(0);
        
        for(int i=1; i < n;i++) {
            while(st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        
        return nsl;
    }
 
    public static int[] nextSmallerRight(int[]arr) {
        int n = arr.length;
        int[]nsr = new int[n];
        
        nsr[n-1] = n;
        Stack<Integer>st = new Stack<>();
        st.push(n-1);
        
        for(int i=n-2; i >= 0;i--) {
            while(st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                nsr[i] = n;
            }
            else {
                nsr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return nsr;
    }

}
//////ques 4 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int k=scn.nextInt();
        windowmax(arr,k);
    }
    public static void windowmax(int[]arr,int k) {
        int[]ngr = nextgreaterright(arr);
        int n=arr.length;
        
        for(int i=0; i <= n-k;i++) {
            int j = i;
            
            while(ngr[j] < i+k) {
                j = ngr[j];
            }
            
            System.out.println(arr[j]);
        }
    }
    public static int[] nextgreaterright(int[]arr) {
        int n=arr.length;
        int[]ngr = new int[n];
        
        Stack<Integer>st = new Stack<>();
        ngr[n-1]=n;
        st.push(n-1);
        
        for(int i=n-2;i >= 0;i--) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                ngr[i] = n;
            }
            else {
                ngr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return ngr;
    }
}
