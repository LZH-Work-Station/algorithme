package leetcode;

public class Leetcode_38 {
    public String countAndSay(int n) {
        // 添加初始值
        String s = "1";

        for(int i=2;i<n;i++){
            StringBuilder sb = new StringBuilder();
            // start代表某个数字的起始位置
            int start = 0;
            // pos递增为了找到数字不再重复的位置
            int pos = 0;
            while(pos<sb.length()){
                if(s.charAt(pos)==s.charAt(start)){
                    pos ++;
                }
                // pos - start就是数字的重复次数
                sb.append(String.valueOf(pos-start)+s.charAt(pos));
                start = pos;
            }
            s = sb.toString();
        }
        return s;
    }
}
