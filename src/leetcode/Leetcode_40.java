package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(list, 0, target, candidates, new ArrayList<Integer>());
        return list;

    }

    public void dfs(List<List<Integer>> list, int pos, int target, int[] candidates, ArrayList<Integer>tmp){
        if(target<0) return;
        if(target==0){
            list.add(new ArrayList<>(tmp));
            return;
        }else{
            for(int i=pos;i<candidates.length;i++){
                // 这里面1开头的全都找到了，所以如果下一个数字也是1就应该跳过
                if(i>pos&&candidates[i]==candidates[i-1]) continue;
                tmp.add(candidates[i]);
                dfs(list, i+1, target-candidates[i], candidates, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
