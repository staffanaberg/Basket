package stepdefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class MyStepdefsHealthBook {

    private WebDriver driver;

    @Given("I have navigated to the webshop with {string} browser")
    public void iHaveNavigatedToTheWebshopWithBrowser(String browser) {

        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }


        driver.get("https://demowebshop.tricentis.com");

    }

    @And("I have searched for {string}")
    public void iHaveSearchedFor(String searchText) {
        driver.findElement(By.name("q")).sendKeys(searchText);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }

    @When("I open the {string} page")
    public void iOpenThePage(String arg0) {
        driver.findElement(By.cssSelector("a[title='Show details for Health Book']")).click();
        System.out.println(arg0);
        //hej hej
    }

    @Then("I have navigated to the page {string}")
    public void iHaveNavigatedToThePage(String expected) {
        String actual = driver.getTitle();
        assertEquals(expected,actual);
    }
}
