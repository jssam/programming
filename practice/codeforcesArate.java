import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class codeforcesArate {
    public static int lowerbound(int arr[], int N, int X) {
        int mid;

        int low = 0;
        int high = N;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (X <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low < N && arr[low] < X) {
            low++;
        }
        return low;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    static public void main(String[] args) {

        FastReader fr = new FastReader();
        //ques 5
        // int row = 0,col = 0;
        // for(int i = 0;i<5;i++){
        //     for(int j = 0;j<5;j++){
        //         int a = fr.nextInt();
        //         if(a==1){
        //             row = i+1;
        //             col = j+1;
        //         }
        //     }
        // }
        // System.out.println(Math.abs(row-3)+Math.abs(col-3));
        
        //ques. A. Helpful Maths
        // String st = fr.nextLine();
//         int ones = 0;
//         int twos =0;
//         int three = 0;
//         for(int i = 0;i<st.length();i++){
//         if(st.charAt(i)=='1'){
// ones++;
//         }else if(st.charAt(i)=='2'){
// twos++;
//         }
//         else if(st.charAt(i)=='3'){
//             three++;
//         }
//         }
//         String s = "";
//         for(int i = 0;i<st.length()-(st.length()/2);i++){
//             if(ones!=0){
//                 s  = s+"1";
//                 ones--;
//             }else if(twos!=0){
//                 s = s+"2";
//                 twos--;
//             }else if(three!=0){
//                 s = s+"3";
//                 three--;
//             }
//             if(i!=st.length()-(st.length()/2)-1){
//                 s = s+"+";
//             }
//         }
//         System.out.println(s); 
///ques.A. Word Capitalization
        String st = fr.nextLine();
        char a = st.charAt(0);
        if(a-'a'>=0){
            a = (char)(a-'a'+'A');
        }
        System.out.println(a+st.substring(1));

        // int t = fr.nextInt();
        // while (t-- > 0) {

        // }
    }
}