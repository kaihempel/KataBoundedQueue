package boundedqueue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Kai Hempel
 */
public class QueueTest {

    public QueueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void testEmptyQueue() {
        Queue<Integer> q = new Queue<>(0);

        assertEquals(0, q.getSize());
        assertEquals(0, q.getCount());
    }

    /**
     *
     */
    @Test
    public void testOneItemQueue() {
        Queue<Integer> q = new Queue<>(1);

        assertEquals(1, q.getSize());
        assertEquals(0, q.getCount());

        q.enqueue(123);

        assertEquals(1, q.getCount());
        assertEquals(123, (int)q.dequeue());
        assertEquals(0, q.getCount());
    }

    /**
     *
     */
    @Test
    public void testTowItemQueue() {
        Queue<Integer> q = new Queue<>(2);

        assertEquals(2, q.getSize());
        assertEquals(0, q.getCount());

        q.enqueue(2);
        q.enqueue(3);

        assertEquals(2, q.getCount());
        assertEquals(2, (int)q.dequeue());
        assertEquals(1, q.getCount());
        assertEquals(3, (int)q.dequeue());
        assertEquals(0, q.getCount());
        assertEquals(2, q.getSize());
    }

    /**
     *
     */
    @Test
    public void testAddToMuchItems() {
        Queue<Integer> q = new Queue<>(2);

        assertEquals(2, q.getSize());
        assertEquals(0, q.getCount());

        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        assertEquals(2, q.getCount());
        assertEquals(2, q.getSize());

        assertEquals(2, (int)q.dequeue());

        assertEquals(2, q.getCount());
        assertEquals(2, q.getSize());

        assertEquals(3, (int)q.dequeue());
        assertEquals(4, (int)q.dequeue());

        assertEquals(0, q.getCount());
        assertEquals(2, q.getSize());

    }
}
