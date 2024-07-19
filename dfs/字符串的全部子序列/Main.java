package dfs.字符串的全部子序列;

import java.util.HashSet;
import java.util.Set;

// 字符串的全部子序列: https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
public class Main {

    private static StringBuilder path;

    private static char[] chars;

    private static Set<String> set;

    public String[] generatePermutation(String s) {
        chars = s.toCharArray();
        path = new StringBuilder();
        set = new HashSet<>();
        dfs(0);
        int size = set.size();
        String[] result = new String[size];
        int i = 0;
        for (String string : set) {
            result[i++] = string;
        }
        return result;
    }

    public void dfs(int i) {
        if (i == chars.length) {
            set.add(path.toString());
            return;
        }
        //选
        path.append(chars[i]);
        dfs(i + 1);
        //恢复现场
        path.deleteCharAt(path.length() - 1);
        //不选
        dfs(i + 1);
    }
}
