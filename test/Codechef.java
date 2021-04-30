
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		Scanner scn  = new Scanner(System.in);
		long n = scn.nextInt();
		for(int x = 0;x<n;x++){
		    int l = scn.nextInt();
		    String s = scn.next();
            StringBuilder sb = new StringBuilder();
            sb.append(s);
		    for(int i = sb.length()-1;i>=0;i--){
		        if(sb.charAt(i)=='0'){
                    l--;
		            sb.deleteCharAt(i);
		        }else{break;}
		    }
		    int zeros = 0;
		    int one = 0;
		    for(int i =0;i<sb.length();i++){
		        if(sb.charAt(i)=='0'){
                    
		            zeros++;
		        }else{one++;}
		    }   
		    if(one==0){
		        System.out.println("NO");
		    }else if(one-zeros>=0){
		       System.out.println("YES"); 
		    }
		    else{System.out.println("NO");}
		}
	}
}


/* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
// 	public static void main (String[] args)
// 	{
// 		Scanner scn  = new Scanner(System.in);
// 		long n = scn.nextInt();
// 		for(int x = 0;x<n;x++){
// 		    int l = scn.nextInt();
// 		    int s = scn.nextInt();
// 		    int a = scn.nextInt();
// 		    for(int i =0;i<l;i++){
// 		        String hell = scn.next();
// 		        char r = hell.charAt(0);
// 		        if(r=='E'||r=='Q'||r=='U'||r=='I'||r=='N'||r=='O'||r=='X'){
// 		            s++;
// 		        }else{a++;}
// 		    }
//             System.out.println(a);
//             System.out.println(s);
// 		    if(a==s){
// 		         System.out.println("DRAW");
// 		    }else if(a>s){
// 		         System.out.println("ANURADHA");
// 		    }else if(s>a){
// 		         System.out.println("SARTHAK");
// 		    }
		    
// 		}
// 	}
// }

