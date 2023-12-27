import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.junit.*;
import org.junit.rules.*;

import com.education.ztu.*;

public class ProductTableTest {
    private static Connection connection;
    private static ITable<Product> productTable;
    private static StringBuilder verificationLog = new StringBuilder();

    @Rule
    public final TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public final TestName name = new TestName();

    @Rule
    public final Timeout timeout = Timeout.seconds(2);

    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public Verifier verifier = new Verifier() {
        @Override
        protected void verify() throws Throwable {
            String verificationResult = verificationLog.toString();
            Assert.assertTrue(verificationResult.contains("Test completed successfully"));
        }
    };

    @BeforeClass
    public static void beforeClass() {
        ResourceBundle bundle = ResourceBundle.getBundle("db");

        String url = bundle.getString("db.url");
        String username = bundle.getString("db.username");
        String password = bundle.getString("db.password");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Assert.fail("Failed to establish a database connection: " + e.getMessage());
        }
    }

    @AfterClass
    public static void afterClass() {
        try {
            connection.close();
        } catch (SQLException e) {
            Assert.fail("Failed to close a database connection: " + e.getMessage());
        }
    }

    @Before
    public void setUp() {
        try {
            productTable = new ProductTable(connection);
            productTable.createTable();
        } catch (SQLException e) {
            Assert.fail("Failed to create a database table: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            productTable.deleteEntities();
        } catch (SQLException e) {
            Assert.fail("Failed to delete all enities from a database table: " + e.getMessage());
        }
    }

    @Test
    public void testTemporaryFolderRule() throws IOException {
        File tempFile = temporaryFolder.newFile("temp.txt");
        Assert.assertTrue(tempFile.exists());
        verificationLog.append("Test completed successfully");
    }

    @Test
    public void testExpectedExceptionRule() throws Exception {
        expectedException.expect(Exception.class);
        verificationLog.append("Test completed successfully");
        throw new Exception("This is an expected exception");
    }

    @Test
    public void testNameRule() {
        Assert.assertEquals("testNameRule", name.getMethodName());
        verificationLog.append("Test completed successfully");
    }

    @Test
    public void testTimeoutRule() {
        while (true);
    }

    @Test
    public void testErrorCollectorRule() {
        errorCollector.addError(new AssertionError("Error 1"));
        errorCollector.addError(new AssertionError("Error 2"));
    }

    @Test
    public void testVerifierRule() {
        verificationLog.append("Test completed successfully");
    }

    @Test
    public void testGetEntityById() throws SQLException {
        Product product = new Product(1, "Apple", 4.99);

        productTable.insertEntity(product);

        Product retrievedProduct = productTable.getEntityById(1);

        Assert.assertNotNull(retrievedProduct);
        Assert.assertSame(product.getId(), retrievedProduct.getId());
    }

    @Test
    public void testUpdateEntity() throws SQLException {
        Product product = new Product(1, "Apple", 4.99);
        productTable.insertEntity(product);

        product.setName("Pear");
        product.setPrice(7.49);
        productTable.updateEntity(product);

        Product updatedProduct = productTable.getEntityById(1);

        Assert.assertNotSame(product, updatedProduct);
        Assert.assertEquals("Pear", updatedProduct.getName());
        Assert.assertEquals(7.49, updatedProduct.getPrice(), 0.01);
    }

    @Test
    public void testDeleteEntity() throws SQLException {
        Product product = new Product(1, "Apple", 4.99);
        productTable.insertEntity(product);

        productTable.deleteEntity(1);

        Product deletedProduct = productTable.getEntityById(1);

        Assert.assertNull(deletedProduct);
    }

    @Test
    public void testGetAllEntities() throws SQLException {
        Product product1 = new Product(1, "Apple", 4.99);
        Product product2 = new Product(2, "Pear", 7.49);
        Product product3 = new Product(3, "Coconut", 19.99);
        productTable.insertEntity(product1);
        productTable.insertEntity(product2);
        productTable.insertEntity(product3);

        List<Product> allProducts = productTable.getAllEntities();

        Assert.assertEquals(3, allProducts.size());

        Assert.assertTrue(allProducts.contains(product1));
        Assert.assertTrue(allProducts.contains(product2));
        Assert.assertTrue(allProducts.contains(product3));
    }

    @Test
    @Ignore
    public void testIgnored() {
        Assert.fail("This test should be ignored");
    }
}
