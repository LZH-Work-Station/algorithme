package leetcode;

public class Leetcode_41 {
    public int firstMissingPositive(int[] nums) {
        // 一共有n个数，最小正整数不是n+1就是在1-n里面
        // 先把所有负数变成 n+1
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i] = n + 1;
            }
        }
        // 比如说我的值是三 则代表如果把所有的正整数从小往大排，第nums[2]那个位置应该是属于 3的
        // 我们把nums[2]变成他的相反数用来标记这个位置有对应的正整数，如果最后从左往右遍历的时候有位置不是负数，则没有一个对应的正整数填上那个位置
        for(int i=0;i<n;i++){
            // 因为后面的位置有可能因为前面的正整数而变成负数，所以要想获得原来数字的位置得加绝对值
            int num = Math.abs(nums[i]);
            if(num < n+1){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return n+1;
    }
}
