package 前缀和.表现良好的最长时间段;

import java.util.HashMap;
import java.util.Map;

//测试链接: https://leetcode.cn/problems/longest-well-performing-interval/description/
public class Main {

    Map<Integer, Integer> map;

    public int longestWPI(int[] hours) {
        map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                result = i + 1;
            } else {
                if (map.containsKey(sum - 1)){
                    result = Math.max(result, i - map.get(sum - 1));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}
