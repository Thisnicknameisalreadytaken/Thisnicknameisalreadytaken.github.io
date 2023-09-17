
public class hi {
    public static void main(String[] args) {
        String[][] users = new String[2][2];
        users[0][0] = "hi";
        users[0][1] = users[0][0];
        System.out.println(users[0][0]);
        System.out.println(users[0][1]);
    }
}
