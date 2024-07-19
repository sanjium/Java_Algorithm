package 嵌套_dfs.基本计算器II;

import java.util.ArrayList;
import java.util.List;

// 227. 基本计算器II: https://leetcode.cn/problems/basic-calculator-ii/description/
public class Main {

    private static char[] chars;

    private static int where;

    public int calculate(String s) {
        chars = s.replaceAll(" ", "").toCharArray();
        return dfs(0);
    }

    public int dfs(int i) {
        int cur = 0;
        List<Integer> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                cur = cur * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                push(cur, chars[i++], numbers, ops);
                cur = 0;
            } else {
                dfs(i + 1);
                i = where + 1;
            }
        }
        push(cur, '+', numbers, ops);
        where = i;
        return compute(numbers, ops);
    }

    public void push(int number, char op, List<Integer> numbers, List<Character> ops) {
        int size = numbers.size();
        if (size == 0 || ops.get(size - 1) == '+' || ops.get(size - 1) == '-') {
            numbers.add(number);
            ops.add(op);
        } else {
            int lastNumber = numbers.get(size - 1);
            int lastOp = ops.get(size - 1);
            if (lastOp == '*') {
                lastNumber = lastNumber * number;
            } else {
                lastNumber = lastNumber / number;
            }
            numbers.set(size - 1, lastNumber);
            ops.set(size - 1, op);
        }
    }

    private int compute(List<Integer> numbers, List<Character> ops) {
        int ans = numbers.get(0);
        int size = numbers.size();
        for (int i = 1; i < size; i++) {
            if (ops.get(i - 1) == '+') {
                ans += numbers.get(i);
            } else {
                ans -= numbers.get(i);
            }
        }
        return ans;
    }

}
