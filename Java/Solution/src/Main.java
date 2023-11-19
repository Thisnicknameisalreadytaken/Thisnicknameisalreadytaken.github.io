import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        String num[] = new String[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (b.startsWith(a)) {
                    return 1;
                } else if (a.startsWith(b)) {
                    return -1;
                } else {
                    return a.compareTo(b);
                }
            }
        });
        for (int i = n - 1; i >= 1; --i) {
            if (num[i - 1].startsWith(num[i]) && num[i - 1].charAt(num[i].length()) > num[i].charAt(0)) {
                System.out.print(num[i - 1]);
                num[i - 1] = num[i];
            } else {
                System.out.print(num[i]);
            }
        }
        System.out.print(num[0]);
    }
}