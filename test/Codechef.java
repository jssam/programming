import java.util.*;
// import java.Math.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		Scanner scn  = new Scanner(System.in);
		int n = scn.nextInt();
		int [][]arr = new int [1000][1000];
		arrmaker(arr);
		for(int x = 0;x<n;x++){
		    int x1 = scn.nextInt()-1;
		    int y1 = scn.nextInt()-1;
		    int x2= scn.nextInt()-1;
		    int y2 = scn.nextInt()-1;
			long sum = 0;
// System.out.println(arr[x1][y1]);
// System.out.println(arr[x2][y2]);
for(int i = x1;i<=x2;i++){
// System.out.println(arr[i][y1]);

	sum+=arr[i][y1];
}
for(int i = y1+1;i<=y2;i++){
// System.out.println(arr[x2][i]);

	sum+=arr[x2][i];
}
				
			// while(x1<=x2){
			// 	if(x1<=x2){
			// 		if(x1<x2){
			// 			sum += arr[x1][y1];
			// 			x1++;
			// 		}else{
			// 			sum += arr[x1][y1];
			// 			break;
			// 		}
			// 	}
			// }
			// while(y1<=y2){
			// 	if(y1<=y2){
			// 		if(y1<y2){
			// 			sum += arr[x1][y1];
			// 			y1++;
			// 		}else{
			// 			sum += arr[x1][y1];
			// 			break;
			// 		}
			// 	}
			// }

System.out.println(sum);

		//     int d = scn.nextInt();
		//     int arr[] = new int[11];
		// 	long sum = 0;
		//     for(int i = 10;i>0;i--){
		// 		arr[i] = scn.nextInt();
		// 		if(i>=G){
		// 			sum +=arr[i];
		// 		}
		// 	}
		// 	long tukka = sum - arr[G];
		// 	long chefday = (long)Math.floor(tukka/ d)+1l;
		// 	long carr =   (tukka%d);

		// 	System.out.print(chefday+" ");
		// 	 chefday = (long)Math.floor(sum / d);

		//  carr =   (sum%d);
		//  if(sum<d){
		// 	 carr = 1;
		//  }
		// 	System.out.println(chefday+carr);





		//     String s = scn.next();
        //     StringBuilder sb = new StringBuilder();
        //     sb.append(s);
		//     for(int i = sb.length()-1;i>=0;i--){
		//         if(sb.charAt(i)=='0'){
        //             l--;
		//             sb.deleteCharAt(i);
		//         }else{break;}
		//     }
		//     int zeros = 0;
		//     int one = 0;
		//     for(int i =0;i<sb.length();i++){
		//         if(sb.charAt(i)=='0'){
                    
		//             zeros++;
		//         }else{one++;}
		//     }   
		//     if(one==0){
		//         System.out.println("NO");
		//     }else if(one-zeros>=0){
		//        System.out.println("YES"); 
		//     }
		//     else{System.out.println("NO");}
		// }
	}
}
public static void arrmaker(int [][]arr){
	int sum = 1;
	for(int i = 0;i<arr.length;i++){
		int j = 0 ; 
		int n = i;
		while(n>=0&&j<=i){
			arr[j][n] = sum;
			sum++;
			n--;
			j++;
		}
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

