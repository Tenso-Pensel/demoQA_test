package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponents calendarComponents = new CalendarComponents();
    private final String TITLE_TEXT = "Student Registration Form";
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    private final SelenideElement
            practiceFormWrapperInput = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userMailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            stateCityInput =  $("#stateCity-wrapper"),
            stateInput = $("#state"),
            cityInput  = $("#city"),
            submitInput = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormWrapperInput.shouldHave(text(TITLE_TEXT));
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
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setAllHobbies(String... values) {
        for (String value : values) {
            hobbiesWrapperInput.$(byText(value)).click();
        }
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
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
    public RegistrationPage setSubjectInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setUploadPicture() {
        pictureInput.uploadFromClasspath("img/1.jpg");
        return this;
    }
    public RegistrationPage setState(String state, String city) {
        stateInput.click();
        stateCityInput.$(byText(state)).click();
        cityInput.click();
        stateCityInput.$(byText(city)).click();
        return this;

    }
    public void setSubmit () {
        submitInput.click();
    }
}