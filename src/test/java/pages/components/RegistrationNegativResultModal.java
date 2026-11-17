package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationNegativResultModal {
    @Step("Проверяем что регистрация не прошла и  окно завершения не появилось")
    public void verifyNegativeModalRegistration(){
        $(".modal-dialog").shouldNot(appear);
    }
}
