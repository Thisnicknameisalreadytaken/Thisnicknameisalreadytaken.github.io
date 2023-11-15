import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num[] = new int[11];
        for (int i = 1; i < num.length; i++) {
            num[i] = 1;
        }
        int temp = 0;
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= 9; ++j) {
                for (int k = 1; k <= 9; ++k) {
                    for (int l = 1; l < num.length; l++) {
                        num[l] = 1;
                    }
                    temp = i * 100 + j * 10 + k;
                    if (temp > 329)
                        break;
                    num[i] = 0;
                    num[j] = 0;
                    num[k] = 0;
                    temp <<= 1;
                    if (num[temp % 10]-- == 1 && num[temp / 100]-- == 1 && num[temp / 10 % 10]-- == 1) {
                        temp >>= 1;
                        temp *= 3;
                        if (num[temp % 10]-- == 1 && num[temp / 100]-- == 1 && num[temp / 10 % 10]-- == 1) {
                            System.out.println(temp / 3 + " " + (int) (temp / 1.5) + " " + temp);
                        }
                    }
                }
            }
        }
    }
}