import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        assertEquals(3, new Solution().maxMoves(new int[][] { { 148, 977, 259, 631, 387, 224 },
                { 863, 952, 417, 145, 624, 798 }, { 271, 613, 849, 965, 532, 187 }, { 586, 428, 791, 372, 913, 639 },
                { 324, 756, 198, 869, 257, 415 }, { 954, 162, 485, 297, 738, 811 } }));
    }
}
