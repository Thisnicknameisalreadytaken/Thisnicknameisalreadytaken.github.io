import java.util.HashMap;
import java.util.TreeMap;

class StockPrice {

    public StockPrice() {

    }

    int newtime = 0;
    HashMap<Integer, Integer> hash = new HashMap<>();
    TreeMap<Integer, Integer> tree = new TreeMap<>();

    public void update(int timestamp, int price) {
        boolean judge = hash.containsKey(timestamp);
        newtime = Math.max(newtime, timestamp);
        if (judge == true) {
            tree.put(hash.get(timestamp), tree.get(hash.get(timestamp)) - 1);
            if (tree.get(hash.get(timestamp)) == 0) {
                tree.remove(price);
            }
        }
        hash.put(timestamp, price);
        tree.put(price, tree.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return hash.get(newtime);
    }

    public int maximum() {
        return tree.lastKey();
    }

    public int minimum() {
        return tree.firstKey();
    }
}