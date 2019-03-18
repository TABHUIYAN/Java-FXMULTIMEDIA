/*
 * WatchStrap test file
 * test fail because of null exception
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
public class WatchStrapTest {
    
    public WatchStrapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class WatchStrap.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WatchStrap instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrapType method, of class WatchStrap.
     */
    @Test
    public void testGetStrapType() {
        System.out.println("getStrapType");
        WatchStrap instance = null;
        String expResult = "";
        String result = instance.getStrapType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrapColor method, of class WatchStrap.
     */
    @Test
    public void testGetStrapColor() {
        System.out.println("getStrapColor");
        WatchStrap instance = null;
        String expResult = "";
        String result = instance.getStrapColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isChangableStrap method, of class WatchStrap.
     */
    @Test
    public void testIsChangableStrap() {
        System.out.println("isChangableStrap");
        WatchStrap instance = null;
        boolean expResult = false;
        boolean result = instance.isChangableStrap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
