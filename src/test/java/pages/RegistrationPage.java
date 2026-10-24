package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstname"),
            lastNameInput = $("#lastname"),
            userMailInput = $("# userMail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmailUser(String value) {
        userMailInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender() {
        $("#gender-radio-1").click();
        return this;
    }
    public RegistrationPage setAllHobbies() {
        $("#hobbies-checkbox-3").click();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        return this;
    }
}