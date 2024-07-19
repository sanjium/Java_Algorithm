import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {

    static int N = 30;

    static int[] a = new int[N];

    static int[] q = new int[N];

    static int n;

    static int k;

    static int res = 0;

    public static boolean isPrim(int sum) {
        if (sum < 2) {
            return false;
        }
        for (int i = 2; i < sum / i; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int x, int start) {
        if (x > k) {
            int sum = 0;

            for (int i = 1; i <= k; i++) {
                sum += a[i];
            }

            if (isPrim(sum)) {
                res++;
            }
            return;
        }


        for (int i = start; i <= n; i++) {
            a[x] = q[i];
            dfs(x + 1, i + 1);
            a[x] = 0;
        }
    }


    public static void main(String[] args) {
        main2(args);
//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();
//        k = scan.nextInt();
//        for (int i = 1; i <= n; i++) {
//            q[i] = scan.nextInt();
//        }
//
//        dfs(1, 1);
//
//        System.out.println(res);
//
//        scan.close();
    }

    public static void main2(String[] args) {
        int num = 4;
        printBinary(num);
    }

    public static void printBinary(int num) {
        for (int i = 32; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
    }


}