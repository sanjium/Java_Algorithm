package 一维差分.航班预定统计;

public class Main {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] cnt = new int[n + 2];
        for (int[] booking : bookings) {
            cnt[booking[0]] += booking[2];
            cnt[booking[1] + 1] -= booking[2];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i + 1] += cnt[i];
            result[i] = cnt[i + 1];
        }
        return result;
    }
}
