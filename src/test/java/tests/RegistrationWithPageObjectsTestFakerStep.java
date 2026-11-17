package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import net.datafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageStep;

@Tag("positive")
public class RegistrationWithPageObjectsTestFakerStep extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageStep registrationPageStep = new RegistrationPageStep();
    Faker faker = new Faker();




    @Tag("positive")
    @Test
    @Feature("Авторизация")
    @Story("Вход с валидными данными")
    @Owner("aleksey_qa")
    @Link(name = "Homework", url = "https://demoqa.com/automation-practice-form")
    void succesfullRegistration() {

        /// strings
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userMail = faker.internet().emailAddress();
        String userNumber = faker.number().digits(10);
        String currentAddress = faker.address().streetAddress();
        registrationPageStep.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailUser(userMail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)
                .setGender("Male")
                .setAllHobbies("Sports")
                .setBirthDate("19","February","2001")
                .setSubjectInput("Maths")
                .setUploadPicture()
                .setState("NCR","Delhi")
                .setSubmit();
        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth","19 February,2001" )
                .verifyResult("Address", currentAddress);
    }


    @Tag("negative")
    @Test
    @Feature("Авторизация")
    @Story("Вход с невалидными данными")
    @Owner("aleksey_qa")
    @Link(name = "Homework", url = "https://demoqa.com/automation-practice-form")
    void failedRegistration() {

        /// strings
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userMail = faker.internet().emailAddress();
        String userNumber = faker.number().digits(9);
        String currentAddress = faker.address().streetAddress();
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailUser(userMail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)
                .setGender("Male")
                .setAllHobbies("Sports")
                .setBirthDate("19","February","2001")
                .setSubjectInput("Maths")
                .setUploadPicture()
                .setState("NCR","Delhi")
                .setSubmit();
        registrationPage.verifyNegativeResultsModal();

    }
}