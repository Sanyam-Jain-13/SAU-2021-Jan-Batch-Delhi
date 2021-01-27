package Junit_Mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester{

    @Mock
    CalculatorService calcService;

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Test
    public void testAdd(){

        when(calcService.add(10.0,20.0)).thenReturn(30.0);
        when(calcService.add(20.0,30.0)).thenReturn(50.0);

        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
        Assert.assertEquals(mathApplication.add(20.0,30.0),50.0,0);

        Mockito.verify(calcService,atLeast(1)).add(10.0,20.0);
    }

    @Test
    public void testSubtract()
    {
        when(calcService.subtract(20.0,10.0)).thenReturn(10.0);
        when(calcService.subtract(30.0,10.0)).thenReturn(20.0);

        Assert.assertEquals(mathApplication.subtract(20.0,10.0),10.0,0);
        Assert.assertEquals(mathApplication.subtract(30.0,10.0),20.0,0);

        Mockito.verify(calcService,atLeast(1)).subtract(20.0,10.0);
    }

    @Test
    public void testMultiply()
    {
        when(calcService.multiply(10.0,10.0)).thenReturn(100.0);
        when(calcService.multiply(30.0,10.0)).thenReturn(300.0);

        Assert.assertEquals(mathApplication.multiply(10.0,10.0),100.0,0);
        Assert.assertEquals(mathApplication.multiply(30.0,10.0),300.0,0);

        Mockito.verify(calcService,atLeast(1)).multiply(10.0,10.0);
    }

    @Test
    public void testDivide()
    {
        when(calcService.divide(20.0,10.0)).thenReturn(2.0);
        when(calcService.divide(30.0,10.0)).thenReturn(3.0);

        Assert.assertEquals(mathApplication.divide(20.0,10.0),2.0,0);
        Assert.assertEquals(mathApplication.divide(30.0,10.0),3.0,0);

        Mockito.verify(calcService,atLeast(1)).divide(20.0,10.0);
    }

}
