package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl ="https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void TestNameVerifyProductArrangeInAlphaBeticalOrder() throws InterruptedException{
        // Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        // Verify the Product will arrange in Descending order.
        isTextDisplayed(By.id("products-orderby"),"Name: Z to A");


    }
    @Test
    public void  TestNameVerifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
        // Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        Thread.sleep(1000);
        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        Thread.sleep(1000);
        // Verify the Product will arrange in Descending order.
        isTextDisplayed(By.id("products-orderby"),"Name: A to Z");
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        Thread.sleep(1000);
        // Verify the Text "Build your own computer"
        isTextDisplayed(By.xpath("//h1[contains(text(),'Build your own computer')]"),"Build your own compute");
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
       // Select "8GB [+$60.00]" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"),"8GB [+$60.00]");
       //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        Thread.sleep(1000);
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        clickOnElement(By.linkText("Microsoft Office [+$50.00]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]"));
        Thread.sleep(1000);
        //Verify the price "$1,475.00
        isTextDisplayed(By.xpath("//span[@id='price-value-1']"),"$1,475.00");
        // Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        isTextDisplayed(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        //Verify the message "Shopping cart"
        isTextDisplayed(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
       //Change the Qty to "2" and Click on "Update shopping cart
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
       //Verify the Total"$2,950.00"
        isTextDisplayed(By.xpath("//td[@class='subtotal']/span[text()='$2,950.00']"),"$2,950.00");
        // click on checkbox “I agree with the terms of service
        clickOnElement(By.xpath("//label[contains(text(),'I agree with the terms of service and I adhere to ')]"));
        // Click on “CHECKOUT
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //verify the Text “Welcome, Please Sign In!”
        isTextDisplayed(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Akshar");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Patel");
        sendTextToElement(By.id("BillingNewAddress_Email"), "xyz@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "29 Addison Way");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HA6 1SY");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "01234567890");
        //click on continue
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));
        //Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        //Fill all the details
        sendTextToElement(By.id("CardholderName"), "MR NO ONE");
        sendTextToElement(By.id("CardNumber"), "5100 0000 0000 0511");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "01");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2026");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        isTextDisplayed(By.xpath("//li[@class='payment-method']/span[@class='value']"),"Credit Card");
        Thread.sleep(1000);
        //Verify “Shipping Method” is “Next Day Air”
        isTextDisplayed(By.xpath("//li[@class='shipping-method']/span[@class='value']"),"Next Day Air");
        Thread.sleep(1000);
        //Verify Total is “$2,950.00"
        isTextDisplayed(By.xpath("//span[@class='product-subtotal']"),"$2,950.00");
        //Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //Verify the Text “Thank You”
        isTextDisplayed(By.xpath("//div[@class='page-title']/h1"),"Thank you");
        Thread.sleep(1000);
        //Verify the message “Your order has been successfully processed!”
        isTextDisplayed(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"),"Your order has been successfully processed!");
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //Verify the text “Welcome to our store”
        isTextDisplayed(By.xpath("//div[@class='topic-block-title']/h2"),"Welcome to our store");
        Thread.sleep(1000);
    }




   @After
    public void tearClose(){
        closeBrowser();
   }
}
