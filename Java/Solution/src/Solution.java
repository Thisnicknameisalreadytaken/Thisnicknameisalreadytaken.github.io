import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        long res = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : gifts) {
            pq.add(i);
        }
        int temp = 0;
        for (int i = 0; i < k; ++i) {
            temp = pq.poll();
            temp = (int) Math.sqrt(temp);
            pq.add(temp);
        }
        for (int i : pq) {
            res += i;
        }
        return res;
    }
}