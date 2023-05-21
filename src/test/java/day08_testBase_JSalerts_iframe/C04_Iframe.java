package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Iframe  extends TestBase {

    /*       1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
           2 ) Bir metod olusturun: iframeTest
   - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
           - Text Box’a “Merhaba Dunya!” yazin.
   - TextBox’in altinda bulunan “Elemental Selenium” linkini
      textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin

      .*/
    @Test
    public void test01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe" );

        WebElement iframeyazıelementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeyazıelementi.isEnabled());
        System.out.println(iframeyazıelementi.getText());

        // önce iframe  e gıdıp öyle yazabiliriz
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);

        // sonra textboz a gıdıp orayı temızleyıp mesajı yollaıcaz
        WebElement textboxelementı= driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);

        textboxelementı.clear();
        textboxelementı.sendKeys("Merhaba Dünya");
        /*
            iframe'e gecis yapilinca
            driver'i oradan cikis yaptirana kadar driver iframe'in icinde kalir
            driver.switchTo().parentFrame() : ic ice birden fazla iframe varsa, bir uste cikar
            driver.switchTo().defaultContent() : direk anasayfaya cikar
         */

       // bu yuzden burda parent ile bi dısarı cıkıp elementalı bulup test edeıyrz
        driver.switchTo().parentFrame();
        WebElement elementalSeleniumLinki= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
        System.out.println(elementalSeleniumLinki.getText());
        Thread.sleep(5000);
    }
}
