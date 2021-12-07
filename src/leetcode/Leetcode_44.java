package leetcode;

public class Leetcode_44 {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        // 如果为*就为true
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(p.charAt(j-1)=='?'){
                    if(dp[i-1][j-1]==true) dp[i][j] = true;
                    // 当为*的时候 如果*代表为空 则dp[i][j]=dp[i][j-1], 如果*不为空字符串 则dp[i][j] = dp[i-1][j]
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if(p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
