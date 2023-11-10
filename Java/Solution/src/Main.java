import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b, c, d;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        long dp[][] = new long[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                dp[i][j] = 0;
            }
        }
        if (c - 1 >= 0 && d - 2 >= 0)
            dp[c - 1][d - 2] = -0x3f3f3f;
        if (c - 2 >= 0 && d - 1 >= 0)
            dp[c - 2][d - 1] = -0x3f3f3f;
        if (c + 1 < 25 && d - 2 >= 0)
            dp[c + 1][d - 2] = -0x3f3f3f;
        if (c - 1 >= 0 && d + 2 < 25)
            dp[c - 1][d + 2] = -0x3f3f3f;
        if (c - 2 >= 0 && d + 1 < 25)
            dp[c - 2][d + 1] = -0x3f3f3f;
        if (c + 1 < 25 && d + 2 < 25)
            dp[c + 1][d + 2] = -0x3f3f3f;
        if (c + 2 < 25 && d - 1 >= 0)
            dp[c + 2][d - 1] = -0x3f3f3f;
        if (c + 2 < 25 && d + 1 < 25)
            dp[c + 2][d + 1] = -0x3f3f3f;
        dp[c][d] = -0x3f3f3f;
        if (dp[0][0] == -0x3f3f3f || dp[a][b] == -0x3f3f3f)
            System.out.println(0);
        else {
            dp[0][0] = 1;
            for (int i = 0; i <= a; ++i) {
                for (int j = 0; j <= b; ++j) {
                    if (i - 1 >= 0 && dp[i - 1][j] >= 0)
                        dp[i][j] += dp[i - 1][j];
                    if (j - 1 >= 0 && dp[i][j - 1] >= 0)
                        dp[i][j] += dp[i][j - 1];
                }
            }
            System.out.println(dp[a][b]);
        }
    }
}
