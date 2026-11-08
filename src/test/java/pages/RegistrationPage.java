package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationPage {
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

    public RegistrationPage openPage() {
        step("Открываем страницу " + FORM_REGISTRATION, () ->
            open(FORM_REGISTRATION)
        );
        step("Провеяем что попали на " + FORM_REGISTRATION, () ->
        practiceFormWrapperInput.shouldHave(text(TITLE_TEXT)));
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        step("Вводим имя " + value, () ->
                firstNameInput.setValue(value)
        );
        return this;
    }
    public RegistrationPage setLastName(String value) {
        step("Вводим фамилию " + value, () ->
                lastNameInput.setValue(value));
        return this;
    }
    public RegistrationPage setEmailUser(String value) {
        step("Вводим email " + value, () ->
        userMailInput.setValue(value));
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        step("Вводим номер " + value, () ->
        userNumberInput.setValue(value));
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        step("Вводим адрес " + value, () ->
        currentAddressInput.setValue(value));
        return this;
    }
    public RegistrationPage setGender(String value) {
        step("Выбираем пол " + value, () ->
        $(byText(value)).click());
        return this;
    }
    public RegistrationPage setAllHobbies(String... values) {
        for (String value : values) {
            step("Выбираем хобби " + value, () ->
            hobbiesWrapperInput.$(byText(value)).click());
        }
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        step("Выбирем день рождение " +day+"."+month+"."+year, () -> {
                    dateOfBirthInput.click();
                    calendarComponents.setDate(day, month, year);});
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
        step("Выбирем предмет " + value, () ->
        subjectsInput.setValue(value).pressEnter());
        return this;
    }
    public RegistrationPage setUploadPicture() {
        step("Загружаем картинку", () ->
        pictureInput.uploadFromClasspath("img/1.jpg"));
        return this;
    }
    public RegistrationPage setState(String state, String city) {
        step("Выбирем город и страну " + state + "/" + city, () -> {
            stateInput.click();
            stateCityInput.$(byText(state)).click();
            cityInput.click();
            stateCityInput.$(byText(city)).click();});
        return this;

    }
    public void setSubmit () {
        step("Нажимаем кнопку завершения", () ->
        submitInput.click());
    }
}