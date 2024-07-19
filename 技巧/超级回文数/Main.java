package 技巧.超级回文数;

/**
 * @description:
 * @author：三玖
 * @date: 2024/2/8
 */
public class Main {

    public int superpalindromesInRange(String left, String right) {
        long leftLimit = Long.parseLong(left);
        long rightLimit = Long.parseLong(right);
        long limit = (long) Math.sqrt((double) rightLimit);
        long seed = 1L;
        Long num;
        int ans = 0;

        do {
            num = evenNumber(seed);
            if (num * num >= leftLimit && num * num <= rightLimit && check(num * num)) {
                ans++;
            }

            num = oddNumber(seed);
            if (num * num >= leftLimit && num * num <= rightLimit && check(num * num)) {
                ans++;
            }
            seed++;
        } while (num < limit);

        return ans;
    }

    // 变成偶数回文

    //123
    //123
    public long evenNumber(long n) {
        long ans = n;
        while (n > 0) {
            long temp = n % 10;
            ans = ans * 10 + temp;
            n /= 10;
        }
        return ans;
    }

    //变成奇数回文
    public long oddNumber(long n) {
        long ans = n;
        n /= 10;
        while (n > 0) {
            long temp = n % 10;
            ans = ans * 10 + temp;
            n /= 10;
        }
        return ans;
    }

    //判断一个数是否为回文数
    // 123321
    // 100000
    public boolean check(long n) {
        long offset = 1;
        while (n / offset >= 10) {
            offset *= 10;
        }

        while (n > 0) {
            if (n / offset != n % 10) {
                return false;
            }

            n = (n % offset) / 10;
            offset /= 100;
        }
        return true;
    }

}
