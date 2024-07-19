package dfs.字母大小写全排列;

import java.util.ArrayList;
import java.util.List;

// 784. 字母大小写全排列: https://leetcode.cn/problems/letter-case-permutation/description/
public class Main {

    private static List<String> result;

    private static StringBuilder stringBuilder;

    private static char[] str;

    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        stringBuilder = new StringBuilder();
        str = s.toCharArray();
        dfs(0);
        return result;
    }

    private void dfs(int x) {
        if (x == str.length) {
            result.add(stringBuilder.toString());
            return;
        }

        char c = str[x];
        if (!Character.isLetter(c)) {
            stringBuilder.append(c);
            dfs(x + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            //不转
            stringBuilder.append(c);
            dfs(x + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            // 转
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            stringBuilder.append(c);
            dfs(x + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
