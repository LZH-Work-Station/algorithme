package leetcode;

public class Leetcode_29 {
    //首先11比3大，结果至少是1， 然后我让3翻倍，就是6，发现11比3翻倍后还要大，那么结果就至少是2了，那我让这个6再翻倍，得12，11不比12大，吓死我了
    //，差点让就让刚才的最小解2也翻倍得到4了。但是我知道最终结果肯定在2和4之间。也就是说2再加上某个数，这个数是多少呢？我让11减去刚才最后一次的结果6，
    //剩下5，我们计算5是3的几倍，也就是除法

    public int divide(int dividend, int divisor) {
        // 当除数为1，直接返回被除数
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        // 把被除数与除数调整为正数,为防止被除数Integer.MIN_VALUE转换为正数会溢出，使用long类型保存参数
        if (dividend < 0 && divisor < 0) {
            return divide(-(long) dividend, -(long) divisor);
        } else if (dividend < 0 || divisor < 0) {
            return -divide(Math.abs((long) dividend), Math.abs((long) divisor));
        } else {
            return divide((long) dividend, (long) divisor);
        }

    }
    public int divide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        int count = 1;
        long tmp = divisor;
        while (dividend >= (tmp + tmp)) {
            count <<= 1;
            tmp <<= 1;
        }
        return count + divide(dividend - tmp, divisor);
    }
}
