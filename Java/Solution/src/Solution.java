import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums)
            q.offer(num);
        for (; k > 0; --k) {
            int temp = q.poll();
            res += temp;
            q.offer((temp + 2) / 3);
        }
        return res;
    }
}