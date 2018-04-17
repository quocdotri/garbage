import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;
public class Question3Test {
    @Test
    public void testPool() throws Exception {
        final Question3ObjectPool<SampleObjectForPool> pool = new Question3ObjectPool<SampleObjectForPool>(3,SampleObjectForPool.class);

        // check borrow
        SampleObjectForPool p = pool.borrowObject();
        SampleObjectForPool p1 = pool.borrowObject();
        SampleObjectForPool p3 = pool.borrowObject();
        try {
            SampleObjectForPool p4 = pool.borrowObject();
            throw new Exception ("unexpected exception");
        } catch (Exception e) {
            assertEquals(e.getMessage(), Question3ObjectPool.NO_OBJECT_AVAILABLE);
        }

        // return then borrow
        pool.returnObject(p);
        SampleObjectForPool p4 = pool.borrowObject();
        // confirm that no new object has been created
        assertEquals(p, p4);


    }
}


