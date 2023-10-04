import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(7, new Solution().maxProfit(new int[] { 3, 2, 6, 5, 0, 3 }));
    }
}
