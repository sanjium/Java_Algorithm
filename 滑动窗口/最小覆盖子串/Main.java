package 滑动窗口.最小覆盖子串;

public class Main {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] cnt = new int[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            cnt[c]--;
        }
        int len = Integer.MAX_VALUE;
        int start = 0;

        for (int l = 0, r = 0, debt = t.length(); r < s.length(); r++) {
            if (cnt[s.charAt(r)]++ < 0) {
                debt--;
            }

            if (debt == 0) {
                while (cnt[s.charAt(l)] > 0) {
                    cnt[s.charAt(l++)]--;
                }
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
