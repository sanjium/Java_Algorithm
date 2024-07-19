package 动态规划.杨辉三角;

import java.util.ArrayList;
import java.util.List;

// 测试链接: https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        dfs(numRows);
        return result;
    }

    public List<Integer> dfs(int x) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        if (x == 1) {
            result.add(temp);
            return temp;
        }
        List<Integer> pre = dfs(x - 1);
        for (int i = 1; i < x - 1; i++) {
            temp.add(pre.get(i - 1) + pre.get(i));
        }
        temp.add(1);
        result.add(temp);
        return temp;
    }

}
