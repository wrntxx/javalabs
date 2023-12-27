import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import com.education.ztu.Calculator;
import com.education.ztu.CalculatorService;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private Calculator mockCalculator;

    @Spy
    private Calculator spyCalculator;

    @Captor
    private ArgumentCaptor<Double> doubleCaptor;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    public void testAdd() {
        lenient().when(mockCalculator.add(2, 3)).thenReturn(5);

        int result = mockCalculator.add(2, 3);

        verify(mockCalculator).add(2, 3);
        Assert.assertEquals(5, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        doThrow(new IllegalArgumentException("Cannot divide by zero")).when(mockCalculator).divide(10, 0);

        mockCalculator.divide(10, 0);
    }

    @Test
    public void testMultiply() {
        doReturn(15).when(spyCalculator).multiply(3, 5);

        int result = spyCalculator.multiply(3, 5);

        verify(spyCalculator).multiply(3, 5);
        Assert.assertEquals(15, result);
    }

    @Test
    public void testCalculatorService() {
        lenient().when(mockCalculator.add(2, 3)).thenReturn(5);
        lenient().when(mockCalculator.subtract(5, 2)).thenReturn(3);

        int result = calculatorService.calculate(2, 3, 5, 2);

        Assert.assertEquals(8, result);
    }
}
