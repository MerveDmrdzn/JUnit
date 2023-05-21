package day10_actionsClass_faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsTest  {

     // com.Team113JUnit projesınde deneme dosyasının varoldugunu test edin
   @Test
    public void test01(){
       String dosyaYolu = "src/test/java/day10_actionsClass_faker_FileTestleri/deneme";
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
   }
}
