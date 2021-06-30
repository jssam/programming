*Ques.1*////Fibonacci-dp
public static int memoisation(int n,int []dp){
    if(n==1){
        return dp[1]=1;
    }
    if(n==2){
        return dp[2]=1;
    }
    if(dp[n]!=0){
        return dp[n];
    }
    int fibn1 = memoisation(n-1,dp);
    int fibn2 = memoisation(n-2,dp);
    int fibn = fibn1+fibn2;1
    return dp[n] = fibn
}

public static int tabulation(int n){
   int []dp = new int[n+1];
   for(int i = 1;i<dp.length;i++){
       if(i==1){
           dp[1] = 1;
       }else if(i==2){
           dp[2] = 1;
       }else{
           dp[i] = dp[i-1]+dp[i-2];
       }
       
   }
   return dp[n];
}


*Ques.2*////Climb Stairs
public static int memoisation(int n,int [] dp){
    if(n==0){
       return dp[n] = 1;
    }
    if(n==1){
        return dp[n] = memoisation(n-1, dp);
    } 
    if(n==2){
    return dp[n] = memoisation(n-1, dp)+memoisation(n-2, dp);
    }
    if(dp[n]!=0){
        return dp[n];
    }
 int a = memoisation(n-1, dp);
 int b = memoisation(n-2, dp);
 int c = memoisation(n-3, dp);
return dp[n] = a+b+c;
}
public static int tabulation(int n){
int dp[] = new int [n+1];
for(int i = 0;i<n+1;i++){
    if(i==0){
        dp[i] = 1;
    }else if(i==1){
        dp[i] = dp[i-1];
    }else if(i==2){
        dp[i] = dp[i-1]+dp[i-2];
    }else{
        dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    }
}
return dp[n];
}

*Ques.3* ///Climb Stairs With Variable Jumps

public static int tabulation(int [] moves){
    int n = moves.length;
    ////dp define kari
    int dp[] = new int [n+1];
    ////isme sabse assan rhega ki hm end se end par hi ho isliye ulta chlaya
    for(int i = n;i>=0;i--){
        if(i==n){
            //////agar vo phele hi n par hai to max way ek hi hai to hm dp[n] = 1 rakhwa denge
            dp[i] = 1;
        }else{
            if(moves[i]==0){
                ////agar moves hi zero hai to vo age move hi ni kar payega to vha hm 0 lga denge
                dp[i] = 0;
            }else{
                ////hm max moves nikal lenge
                int maxjump = moves[i];
                ////ab sare moves ki posiility check karke apne ans me add karenge
                for(int jump = 1;jump<=maxjump&&jump+i<=n;jump++){
                    //////dp[i] me hm add karte jaynege apne answer ko 
                    dp[i] = dp[i]+dp[i+jump];
                }
            }
        }
        
    }
    return dp[0];
}

*Ques.4* ///Climb Stairs With Minimum Moves
public static int  tabulation(int arr[]){
    int n = arr.length;
    int moves[] = new int[n+1];
    for(int i = n;i>=0;i--){
        if(i == n){
            moves[n] = 0;
        }
        else{
            ////////max moves nikal liye
            int maxmoves = arr[i];
            ////iske bad check kiya ki moves 0 hai ya nahi
                int minjump = Integer.MAX_VALUE;
                ///agar 0 hai to vha infinity dalwayenge taki minium na chage ho kyoki 0 dalenge to 0 hi a jayega
                for(int jump = 1;jump<=maxmoves&&jump+i<=n;jump++){
                    minjump = Math.min(minjump,moves[i+jump]);
                }
                if(minjump!=Integer.MAX_VALUE){
            minjump++;}moves[i] = minjump;
        }
    }
    return moves[0];
}

*Ques.5* ///Min Cost In Maze Traversal
public static int tabulation(int [][]arr){
    int n = arr.length;
    int m = arr[0].length;
    //create dp 
    int dp[][]  = new int[n][m];
    ///put last value as it si as vha pochna hai to vo minimum paise dene hi padenge 
         dp[n-1][m-1] = arr[n-1][m-1];
    for(int r = n-1 ;r>=0;r--){
        for(int c = m-1;c>=0;c--){
            ///last vali line se sirf phocha right ja ke hai to min iske liye alag kam karenge
            if(r==n-1&&c!=m-1){
           dp[r][c] = arr[r][c]+dp[r][c+1];
            }
            ///last vali row se sirf phocha down ja ke hai to min iske liye alag kam karenge
            else if(c==m-1&&r!=n-1){
                dp[r][c] = dp[r+1][c]+arr[r][c];
            }
            //right and down ka minimum dekh kar khud ki add kar denge
            else if(c!=m-1&&r!=n-1){
                dp[r][c] = arr[r][c] + Math.min(dp[r+1][c],dp[r][c+1]);
            }
        }
    }
    return dp[0][0];
}

