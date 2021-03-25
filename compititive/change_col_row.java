import java.util.Scanner;

public class change_col_row {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int times = scn.nextInt();
        for(int m = 0;m<times;m++){

            int i = scn.nextInt();
            int j = scn.nextInt();
            int n = scn.nextInt();
            int row;
            int col;
            if(n%i!=0){
                row = n%i;
                col = n/i +1;
            }else{
                row = i;
                col = n/i;
            }
            int num  = j-col;
            int x = (j*row)-num;
            System.out.println(x);
        }
    }
}
