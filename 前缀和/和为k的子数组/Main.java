package 前缀和.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

//测试链接 : https://leetcode.cn/problems/subarray-sum-equals-k/
public class Main {

    public Map<Integer, Integer> map;

    public int subarraySum(int[] nums, int k) {
        map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
