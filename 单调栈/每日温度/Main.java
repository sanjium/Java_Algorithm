package 单调栈.每日温度;

// 测试链接: https://leetcode.cn/problems/daily-temperatures/description/
public class Main {

    public static int N = 100001;
    public static int[] stack = new int[N];
    public static int r;

    public int[] dailyTemperatures(int[] temperatures) {
        r = 0;
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (r > 0 && temperatures[stack[r - 1]] < temperatures[i]) {
                int pop = stack[--r];
                result[pop] = i - pop;
            }
            stack[r++] = i;
        }
        return result;
    }

}
