package com.Gmail;

import com.Base.TestBase;
import com.Utilities.excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class SendMail extends TestBase {
    @Test
    public void TestCase_001() throws InterruptedException, IOException {

        //Excel implementation
        Xls_Reader reader = new Xls_Reader("./src/main/java/resources/LoginData.xlsx");
        String sheetName = "Sheet1";

        int rowCount = reader.getRowCount(sheetName);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String email1 = reader.getCellData(sheetName, "Data", rowNum);
            String pass1 = reader.getCellData(sheetName, "Data", rowNum);
            captureScreenshot(driver,"OpenLoginPage");

            driver.findElement(By.id("identifierId")).sendKeys(email1);
            captureScreenshot(driver,"EmailType");
            driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-vQzf8d")).click();
            driver.findElement(By.name("password")).sendKeys(pass1);
            captureScreenshot(driver,"password Type");
            driver.findElement(By.name("password")).click();
            driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-vQzf8d")).click();

            {
                WebElement element = driver.findElement(By.cssSelector(".T-I-KE"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            driver.findElement(By.cssSelector(".T-I-KE")).click();
            driver.findElement(By.name("to")).sendKeys("muntasir.abdullah01@gmail.com");
            captureScreenshot(driver,"mail Recipient added");
            driver.findElement(By.name("subjectbox")).click();
            driver.findElement(By.name("subjectbox")).sendKeys("Test 2");
            captureScreenshot(driver,"Email Send success");

            //File upload
            driver.findElement(By.cssSelector("#\\:t4")).sendKeys("./src/test/Files/MyFile.docx");
            Thread.sleep(5000);
            driver.findElement(By.id(":sr")).click();
            {
                WebElement element = driver.findElement(By.id(":sr"));
                js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'Test 2<br>'}", element);
            }
            captureScreenshot(driver,"File uploaded");
            driver.findElement(By.id(":rc")).click();

        }
    }
}
