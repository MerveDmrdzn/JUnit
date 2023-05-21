package day10_actionsClass_faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Paths.get;

public class C06_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz

        System.out.println(System.getProperty("user.dir")); // projenın dosya yolunu verir
        //C:\Users\KUANTUM BILGISAYAR\IdeaProjects\com.Team113JUnit
        System.out.println(System.getProperty("user.home")); // dosya yolu herkeste değişen kısım
        //C:\Users\KUANTUM BILGISAYAR

        /* biz Downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz
            /Users/ahmetbulutluoz                        /Downloads/foto.png
            herkesin bilgisayarinda farkli               herkeste ayni
            System.getProperty("user.home")              /Downloads/foto.png
         */

        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        String dosyaYoluherkesteAyniOlanKisim = " /Downloads/logo.png ";

        String dosyaYolu= dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        // ayni islemi projemizin altindaki deneme.txt icin yapsak
        // src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt

        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluherkesteAyniOlanKisim ="/src/test/java/day10_actionsClass_faker_FileTestleri/deneme";
        dosyaYolu= dosyaYoluDegisenKisim+dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(get(dosyaYolu)));

    }
}
