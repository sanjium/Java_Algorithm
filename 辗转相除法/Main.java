package 辗转相除法;

// 878. 第N个神奇的数字: https://leetcode.cn/problems/nth-magical-number/description/
public class Main {

    public static long lcm;

    public int nthMagicalNumber(int n, int a, int b) {
        lcm = lcm(a, b);
        long l = -1;
        long r = (long) n * Math.min(a, b);
        while (l + 1 != r) {
            long m = (l + r) >> 1;
            if (isBlue(m, n, a, b)) {
                l = m;
            } else {
                r = m;
            }
        }

        System.out.println(r);

        return (int) (r % 1000000007);
    }

    private boolean isBlue(long m, int n, int a, int b) {
        return m / a + m / b - m / lcm < n;
    }

    //最大公约数
    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //最小公倍数
    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

}
