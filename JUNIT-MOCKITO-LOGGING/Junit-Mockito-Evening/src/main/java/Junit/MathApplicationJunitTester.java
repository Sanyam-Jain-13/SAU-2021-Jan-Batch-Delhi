package Junit;

import junit.framework.TestCase;
import org.junit.Test;

public class MathApplicationJunitTester extends TestCase {

    MathApplicationJunit app = new MathApplicationJunit();

    public void testAdd()
    {
        assertEquals(app.add(10.0,20.0),30.0,0);
    }

    public void testSub()
    {
        assertEquals(app.subtract(20.0,10.0),10.0,0);
    }

    public void testMul()
    {
        assertEquals(app.multiply(10.0,10.0),100.0,0);
    }

    public void testDivide()
    {
        assertEquals(app.divide(20.0,10.0),2.0,0);
    }
}
