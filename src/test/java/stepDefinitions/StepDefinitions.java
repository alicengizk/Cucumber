package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class StepDefinitions {
    AmazonPage amazonPage;

    @Given("kullanici {string} anasayfada")
    public void kullanici_anasayfada(String anasayfa) {
        Driver.getDriver().get(ConfigReader.getProperty(anasayfa));

    }
    @Then("kullanici {string} icin arama  yapar")
    public void kullanici_icin_arama_yapar(String arananKelime) {
        amazonPage.aramaKutusu.sendKeys(arananKelime+Keys.ENTER);

    }
    @Then("sonuclarin {string} icerdigini test eder")
    public void sonuclarin_icerdigini_test_eder(String istenenKelime) {
        String actualResult=amazonPage.arananSonuc.getText();
        Assert.assertTrue(actualResult.contains(istenenKelime));

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
       Driver.closeDriver();
    }

    @Then("sayfada {int} sn bekler")
    public void sayfadaSnBekler(int bekleme) {
        try {
            Thread.sleep(bekleme);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
