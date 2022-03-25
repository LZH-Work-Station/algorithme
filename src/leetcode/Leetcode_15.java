package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            // 如果起始位置和之前相同就跳过
            if(i>0&&nums[i-1]==nums[i]) continue;
            while(left<right){
                if(nums[left]+nums[right]+nums[i]==0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    tmp.add(nums[i]);
                    list.add(tmp);
                    // 只有我们验证了left和right 加上i和为0才会跳过相同的点 不然不会跳过 所以while要写在这个里面
                    while(left<right&&nums[left]==nums[left+1]) left ++;
                    while(left<right&&nums[right]==nums[right-1]) right --;
                    // 跳过了所有重复的点 不再会有这样的组合所以left和right都要变
                    left ++;
                    right --;
                }else if(nums[left]+nums[right]+nums[i]>0){
                    right --;
                }else{
                    left ++;
                }
            }
        }
        return list;
    }
}
