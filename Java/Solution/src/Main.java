import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp = sc.nextLine();
        temp = sc.nextLine();
        int num = Integer.parseInt(temp, n);
        int min = 0x3f3f3f3f;
        int res = 0;
        int now = num;
        while (true) {

        }
    }

    static String baseAny(int n, int base) {
        if (n == 0 || n == 1)
            return String.valueOf(n);
        String ans = "";
        while (n != 0) {
            int r = n % base;
            if (r < 0) {
                r -= base;
                n += base;
            }
            if (r >= 10) {
                ans += (char) ('A' + r - 10);
            } else {
                ans += (char) (r + '0');
            }
            n /= base;
        }
        String res = new StringBuilder(ans).reverse().toString();
        return res;
    }
}