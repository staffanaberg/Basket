package old;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MyStepdefs {

    private WebDriver driver;


    @Given("I am using browser {string}")
    public void iAmUsingBrowser(String browser) {
        if(browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equals("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

    }

    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String date) {
        driver.manage().window().setSize(new Dimension(1936, 1048));
        driver.findElement(By.id("dp")).sendKeys(date);
    }

    @And("I have entered first name {string}")
    public void iHaveEnteredFirstName(String first) {
        driver.findElement(By.id("member_firstname")).sendKeys(first);

    }

    @And("I have entered last name {string}")
    public void iHaveEnteredLastName(String last) {
        driver.findElement(By.id("member_lastname")).sendKeys(last);

    }

    @And("I have entered password and confirmed password")
    public void iHaveEnteredPasswordAndConfirmedPassword() {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("staffan821347@");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("staffan821347@");

    }

    @And("I have entered email and confirmed email {string}")
    public void iHaveEnteredEmailAndConfirmedEmail(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
    }

    @And("I have checked terms and conditions")
    public void iHaveCheckedTermsAndConditions() {

        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
    }

    @And("I have not checked terms and conditions")
    public void iHaveNotCheckedTermsAndConditions() {


    }


    @And("I have checked Over 18 and code of conduct")
    public void iHaveCheckedOverAndCodeOfConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();

    }

    @When("I press the join button")
    public void iPressTheJoinButton() throws InterruptedException {
        Thread.sleep(1000);

        driver.findElement(By.name("join")).click();

    }


    @Then("I am registrered")
    public void iAmRegistrered() throws InterruptedException {

        String expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        String actual = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2")).getText();

        assertEquals(expected, actual);

        driver.close();

    }

    @Then("I am not registrered and get error text {string}")
    public void iAmNotRegistreredAndGetErrorText(String expected) {

        if (expected.equals("Last Name is required")) {

            String actual = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span")).getText();
        } else {

        }
        //assertEquals(expected, actual);

        driver.close();


    }


    @Then("I am registrered and verifies registrated")
    public void iAmRegistreredAndVerifiesText() {
    }

    @Then("I am registrered and verifies missing last name")
    public void iAmLastNameAndVerifiesText() {
    }

    @Then("I am registrered and verifies missing wrong password")
    public void iAmWrongPasswordAndVerifiesText() {
    }


}
