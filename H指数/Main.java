package H指数;

import java.util.Arrays;

/**
 * @description:
 * @author：三玖
 * @date: 2024/7/13
 */
public class Main {
    public int hIndex(int[] citations) {
        // 3,2,1,1
        citations = Arrays.stream(citations).boxed().sorted((a, b) -> b - a).mapToInt(int1 -> int1).toArray();
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] <= i) {
                return i;
            }
        }
        return citations.length;
    }
}
