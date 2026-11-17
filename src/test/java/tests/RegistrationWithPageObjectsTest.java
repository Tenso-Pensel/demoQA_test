package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageStep;


public class RegistrationWithPageObjectsTest extends TestBase {
    RegistrationPageStep registrationPageStep = new RegistrationPageStep();
    RegistrationPage registrationPage = new RegistrationPage();





    @Tag("positive")
    @Test
    @Feature("Авторизация")
    @Story("Вход с валидными данными")
    @Owner("aleksey_qa")
    @Link(name = "Homework", url = "https://demoqa.com/automation-practice-form")
    void succesfullRegistration() {

        /// strings
        String firstName = "Lexa";
        String lastName = "Gerasimov";
        String userMail = "Lexa@gera.ru";
        String userNumber = "7904444444";
        String currentAddress = "Gerasim 12/12";
        registrationPageStep.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailUser(userMail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)
                .setGender("Male")
                .setAllHobbies("Sports")
                .setBirthDate("19", "February", "2001")
                .setSubjectInput("Maths")
                .setUploadPicture()
                .setState("NCR", "Delhi")
                .setSubmit();
        registrationPageStep.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "19 February,2001")
                .verifyResult("Address", currentAddress);

    }





    @Tag("negative")
    @Test
    @Feature("Авторизация")
    @Story("Вход с невалидными данными")
    @Owner("aleksey_qa")
    @Link(name = "Homework", url = "https://demoqa.com/automation-practice-form")
    void unsuccesfullRegistration() {

        /// strings
        String firstName = "Lexa";
        String lastName = "Gerasimov";
        String userMail = "Lexa@gera.ru";
        String userNumber = "790444444";
        String currentAddress = "Gerasim 12/12";
        registrationPageStep.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailUser(userMail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress)
                .setGender("Male")
                .setAllHobbies("Sports")
                .setBirthDate("19", "February", "2001")
                .setSubjectInput("Maths")
                .setUploadPicture()
                .setState("NCR", "Delhi")
                .setSubmit();
        registrationPage.verifyNegativeResultsModal();
    }
}