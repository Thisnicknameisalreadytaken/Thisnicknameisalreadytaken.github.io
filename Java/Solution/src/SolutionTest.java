import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(new int[0], new Solution().avoidFlood(new int[] { 1, 2, 0, 1, 2 }));
    }
}
