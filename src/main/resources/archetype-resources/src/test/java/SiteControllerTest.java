package ${package};

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SiteControllerTest extends TestCase {
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SiteControllerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SiteControllerTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testSiteController() {
        assertTrue(true);
    }
    
}
