package com.Gmail;

import com.Base.TestBase;
import com.Utilities.excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReceiveMail extends TestBase {
    @Test
    public void TestCase_002() throws InterruptedException, IOException {

        //Excel implementation
        Xls_Reader reader = new Xls_Reader("./src/main/java/resources/LoginData.xlsx");
        String sheetName = "Sheet1";

        int rowCount = reader.getRowCount(sheetName);

        for (int rowNum = 3; rowNum <= rowCount; rowNum++) {
            String email2 = reader.getCellData(sheetName, "Data", rowNum);
            String pass2 = reader.getCellData(sheetName, "Data", rowNum);

            driver.findElement(By.id("identifierId")).sendKeys(email2);
            driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-vQzf8d")).click();
            driver.findElement(By.name("password")).sendKeys(pass2);
            driver.findElement(By.name("password")).click();
            driver.findElement(By.cssSelector(".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-vQzf8d")).click();
            {
                WebElement element = driver.findElement(By.cssSelector(".T-I-KE"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            driver.findElement(By.cssSelector(".T-I-KE")).click();
            driver.findElement(By.name("to")).sendKeys("muntasir.abdullah01@gmail.com");

            //Download
            WebElement inboxEmail = driver.findElement(By.name("megher dolopoti"));
            inboxEmail.click();
            WebElement downloadButton = driver.findElement(By
                    .cssSelector("#\\:q4"));
            String sourceLocation = downloadButton.getAttribute("href");
            String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

            try {
                Process exec = Runtime.getRuntime().exec(wget_command);
                int exitVal = exec.waitFor();
                System.out.println("Exit value: " + exitVal);
            } catch (InterruptedException | IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
