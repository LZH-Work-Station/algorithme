package leetcode;

public class Leetcode_5 {
    public String longestPalindrome(String s) {
        // dp[i][j]代表 从第i位到第j位是不是回文字符串
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        int maxLen = 0;
        int start = 0;
        int end = 0;

        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){
            // 对角线都是正确的 都是回文字符串
            dp[i][i] = true;
        }
        // 一定要先遍历开头 因为[0, 5]是依赖[1, 4]的 如果遍历开头 我们会先求[1,4]
        // i 是 结尾，结尾从1开始 开头j从0开始，因为结尾从0开始只有(0, 0)是正确的
        for(int i=1;i<chars.length;i++){
            for(int j=0;j<i;j++){
                // 如果i ,j相邻 则比较他俩相不相等
                if(i-j+1 == 2) dp[i][j] = chars[i] == chars[j];
                // 如果不相邻 他俩相等且[i-1][j+1]为true才能算回文字符串
                else if(chars[i] == chars[j] && dp[i-1][j+1]) dp[i][j] = dp[i-1][j+1];
                if(dp[i][j] && i-j+1 > maxLen){
                    maxLen = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
