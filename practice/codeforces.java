import java.util.Scanner;

public class codeforces {
  public static void main(String[] args) {
			Scanner fr = new Scanner(System.in);
            int t= fr.nextInt();
        
            while(t-->0){
                int a= fr.nextInt();
                int b= fr.nextInt();
                char[][]arr = new char[a][b];
                int k = 0;
                char check = ' ';
            for(int i = 0;i<arr.length;i++){
               
                String str= fr.next();
                fr.nextLine();
            
                for(int j = 0;j<b;j++){
                    arr[i][j] =str.charAt(j);
                    if((arr[i][j]=='R'||arr[i][j]=='W')&&k==0){
                        k = j;
                        check = arr[j][j];
                    }
                }
            }
            
            if(k%2==0){
                for(int j = 0;j<arr[0].length;j++){
                    if(arr[0][j]=='.'){
                    arr[0][j] = check;}
                    else{
                        if(arr[0][j]!=check){
                        
                        }
                    }
                }
            }
                
                
                
    
    
                }
              
            }
        // long endtime = System.currentTimeMillis();
        // System.out.println(endtime-starttime);
    }