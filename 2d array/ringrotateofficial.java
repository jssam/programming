import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);
      int nr = scn.nextInt();
      int nc = scn.nextInt();
      int mat[][] =new int[nr][nc];
      for(int i =0;i<nr;i++){
        for(int j = 0;j<nc;j++){
            mat[i][j] = scn.nextInt();
        }
      }
     int n = scn.nextInt();
     int rem = scn.nextInt();
     int maxr =nr - n;
     int minr =n-1;
     int maxc = nc - n;
     int minc = n-1;
     int length = 2*(maxr-(2*(n-1)))+2*(maxc-(2*(n-1))-2);
     int [] arr= new int [length];
     int m = 0;
     ///leftside
     for(int i = minr,j = minc ;i<= maxr;i++){
        arr[m] = mat[i][j];
        m++;
        }
     ////bottom
     for(int j = minc+1,i = maxr;j < =maxc;j++){
        arr[m] = mat[i][j];
        m++;
      }
     ////right
     for(int i= maxr-1,j = maxc;i < =minr ; i-- ){
        arr[m] = mat[i][j];
        m++;
      }
     ///top
     for(int j= maxc-1,i=minc;j<=minc;j--){
        arr[m] = mat[i][j];
        m++;
    }
     for(int i = 0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}