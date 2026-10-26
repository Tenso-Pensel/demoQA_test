package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponents calendarComponents = new CalendarComponents();
    private final String TITLE_TEXT = "Student Registration Form";
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final SelenideElement
            firstNameInput = $("#firstname"),
            lastNameInput = $("#lastname"),
            userMailInput = $("# userMail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            genderRationInput = $("#gender-radio-1");

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
    public RegistrationPage setGender(String value) {
        genderRationInput.click();
        return this;
    }
    public RegistrationPage setAllHobbies() {
        $("#hobbies-checkbox-3").click();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);
        return this;
    }
    public RegistrationPage verifyResultsModal() {
        registrationResultModal.verifyModalRegistration();
        return this;
    }
    public RegistrationPage verifyResult(String key,String value) {
        registrationResultModal.verifyResult(key,value);
        return this;
    }
}