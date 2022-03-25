package leetcode;

import java.util.Stack;

public class Debug {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        int pos = -1;
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[i]>stack.peek()){
                System.out.println(stack.peek());
                pos ++;
                stack.pop();
                res[pos] = i - pos;
            }
            stack.push(temperatures[i]);
        }

        while(!stack.isEmpty()){
            stack.pop();
            res[pos] = 0;
            pos ++;
        }
        return res;
    }
}
