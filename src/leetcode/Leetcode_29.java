package leetcode;

public class Leetcode_29 {
    //首先11比3大，结果至少是1， 然后我让3翻倍，就是6，发现11比3翻倍后还要大，那么结果就至少是2了，那我让这个6再翻倍，得12，11不比12大，吓死我了
    //，差点让就让刚才的最小解2也翻倍得到4了。但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数，这个数是多少呢？我让11减去刚才最后一次的结果6，
    //剩下5，我们计算5是3的几倍，也就是除法

    public int divide(int dividend, int divisor) {
        int sign = 0;
        if((dividend>0&&divisor<0) || (dividend<0&&divisor>0)){
            sign = -1;
        }
        int res = close(Math.abs(dividend), Math.abs(divisor));
        if(sign == -1) return -res;
        else return res;
    }

    public int close(int dividend, int divisor){
        if(dividend < divisor) return 0;
        int count = 1;
        int tmp = divisor;
        while(dividend >= (tmp + tmp)){
            count <<= 1;
            tmp <<= 1;
        }
        return count + close(dividend - tmp, divisor);
    }
}
