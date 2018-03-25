package pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.page.FindOwnerPage;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class OwnerSearchTest {

    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;

    private FindOwnerPage ownerPage;


    @Before
    public void setUp() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        ownerPage = PageFactory.initElements(driver, FindOwnerPage.class);
        driver.get(PAGE_URL);
    }

    @Test
    public void OwnerSearchAllTest() {
        ownerPage.searchOwner("");
        assertTrue("Owner is not found.", ownerPage.getOwnerText().contains("Peter McTavish"));
    }

    @Test
    public void FindExistingOwnerTest() {
        ownerPage.searchOwner("McTavish");
        assertTrue("Owner McTavish is not found.", ownerPage.getFoundOwnerNameText().contains("Peter McTavish"));
    }

    @Test
    public void FindNotExistingOwnerTest() {
        ownerPage.searchOwner("Non existing owner");
        assertTrue("None existing owner search failed.", ownerPage.isNoneOwnerFound());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
