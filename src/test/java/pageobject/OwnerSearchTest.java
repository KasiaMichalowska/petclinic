package pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.page.OwnerPage;

public class OwnerSearchTest {

    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;

    private OwnerPage ownerPage;


    @Before
    public void setUp() {
     /*   driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        ownerPage = PageFactory.initElements(driver, OwnerPage.class);
        driver.get(PAGE_URL); */
    }

/*    @Test
    public void OwnerSearchTest() {
    ownerPage.clickOnOwnerLink();

    assertTrue("Owner is not found.", ownerPage.isOwnerFound());
}

    @After
    public void tearDown() {
        driver.close(); */
    }
