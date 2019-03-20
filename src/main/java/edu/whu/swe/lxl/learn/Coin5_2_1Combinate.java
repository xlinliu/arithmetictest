package edu.whu.swe.lxl.learn;

public class Coin5_2_1Combinate {

    public static void main(String[] args) {
        int n = 6;
        System.out.print(Coin5_2_1Combinate.resolve(n));
    }

    private static int resolve(int n) {
        int count = 0;
        int _5 = n / 5;
        for (int i = _5; i >= 0; i--) {
            int _2 = (n - i * 5) / 2;
            for (int j = _2; j >= 0; j--) {
                int _1 = n - j * 2 - i * 5;
                ++count;
            }

        }
        return count;
    }
}
