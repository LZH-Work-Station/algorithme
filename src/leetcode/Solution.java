package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        if(s.length() % 2!=0) return false;
        Deque<Character> deque = new LinkedList();
        for(int i=0;i<s.length();i++){
            Character record = map.getOrDefault(s.charAt(i), '0');
            if(record=='0'){
                deque.addFirst(s.charAt(i));
            }else{
                if(record!=deque.removeFirst()) return false;
            }
        }
        if(deque.size()!=0) return false;
        return true;
    }
}