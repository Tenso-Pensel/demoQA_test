package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class RegistrationWithPageObjectsTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        // Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void succesfullRegistration() {

        /// strings
        String firstName = "Lexa";
        String lastName = "Gerasimov";
        String userMail = "Lexa@gera.ru";
        String userNumber = "7904444444";
        String currentAddress = "Gerasim 12/12";
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
        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth","19 February,2001" )
                .verifyResult("Address", currentAddress);

    }
}