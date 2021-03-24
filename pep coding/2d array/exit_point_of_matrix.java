import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for(int k = 0 ; k < nr ; k++){
            for(int l= 0 ; l<nc;l++){
                mat[k][l] = scn.nextInt();
            }
        }
        int i = 0;
        int j = 0;
        int dir = 1;
      
            while((i>=0&&i<nr)&&(j>=0&&j<nc)){
            if(mat[i][j]==0){
                if(dir%4==1){
                    j++;
                }else if(dir%4==2){
                    i++;
                }else if(dir%4==3){
                    j--;
                }else if(dir%4==0){
                    i--;
                }
            }else if(mat[i][j]==1){
                dir++;
                if(dir%4==1){
                    j++;
                }else if(dir%4==2){
                    i++;
                }else if(dir%4==3){
                    j--;
                }else if(dir%4==0){
                    i--;
                }
            }
            if (i<0){
                i++;
                break;
            }else if(j<0){
                j++;
                break;
            }else if(i>nr-1){
                i--;
                break;
            }else if(j>nc-1){
                j--;
                break;
            }
            
        }
    System.out.println(i);
    System.out.println(j);
        
    }

}