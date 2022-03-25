package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {
    // 通过HashMap实现一次遍历解决
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i, nums[map.get(target-nums[i])]};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
