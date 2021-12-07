package leetcode;

public class Leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[2];

        // 找到起始位置
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        res[0] = left;
        if(nums.length==0||nums[left]!=target) return new int[]{-1, -1};

        left = 0;
        right = nums.length-1;
        // 找到 结束位置
        while(left < right){
            int mid = (left + right + 1) / 2;
            if(nums[mid]<=target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        res[1] = left;
        return res;
    }
}
