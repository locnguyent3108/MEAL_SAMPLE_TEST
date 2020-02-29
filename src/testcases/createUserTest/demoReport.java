package testcases.createUserTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demoReport {

    @Test
    public void testPassCase() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFailCase() {
        Assert.assertFalse(true);
    }
}
