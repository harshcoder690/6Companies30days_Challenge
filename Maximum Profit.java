class Solution {
    static int maxProfit(int k, int N, int prices[]) {
        if(prices.length==0 || k==0){
            return 0;
        }
        int [][] dp = new int [k+1][prices.length];
        for(int i = 1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int max = Integer.MIN_VALUE;
                
                for(int a = j-1;a>=0;a--){
                    int c = dp[i-1][a]+(prices[j]-prices[a]);
                    max = Math.max(max,c);
                }
                
                dp[i][j] = Math.max(dp[i][j-1],max);
            }
        }
        return dp[k][prices.length-1];
    }
}