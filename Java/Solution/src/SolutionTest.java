import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(4, new Solution().longestAlternatingSubarray(new int[] { 84, 32, 18, 70, 14, 52, 57, 96, 61, 58,
                13 }, 100));
    }
}
