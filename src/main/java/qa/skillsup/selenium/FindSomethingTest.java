package qa.skillsup.selenium;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FindSomethingTest extends TestCase {
    private WebDriver driver;
    private java.lang.String baseUrl;
    private java.lang.String something = "QuickTest Professional";
    private By searchInput = By.id("searchInput");
    private By searchButton = By.id("searchButton");
    private By language = By.linkText("Русский");
    private java.lang.String firstFind = "https://en.wikipedia.org/wiki/HP_QuickTest_Professional";
    private java.lang.String secondFind = "https://ru.wikipedia.org/wiki/HP_QuickTest_Professional";

    @BeforeClass
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        baseUrl = "https://en.wikipedia.org";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testFindEn() throws Exception{
        driver.get(baseUrl);
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(something);
        driver.findElement(searchButton).click();
        assertEquals(firstFind, driver.getCurrentUrl());

        System.out.println("Title: "+driver.getTitle());
        System.out.println("Site: "+driver.getCurrentUrl());

    }

    @Test
    public void testFindRu() throws Exception{
        driver.get(baseUrl);
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(something);
        driver.findElement(searchButton).click();
        driver.findElement(language).click();

        assertEquals(secondFind, driver.getCurrentUrl());

        System.out.println("Title: "+driver.getTitle());
        System.out.println("Site: "+driver.getCurrentUrl());
    }

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }
}
