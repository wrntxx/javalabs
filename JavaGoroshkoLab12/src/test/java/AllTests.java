import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProductTableTest.class,
        ParameterizedProductTableTest.class,
        CalculatorTest.class
})
public class AllTests {
    
}
