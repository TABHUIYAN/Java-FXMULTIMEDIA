/*
 *Junit test class which passed the test
 */
package myapp2.wristwatches;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BHUIYAN
 */
public class ClassForJunitTestTest {
    
    public ClassForJunitTestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class ClassForJunitTest.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String s1 = "2";
        String s2 = "2";
        ClassForJunitTest instance = new ClassForJunitTest();
        int expResult = 4;
        int result = instance.add(s1, s2);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testAdd2() {
        System.out.println("add");
        String s1 = "2";
        String s2 = "3";
        ClassForJunitTest instance = new ClassForJunitTest();
        int expResult = 5;
        int result = instance.add(s1, s2);
        assertEquals(expResult, result);
        
    }
    
}
