package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageStep {
    private final String FORM_REGISTRATION ="/automation-practice-form";
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



    @Step("Открываем страницу регистрации")
    public RegistrationPageStep openPage() {
        open(FORM_REGISTRATION);
        practiceFormWrapperInput.shouldHave(text(TITLE_TEXT));
        return this;
    }
    @Step ("Вводим имя {value}")
    public RegistrationPageStep setFirstName(String value) {
                firstNameInput.setValue(value);
        return this;
    }
    @Step ("Вводим фамилию {value}")
    public RegistrationPageStep setLastName(String value) {
                lastNameInput.setValue(value);
        return this;
    }
    @Step ("Вводим email {value}")
    public RegistrationPageStep setEmailUser(String value) {
        userMailInput.setValue(value);
        return this;
    }
    @Step ("Вводим  номер {value}")
    public RegistrationPageStep setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step ("Вводим адрес {value}")
    public RegistrationPageStep setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step ("Вводим пол {value}")
    public RegistrationPageStep setGender(String value) {
        $(byText(value)).click();
        return this;
    }
    @Step ("Вводим хобби {values}")
    public RegistrationPageStep setAllHobbies(String... values) {
        for (String value : values) {
            hobbiesWrapperInput.$(byText(value)).click();
        }
        return this;
    }
    @Step ("Выбирем день рождение {day}.{month}.{year}")
    public RegistrationPageStep setBirthDate(String day, String month, String year) {
                    dateOfBirthInput.click();
                    calendarComponents.setDate(day, month, year);
        return this;
    }
    public RegistrationPageStep verifyResultsModal() {
        registrationResultModal.verifyModalRegistration();
        return this;
    }
    public RegistrationPageStep verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key,value);
        return this;
    }
    @Step ("Выбирем предмет {value}")
    public RegistrationPageStep setSubjectInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    @Step ("Загружаем картинку")
    public RegistrationPageStep setUploadPicture() {
        pictureInput.uploadFromClasspath("img/1.jpg");
        return this;
    }
    @Step ("Выбирем город {city} и страну {state}")
    public RegistrationPageStep setState(String state, String city) {
            stateInput.click();
            stateCityInput.$(byText(state)).click();
            cityInput.click();
            stateCityInput.$(byText(city)).click();
        return this;

    }
    @Step ("Нажимаем кнопку завершения")
    public void setSubmit () {
        submitInput.click();
    }
}