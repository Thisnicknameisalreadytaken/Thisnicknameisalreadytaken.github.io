import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        assertEquals(true, new test().isPrime(2));
        assertEquals(true, new test().isPrime(3));
    }

    @Test
    public void test2() {
        assertEquals(true, new test().isPrime(5));
        assertEquals(true, new test().isPrime(7));
    }

    @Test
    public void test3() {
        assertEquals(true, new test().isPrime(7));
        assertEquals(true, new test().isPrime(11));
    }
}
