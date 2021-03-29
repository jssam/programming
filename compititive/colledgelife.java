
import java.util.*;
import java.lang.*;
import java.io.*;
class colledgelife
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner scn = new Scanner(System.in);
	 int T = scn.nextInt();
	 for(int t =0;t<T;t++){
	     int time1 = scn.nextInt();
	     int time2 = scn.nextInt();
	     int arr1[] = new int[time1];
	     int channel =1;
	     int count = 1;
	     int arr2[] = new int[time2];
	     for(int i = 0 ;i<arr1.length;i++){
	         arr1[i]= scn.nextInt();
	     }
	     for(int i = 0 ;i<arr2.length;i++){
	         arr2[i]= scn.nextInt();
	     }
	     int i =0;
	     int j =0;
	     while(i<arr1.length&&j<arr2.length){
	         if(channel==1){
	         if(arr1[i]<arr2[j]){
	             i++;
	         }else {
	             count++;
	             channel =2;
	             j++;
	         }
	             
	         }else if(channel==2){
	         if(arr2[j]<arr1[i]){
	             j++;
	         }else {
	             count++;
	             channel =1;
	             i++;
	         }
	             
	         }
	     }
	     
	     System.out.println(count);
	     
	     
	     
	 }
	}
}

