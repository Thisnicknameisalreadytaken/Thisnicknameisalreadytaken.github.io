import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int base = sc.nextInt();
        System.out.println(num + "=" + baseAny(num, base) + "(base" + base + ")");
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
