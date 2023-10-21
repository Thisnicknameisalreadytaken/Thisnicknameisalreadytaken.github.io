import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(20, new Solution().maxSatisfaction(new int[] { 4, 3, 2 }));
    }
}
