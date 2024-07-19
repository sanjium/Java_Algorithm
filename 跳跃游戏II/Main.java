package 跳跃游戏II;

/**
 * @description:
 * @author：三玖
 * @date: 2024/7/13
 */
public class Main {

    public static int jump(int[] nums) {
        int point = 0;
        int currentIndex = nums.length - 1;
        while (currentIndex > 0) {
            int arriveIndex = currentIndex;
            int tempIndex = arriveIndex - 1;
            while (tempIndex >= 0) {
                if (nums[tempIndex] >= currentIndex - tempIndex) {
                    arriveIndex = tempIndex;
                }
                tempIndex--;
            }
            currentIndex = arriveIndex;
            point++;
        }
        return point;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
