class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<matrix[0].length;i++){//left col
            int[] sum = new int[matrix.length];
            for(int m = i; m<matrix[0].length;m++){//right col
                for(int j = 0; j<matrix.length;j++){
                    sum[j]+=matrix[j][m];//add from left to right
                    if(sum[j]==k)return  k;  
                    if(sum[j]<k)maxSum=Math.max(maxSum,sum[j]);
                }
                for(int j = 0; j<matrix.length;j++){//up row
                    int summe=0;    
                    for(int n = j; n<matrix.length;n++){// down row
                        summe+=sum[n];//add from  up to down
                        if(summe==k)return k;
                        if(summe<k)maxSum=Math.max(maxSum,summe);
                    }
                }
            }
        }
        
        return maxSum;
 
    }
}