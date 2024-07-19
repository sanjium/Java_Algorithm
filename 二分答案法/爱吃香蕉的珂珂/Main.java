package 二分答案法.爱吃香蕉的珂珂;

// 测试链接 : https://leetcode.cn/problems/koko-eating-bananas/
public class Main {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(pile, r);
        }
        r += 1;
        int ans = 0;
        int m;
        while (l + 1 != r) {
            m = l + ((r - l) >> 1);
            if (isBlue(piles, m, h)) {
                l = m;
            } else {
                ans = m;
                r = m;
            }
        }
        return ans;
    }

    public boolean isBlue(int[] piles, int speed, int h) {
        long ans = 0;
        for (int pile : piles) {
            ans += (int) Math.ceil((double) pile / speed);
        }
        return ans > h;
    }

}
