package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_32 {
    public int longestValidParentheses(String s) {
        // 如果使用动态规划 要求
        // dp[i-dp[i-1]-1] = "("
        // 转移方程 dp[i] = dp[i-1] + dp[i-dp[i-1]-1] + 2
        // 看视频讲解
        // https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/

        /* 栈方法
        对于遇到的每个 \text{‘(’}‘(’ ，我们将它的下标放入栈中
        对于遇到的每个 \text{‘)’}‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
        如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
        如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
         */

        int maxLen = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.addFirst(i);
            }else{
                stack.removeFirst();
                // 代表没有和他匹配的左括号, 把当前位置压进去，让后面的匹配上的长度减去他
                if(stack.isEmpty()) {
                    stack.addFirst(i);
                }else{
                    maxLen = Math.max(maxLen, i-stack.getFirst());
                }
            }
        }
        return maxLen;
    }
}
