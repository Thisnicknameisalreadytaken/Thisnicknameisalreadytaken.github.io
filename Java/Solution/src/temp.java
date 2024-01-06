public class temp {
    public static void main(String[] args) {
        int num[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num[i][j] = i * j;
            }
        }
        int temp[][] = num;
        temp[0][0] = 1;
        System.out.println(num[0][0]);
    }
}
