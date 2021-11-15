package leetcode;

// 27题和26题没啥区别可以一起做了
// 采用双指针，一个是fast遍历整个数组，一个是slow是要返回的数组。所有slow过手的数字都是不重复的
public class Leetcode_26 {
    public int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        while(fast < nums.length){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow;
    }
}
