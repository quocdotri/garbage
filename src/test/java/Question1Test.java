import org.junit.Test;

import static org.junit.Assert.*;

public class Question1Test {

    @Test
    public void testCheckPalaindrome() {
        assertTrue(!Question1.checkPalaindrome(null));

        String s1 = "Helloworld" ;
        // false
        assertTrue(! Question1.checkPalaindrome(s1));

        String s2 = "A Toyota’s a Toyota";
        //true
        assertTrue( Question1.checkPalaindrome(s2));

        String s3 = "abcdef  e d C B A ;; ;; ; ;";
        assertTrue( Question1.checkPalaindrome(s3));

    }
}