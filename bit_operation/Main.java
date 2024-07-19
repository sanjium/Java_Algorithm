package bit_operation;

public class Main {
    public static void main(String[] args) {
        int num = 4;
        printBinary(num);
    }

    public static void printBinary(int num) {
        for (int i = 32; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
    }


}
