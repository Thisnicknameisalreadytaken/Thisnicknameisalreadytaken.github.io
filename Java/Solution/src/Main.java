import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dif(num);
    }

    public static void dif(int num) {
        for (int i = 14; i >= 0; --i) {
            if (Math.pow(2, i) <= num) {
                if (i == 0)
                    System.out.print("2(0)");
                else if (i == 1)
                    System.out.print("2");
                else if (i == 2)
                    System.out.print("2(2)");
                else {
                    System.out.print("2(");
                    dif(i);
                    System.out.print(")");
                }
                num -= Math.pow(2, i);
                if (num != 0)
                    System.out.print("+");
            }
        }
        return;
    }
}