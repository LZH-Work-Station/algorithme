package leetcode;

public class Leetcode_33 {
    public int search(int[] nums, int target) {
        // 分类讨论 将数组分成0-mid 和mid-结束两部分 分类讨论target应该在哪个位置
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;

            if(nums[0]<=nums[mid]){
                if(nums[mid]<target){
                    left = mid + 1;
                }else if(nums[0] <= target){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid]<target&&target<nums[0]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        if(nums[left]!=target) return -1;
        return left;
    }
}
