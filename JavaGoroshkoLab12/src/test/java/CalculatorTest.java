import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

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
        when(mockCalculator.add(2, 3)).thenReturn(5);

        int result = mockCalculator.add(2, 3);

        verify(mockCalculator).add(2, 3);
        assertEquals(5, result);
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
        assertEquals(15, result);
    }

    @Test
    public void testCalculatorService() {
        when(mockCalculator.add(2, 3)).thenReturn(5);
        when(mockCalculator.subtract(5, 2)).thenReturn(3);

        int result = calculatorService.calculate(2, 3, 5, 2);

        verify(mockCalculator).add(2, 3);
        verify(mockCalculator).subtract(5, 2);
        assertEquals(8, result);
    }
}
