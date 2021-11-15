package leetcode;

public class Leetcode_8 {
    public int myAtoi(String s) {
        int res = 0;
        s = s.trim();
        if(s.length()==0) return 0;

        boolean negative = false;
        boolean sign = false;
        if(s.charAt(0)=='-'||s.charAt(0)=='+'){
            sign = true;
            if(s.charAt(0) == '-'){
                negative = true;
            }
        }

        for(int i=0; i<s.length(); i++){
            if(sign && i==0) continue;
            if(s.charAt(i)<'0'||s.charAt(i)>'9') break;
            else{
                if(!negative && (res > Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && (s.charAt(i)-'0') > Integer.MAX_VALUE % 10))) return Integer.MAX_VALUE;
                if(negative && (-res < Integer.MIN_VALUE/10 || (-res==Integer.MIN_VALUE/10 && -(s.charAt(i)-'0') < Integer.MIN_VALUE % 10))) return Integer.MIN_VALUE;
                res *= 10;
                res += s.charAt(i) - '0';
            }
        }
        if(negative) return -res;
        else return res;
    }
}
