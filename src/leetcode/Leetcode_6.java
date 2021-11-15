package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_6 {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        // 每个StringBuilder相当于每一行的字符串
        List<StringBuilder> lists = new ArrayList<StringBuilder>();
        for (int i=0; i<numRows;i++){
            lists.add(new StringBuilder());
        }

        int i = 0;
        int flag = -1;
        // flag为1代表往下加，flag为-1代表往上减，flag决定z字形的方向，当i的值即当前行数处于0或者最后一行时 改变方向
        for(char c : s.toCharArray()){
            if(i==0||i==numRows-1) flag = -flag;
            lists.get(i).append(c);
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : lists){
            res.append(sb.toString());
        }
        return res.toString();
    }
}
