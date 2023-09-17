import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testAdd() {
        assertEquals(5, new Solution().add(3, 2));
    }

    @Test
    public void testSum() {
        assertEquals(3, new Solution().sum(new int[] { 1, 1, 1 }));
    }

    @Test
    public void testTotal() {
        assertEquals(4, new Solution().total(new int[][] { { 1, 1 }, { 1, 1 } }));
    }
}
