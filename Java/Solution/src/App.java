import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int a;
        int b;
        int g;
        int k;
        int[][] num = new int[1004][4];
        for (int i = 0; i < sum; ++i) {
            a = sc.nextInt();
            b = sc.nextInt();
            g = sc.nextInt();
            k = sc.nextInt();
            num[i][0] = a;
            num[i][1] = b;
            num[i][2] = g;
            num[i][3] = k;
        }
        int x;
        int y;
        x = sc.nextInt();
        y = sc.nextInt();
        int res = -1;
        for (int i = 0; i < sum; ++i) {
            if (num[i][0] <= x && num[i][1] <= y && num[i][0] + num[i][2] >= x && num[i][1] + num[i][3] >= y)
                res = i + 1;
        }
        System.out.println(res);
    }
}
