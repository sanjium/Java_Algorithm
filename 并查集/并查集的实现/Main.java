package 并查集.并查集的实现;

import java.io.*;

// 测试链接: https://www.nowcoder.com/practice/e7ed657974934a30b2010046536a5372
public class Main {
    public static int N = 1000001;
    public static int[] arr = new int[N];

    public static int[] size = new int[N];
    public static int[] stack = new int[N];

    public static void build() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int i) {
        int size = 0;

        while (i != arr[i]) {
            stack[size++] = i;
            i = arr[i];
        }
        while (size > 0) {
            arr[stack[--size]] = i;
        }

        return i;
    }

    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx != fy) {
            if (size[fx] <= size[fy]) {
                arr[fx] = fy;
                size[fy] += size[fx];
            } else {
                arr[fy] = fx;
                size[fx] += size[fy];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            build();
            in.nextToken();
            int m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int op = (int) in.nval;
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                if (op == 1) {
                    out.println(isSameSet(x, y) ? "Yes" : "No");
                } else {
                    union(x, y);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}
