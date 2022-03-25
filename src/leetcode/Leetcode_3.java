package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_3 {
    public int lengthOfLongestSubstring(String s) {
        // 以每个字符开头 建立一个新的HashSet，然后不断添加 直到发现重复字符 找到以该字符开头的最大子字符串
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            int j = i;
            while(j<s.length()&&!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            max = Math.max(max, set.size());
            set.clear();
        }
        return max;
    }
}
