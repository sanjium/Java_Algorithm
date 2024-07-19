package 二维前缀和.二维区域和检索_矩阵不可变;

// 测试链接: https://leetcode.cn/problems/range-sum-query-2d-immutable/
class NumMatrix {

    public int[][] sum;

    public NumMatrix(int[][] matrix) {
        sum = matrix;

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                sum[i][j] += (i > 0 ? sum[i - 1][j] : 0) + (j > 0 ? sum[i][j - 1] : 0) - (i > 0 && j > 0 ? sum[i - 1][j - 1] : 0);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - (row1 > 0 ? sum[row1 - 1][col2] : 0) - (col1 > 0 ? sum[row2][col1 - 1] : 0) + (row1 > 0 && col1 > 0 ? sum[row1 - 1][col1 - 1] : 0);
    }
}