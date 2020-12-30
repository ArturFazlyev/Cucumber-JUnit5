import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Elements {

    public void mailButton() {
        $(By.xpath("//a[contains(text(),'Почта')]")).shouldBe(Condition.visible);

    }

    public void searchButtonFirstButton() {
        $$(By.xpath("//input[@type='submit'][@name='btnK'][@value='Поиск в Google']")).get(1).shouldBe(Condition.visible);
    }

    public void searchString(String string) {
        $(By.xpath("//input[@title='Поиск']")).setValue(string);
    }

    public void searchButtonSecondButton() {
        $$(By.xpath("//input[@type='submit'][@name='btnK'][@value='Поиск в Google']")).get(0).click();
    }

    public void resultStat() {
        $(By.id("result-stats")).shouldBe(Condition.visible);

    }

    public void createAccountButton() {
        $(By.xpath("//a[contains(text(),'Создать аккаунт')]")).shouldBe(Condition.visible);
    }


}
