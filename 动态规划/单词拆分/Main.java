package 动态规划.单词拆分;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 测试链接: https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    public Map<String, Boolean> mem = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new StringBuilder());
    }

    public boolean dfs(String s, List<String> wordDict, StringBuilder cur) {
        if (mem.containsKey(cur.toString())) {
            return mem.get(cur.toString());
        }
        if (cur.toString().equals(s)) {
            return true;
        }

        if (cur.length() >= s.length()) {
            return false;
        }

        boolean res = false;
        StringBuilder temp = new StringBuilder(cur.toString());
        for (String word : wordDict) {
            res |= dfs(s, wordDict, temp.append(word));
            temp = new StringBuilder(cur.toString());
        }
        mem.put(cur.toString(),res);
        return res;
    }

}
