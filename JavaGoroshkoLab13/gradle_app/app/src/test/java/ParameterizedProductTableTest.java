import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import com.education.ztu.*;

@RunWith(Parameterized.class)
public class ParameterizedProductTableTest {
    private final String testName;
    private final int productId;
    private final String productName;
    private final double productPrice;

    public ParameterizedProductTableTest(String testName, int productId, String productName, double productPrice) {
        this.testName = testName;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Test Get Entity By Id", 1, "Apple", 4.99},
                {"Test Update Entity", 1, "Pear", 7.49},
        });
    }

    @Test
    public void testParameterizedMethods() throws Exception {
        Product product = new Product(productId, productName, productPrice);
        Assert.assertEquals(productName, product.getName());
    }
}
