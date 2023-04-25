package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void TestNameVerifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //Hover over electronic
        mouseHoverToElement(By.linkText("Electronics"));
        //click on cell phone
        mouseHoverAndClickOnElement(By.linkText("Cell phones"));
        //Verify the text “Cell phones”
        isTextDisplayed(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");

    }

    @Test
    public void TestNameVerifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Hover over electronic
        mouseHoverToElement(By.linkText("Electronics"));
        //click on cell phone
        mouseHoverAndClickOnElement(By.linkText("Cell phones"));
        //Verify the text “Cell phones”
        isTextDisplayed(By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones");
        Thread.sleep(1000);
        // Click on List View Tab
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        Thread.sleep(1000);
        //Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.linkText("Nokia Lumia 1020"));
        //Verify the text “Nokia Lumia 1020”
        isTextDisplayed(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]"), "“Nokia Lumia 1020");
        //Verify the price “$349.00”
        isTextDisplayed(By.xpath("//span[@id='price-value-20']"), "$349.00");
       // Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
        //Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        isTextDisplayed(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.linkText("Shopping cart"));
        clickOnElement(By.linkText("GO TO CART"));
       //verify the message "Shopping cart"
        isTextDisplayed(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        //Verify the quantity is 2
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedText1 = "2";
        String actualText2 = text.getAttribute("value");
        Assert.assertEquals("not equal", expectedText1, actualText2);
        //Verify the Total $698.00
        isTextDisplayed(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");
       //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);
        //Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //Verify the Text “Welcome, Please Sign In!”
        isTextDisplayed(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        // Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //Verify the text “Register”
        isTextDisplayed(By.xpath("//h1[text()='Register']"),"Register");
        //Fill the mandatory fields
        Thread.sleep(1000);
        //Enter First Name
        sendTextToElement(By.name("FirstName"), "ram");
        //Enter Last Name
        sendTextToElement(By.id("LastName"), "sita");
        //Enter Email
        sendTextToElement(By.id("Email"), "ramsita@gmail.com");
        //Enter Password
        sendTextToElement(By.name("Password"), "ramsita123");
        //Enter Confirm password
        sendTextToElement(By.name("ConfirmPassword"), "ramsita123");
        //Click on “REGISTER” Button
        clickOnElement(By.name("register-button"));
        //Verify the message “Your registration completed”
        isTextDisplayed(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");
        //Click on “CONTINUE” tab
        clickOnElement(By.linkText("CONTINUE"));
        //Verify the text “Shopping cart”
        isTextDisplayed(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // Click on “CHECKOUT”
        clickOnElement(By.linkText("CHECKOUT"));
        //Fill the Mandatory fields

        selectByVisibleTextFromDropDown(By.linkText("Country"),"India");
        selectByVisibleTextFromDropDown(By.id("City"), "Anand");
        sendTextToElement(By.id("Address 1"), "31 swaminarayan society");
        sendTextToElement(By.id("Zip / postal code"), "387115");
        sendTextToElement(By.id("Phone number"), "0091995873690");
        //Click on “CONTINUE”
        clickOnElement(By.linkText("“CONTINUE"));
        //Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.linkText("2nd Day Air ($0.00)"));
        //Click on “CONTINUE”
        clickOnElement(By.linkText("CONTINUE"));
        // Select Radio Button “Credit Card”
        clickOnElement(By.linkText("Credit Card"));
        //Click on “CONTINUE”
        clickOnElement(By.linkText("CONTINUE"));
        //Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mrs SITA PATEL");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        // Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        isTextDisplayed(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        // Verify “Shipping Method” is “2nd Day Air”
        isTextDisplayed(By.xpath("//li[@class='shipping-method']/span[@class='value']"),"2nd Day Air");
        // Verify Total is “$698.00”
        isTextDisplayed(By.xpath("//tbody/tr[1]/td[6]/span[1]"),"$698.00");
        // Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // Verify the Text “Thank You”
        isTextDisplayed(By.xpath("//h1[text()='Thank you']"),"Thank you");
        // Verify the message “Your order has been successfully processed!”
        isTextDisplayed(By.xpath("//strong[text()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // Verify the text “Welcome to our store”
        isTextDisplayed(By.xpath("//h2[text()='Welcome to our store']"),"Welcome to our store");
         // Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        // Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        //Actual Message
        String actualMessage17 = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage17,actualMessage17);
    }

   /* @After
    public void tearClose(){
        closeBrowser();*/

}

