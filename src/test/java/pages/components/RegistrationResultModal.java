package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegistrationResultModal {
    public void verifyModalRegistration(){
        step("Проверяем что регистрация прошла и появилось окно завершения", () -> {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));});
    }
    public void verifyResult(String key,String value){
        step("Сверяем данные с таблицей после завершения регистрации", () -> {
$(".table-responsive").$(byText(key)).parent()
        .shouldHave(text(value));});
    }
}
