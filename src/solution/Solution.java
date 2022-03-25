package solution;

import leetcode.Debug;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] t = new int[]{73,74,75,71,69,72,76,73};
        Debug debug = new Debug();

        System.out.println(Arrays.toString(debug.dailyTemperatures(t)));
    }
}
