import java.util.HashMap;

class StockPrice {

    public StockPrice() {

    }

    int max = -0x3f3f3f3f;
    int min = 0x3f3f3f3f;
    int newtime = 0;
    HashMap<Integer, Integer> hash = new HashMap<>();

    public void update(int timestamp, int price) {
        boolean judge = hash.containsKey(timestamp);
        if (judge == false) {
            hash.put(timestamp, price);
            newtime = Math.max(timestamp, newtime);
            max = Math.max(max, price);
            min = Math.min(min, price);
        } else {
            if (hash.get(timestamp) == max || hash.get(timestamp) == min) {
                max = -0x3f3f3f3f;
                min = 0x3f3f3f3f;
                hash.put(timestamp, price);
                for (int i : hash.values()) {
                    max = Math.max(max, i);
                    min = Math.min(min, i);
                }
            } else {
                hash.put(timestamp, price);
                max = Math.max(max, price);
                min = Math.min(min, price);
            }
        }

    }

    public int current() {
        return hash.get(newtime);
    }

    public int maximum() {
        return max;
    }

    public int minimum() {
        return min;
    }
}