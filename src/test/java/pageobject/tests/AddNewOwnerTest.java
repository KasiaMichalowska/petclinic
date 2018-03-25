package pageobject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.page.AddOwnerPage;
import pageobject.page.FindOwnerPage;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class AddNewOwnerTest {
    private static final String PAGE_URL = "http://localhost:8080/";

    private WebDriver driver;

    private AddOwnerPage addOwnerPage;


    @Before
    public void setUp() {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        addOwnerPage = PageFactory.initElements(driver, AddOwnerPage.class);
        driver.get(PAGE_URL);
    }

    @Test
    public void AddOwnerSuccesfullyTest() {
        addOwnerPage.addOwner("Antoni", "Antonow", "Ulica Lotników 12", "Miastko", "501234222");
        assertTrue("Owner is not added correctly.", addOwnerPage.getAddedOwnerText().contains("Antoni Antonow"));
    }

    @Test
    public void AddTheSameOwnerTest() {
        addOwnerPage.addOwner("Bartosz", "Bartkowski", "Ulica Lotników 12", "Miastko", "501234222");
        assertTrue("Owner is not added correctly.", addOwnerPage.getAddedOwnerText().contains("Bartosz Bartkowski"));
        addOwnerPage.addOwner("Bartosz", "Bartkowski", "Ulica Lotników 12", "Miastko", "501234222");
        assertTrue("There should be unique owners", addOwnerPage.isAddOwnerError());
    }

    @Test
    public void AddOwnerWithIncompleteDataTest() {
        addOwnerPage.addOwner("Cezary", "Cezarczyk", "", "Miastko", "501234222");
        assertTrue("Missing address label should appear.", addOwnerPage.isMissingAddress());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
