import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        assertEquals(1, new Solution().hIndex(new int[] { 0 }));
    }
}
