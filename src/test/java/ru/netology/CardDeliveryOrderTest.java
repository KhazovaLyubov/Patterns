package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardDeliveryOrderTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void validCityNameDateAndPhoneNumber(){
        CardDeliveryOrder user = DataGenerator.GenerateObjects.generateCardowner("ru");
        $("[class='input__inner'] [type='text']").setValue(user.getCity());
        $("[class='input__box'] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[class='input__box'] [placeholder='Дата встречи']").setValue(DataGenerator.generateDateOfMeeting(5));
        $("[data-test-id=name] input.input__control").setValue(user.getName());
        $("[class='input__box'] [name='phone']").setValue(user.getPhoneNumber());
        $("[data-test-id=agreement]").click();
        $("[class='button__content'] [class='button__text']").click();
        $("[data-test-id=success-notification]").waitUntil(Condition.visible, 15000).shouldHave(exactText("Успешно! Встреча успешно запланирована на " + DataGenerator.generateDateOfMeeting(5)));
        $("[class='input__box'] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[class='input__box'] [placeholder='Дата встречи']").setValue(DataGenerator.generateDateOfMeeting(3));
        $("[class='button__content'] [class='button__text']").click();
        $(byText("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $(".notification_has-closer .button").click();
        $("[data-test-id=success-notification]").waitUntil(Condition.visible, 15000).shouldHave(exactText("Успешно! Встреча успешно запланирована на " + DataGenerator.generateDateOfMeeting(3)));
    }
    }


