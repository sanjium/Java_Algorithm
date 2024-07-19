package 滑动窗口.无重复字符的最长字串;

import java.util.Arrays;

public class Main {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int result = 0;
        for (int l = 0, r = 0; r < chars.length; r++) {
            l = Math.max(l, last[chars[r]] + 1);
            result = Math.max(result, r - l + 1);
            last[chars[r]] = r;
        }
        return result;
    }

}
