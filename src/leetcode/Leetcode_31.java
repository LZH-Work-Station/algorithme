package leetcode;

class Leetcode_31{
    public void nextPermutation(int[] nums) {
        // 1. 先从后往前遍历找到一个升序排列的值 a，相当于在这一位进位然后让后面的值变得尽可能小
        // 2. 从后往前遍历找到比 a大的值 b
        // 3. 交换两个值
        // 4. 将后面的数字升序排列，保证之前越大的数字越往后，然后交换位置的值尽可能小
        int i = nums.length - 2;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            i--;
        }
        if(i>=0){
            int j = nums.length - 1;
            while(j>i){
                if(nums[j]>nums[i]){
                    break;
                }
                j--;
            }
            swap(i, j, nums);
        }

        reverse(i+1, nums.length-1, nums);
    }

    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int start, int end, int[] nums){
        while(start<end){
            swap(start, end, nums);
            start ++;
            end --;
        }
    }
}