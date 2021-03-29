

import java.util.*;
import java.lang.*;
import java.io.*;

class nobel
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int testcase = scn.nextInt();
		for(int t =0;t<testcase;t++){
		    int scol = scn.nextInt();
		    int sub = scn.nextInt();
		    int arr[] = new int [scol];
		    for(int j = 0;j<scol;j++){
		        arr[j] = scn.nextInt();
		    }
		    while(sub>0){
		        boolean val = false;
		        for(int i =0;i<arr.length;i++){
		            if(sub==arr[i]){
		                val=true;
		                sub--;
		                break;
		            }
		        }
		        if(val==false){
		            System.out.println("Yes");
		            break;
		        }
		        
		    }
		    if(sub==0){
		        System.out.println("No");
		    }
		}
	}
}
