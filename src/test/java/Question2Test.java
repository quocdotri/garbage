import org.junit.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class Question2Test {
    @Test
    public void testFindTrippletSumZero(){
       List result0 = Question2.findTrippletSumZero(Arrays.asList(new Integer[] {}));
       assertEquals(0, result0.size());
       System.out.println(result0);

        List result1 = Question2.findTrippletSumZero(null);
        System.out.println(result1);
        assertEquals(0, result1.size());

        List result2 = Question2.findTrippletSumZero(Arrays.asList(new Integer[] {0, 0, 0 }));
        System.out.println(result2);
        // [[0, 0, 0]]
        assertEquals(1, result2.size());


        List result3 = Question2.findTrippletSumZero(Arrays.asList(new Integer[] {2, 2, 2, 2, -2, -2, -2, -4, -2, -1 , 0, 0, 0, 1, 3, 4 }));
        System.out.println(result3);
        // [[-4, 0, 4], [-4, 1, 3], [-4, 2, 2], [-2, -2, 4], [-2, -1, 3], [-2, 0, 2], [-1, 0, 1], [0, 0, 0]]
        assertEquals(8, result3.size());

    }

}