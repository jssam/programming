import java.util.Scanner;
 
public class walmart{
     public static void main(String[] args) {
          Scanner scn = new Scanner(System.in);
               int n =scn.nextInt();
               int game[] = new int[n];
               for(int i = 0; i < n; i++){
                    game[i] = scn.nextInt();
               }
               int answer = -1;
               for(int j = 30; j >= 0; j--){
                    int count = 0;
                    for(int i  = 0; i < n; i++){
                         if((game[i] & (1 << j)) > 0)
                              count += 1;
                    }
                    if(count % 2 == 0){
                         continue;
                    }
                    int z = (n - count) % 2;
                    count = (count + 1) / 2;
                    if(count % 2 == 0 && z % 2 == 1){
                         answer = 1;
                         break;
                    }
                    else if(count % 2 == 1){
                         answer = 1;
                         break;
                    }
                    answer = 0;
                    break;
               }
               System.out.println(answer);
          }
}
