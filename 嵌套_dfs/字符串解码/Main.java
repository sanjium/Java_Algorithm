package 嵌套_dfs.字符串解码;

public class Main {

    public static int where;

    public static char[] chars;

    public String decodeString(String s) {
        chars = s.toCharArray();
        return dfs(0);
    }

    public String dfs(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (i < chars.length && chars[i] != ']') {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                stringBuilder.append(chars[i++]);
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                count = count * 10 + chars[i++] - '0';
            } else {
                String temp = dfs(i + 1);
                for (int k = 0; k < Math.max(1,count); k++) {
                    stringBuilder.append(temp);
                }
                count = 0;
                i = where + 1;
            }
        }
        where = i;
        return stringBuilder.toString();
    }
}
