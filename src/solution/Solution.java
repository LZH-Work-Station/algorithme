package solution;

import leetcode.Leetcode_30;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Leetcode_30 leetcode_30 = new Leetcode_30();
        List<Integer> babad = leetcode_30.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(babad);
    }
}
