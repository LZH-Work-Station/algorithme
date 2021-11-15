package leetcode;

public class Leetcode_11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right){
            int tmp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(tmp, max);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return max;
    }
}
