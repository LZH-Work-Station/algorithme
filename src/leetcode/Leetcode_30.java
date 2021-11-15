package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> model = new HashMap<>();
        for(String m : words){
            model.put(m, model.getOrDefault(m, 0) + 1);
        }

        int minLen = words[0].length();
        int len = words.length;

        for(int i=0;i<s.length()-len*minLen+1;i++){
            Map<String, Integer> tmp = new HashMap<>();
            for(int j=0;j<len;j++){
                int start = i + j * minLen;
                tmp.put(s.substring(start, start + minLen), tmp.getOrDefault(s.substring(start, start + minLen), 0) + 1);
            }
            if(tmp.equals(model)) list.add(i);
        }
        return list;

    }

}