*Ques.6* ///Target Sum Subsets - Dp

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0;i<n;i++){
        arr[i]= scn.nextInt();
    }
    int tar = scn.nextInt();
    boolean dp[][] = new boolean[n+1][tar+1];
    //ek extra ki dp bnayenge
    dp[0][0]  = true;
    ///0 coin se 0 bna sakte hai to true
    for(int i =1;i<n+1;i++){
        //coint nuikal lenge
        int coin  = arr[i-1];
        for(int j = 0;j<tar+1;j++){
            
            if(j==0){
                ///agar sum 0 hjai to bna add kare bna sakte hai isliye true
                dp[i][j] = true;
            }else{
                if(j>=coin){
                    
                    boolean  s = dp[i-1][j-coin];
                    boolean prev = dp[i-1][j];
                    dp[i][j] = (s||prev);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
    }
    System.out.println(dp[n][tar]);
    }
}

*Ques.7* ///Goldmine
public static int tabulation(int[][]arr){
    int n = arr.length;
    int m = arr[0].length;
    int dp[][] = new int [n][m];
    ///dekh neche se upar ki taraf ayenge gold collect karte hue means right se left ki taraf
    
    for(int c = m-1;c>=0;c--){
        for(int r = n-1;r>=0;r--){
            // to agar right most hai to vha jitna gold milega utna hi mialga
            if(c == m-1){
                dp[r][c] = arr[r][c];
            }else{
                //agar r ==0 to dekh max ya to samne se ayega ya neche se
                if(r==0){
                    dp[r][c] = arr[r][c]+Math.max(dp[r][c+1],dp[r+1][c+1]);
                }
                //r sabse last hai to max ya to samne se ayega ya upar se
                else if(r==n-1){
                      dp[r][c] = arr[r][c]+Math.max(dp[r][c+1],dp[r-1][c+1]);
                }
                //r agar beexh me hai to upar samne neche ka max hoga
                else{
                      dp[r][c] = arr[r][c]+Math.max(dp[r][c+1],Math.max(dp[r+1][c+1],dp[r-1][c+1]));
                }
            }
        }
    }
    int res = 0;
    for(int i = 0;i<=n-1;i++){
        res= Math.max(res,dp[i][0]);
    }
    return res;  
}

*Ques.8* ///Coin Change Combination
    
int dp[] = new int[tar+1];
dp[0] = 1;
for(int i = 0 ;i<n;i++){
    int coin = arr[i];
    for(int j = coin;j<tar+1;j++){
        int prev_value = dp[j-coin];
        dp[j] +=prev_value; 
    }
}
System.out.println(dp[tar]);

*Ques.9* ///Coin Change permutaion - isme arrangement bhi dekhenge like 2+3+2,2+2+3,3+2+2
int tar = scn.nextInt();
int dp[] = new int[tar+1];
dp[0] = 1;
//dekh code me bas itna faraq ayega hm har target ko har coin se bna ke dekhna chahenge 
//but upar valr me hm esa nahi kar rhe the hm usme har coin se ek bar har target achieve karne ki soch rhe the
for(int i =1;i<tar+1;i++){
    for(int j = 0;j<n;j++){
        int coin = arr[j];
        if(coin <=i){
            int prev_value = dp[i-coin];
            dp[i]+=prev_value;
        }
    }
}
System.out.println(dp[tar]);


*Ques.10* ///Zero One Knapsack
    
public static int zeroOneKnapsack(int wts[],int vls[],int cap){
    int n = wts.length;
    int dp[][] = new int[n+1][cap+1];
    for(int i = 1;i<=n;i++){
        for(int j = 1;j<=cap;j++){
            //check karenge capacity weight se choti hai ya nahi
            if(j>=wts[i-1]){
                int wt = dp[i-1][j];
                //agar hai to hm max rakhenge oske ane ke bad vrna oske ane se phele
                dp[i][j] = Math.max(wt,(vls[i-1]+dp[i-1][j-wts[i-1]]));
            }else{
                //agar capacity jayada hai o ose include kare bina bas upar vale ko include karke age chalenge
                dp[i][j] =  dp[i-1][j];
            }
        }
    }
    return dp[n][cap];
}


*Ques.11* ///Unbounded Knapsack

public static int zeroOneKnapsack(int wts[],int vls[],int cap){
    int n = wts.length;
    int dp[][] = new int[n+1][cap+1];
    for(int i = 1;i<=n;i++){
        for(int j = 1;j<=cap;j++){
            if(j-wts[i-1]>=0){
                int wt = dp[i-1][j];
                ////dekh ab hmare pas unlimited hai  to ab hm ose line me check karenge 
                dp[i][j] = Math.max(wt,(vls[i-1]+dp[i][j-wts[i-1]]));
            }else{
                dp[i][j] =  dp[i-1][j];
            }
        }
    }
    return dp[n][cap];
}

*Ques.12* ///Fractional Knapsack - Official
///greedy 
///dekh bhai hm ek ke liye nikal lenge and osko sort kar denge than vhi quantity se mltiply
public static double fracKnapsack(int []wts,int []vls,int cap){
    Pair greedy[] = new Pair[wts.length];
    for(int i = 0;i<vls.length;i++){
        Pair s =new Pair();
        s.wt = wts[i];
        s.vl = vls[i];
        s.ratio = (s.vl*1.0)/s.wt;
        greedy[i] = s;
    }
    Arrays.sort(greedy);
    int idx = 0;
    double ans = 0;
    while(cap>0&&idx<wts.length){
        if(greedy[idx].wt<=cap){
            ans+=greedy[idx].vl;
            cap = cap-greedy[idx].wt;
            idx++;
        }else{
            ans+= cap*greedy[idx].ratio;
            cap=0;
        }
    }
    return ans;
}


