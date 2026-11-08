package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPageStep;


public class RegistrationWithPageObjectsTest extends TestBase{
    RegistrationPageStep registrationPageStep = new RegistrationPageStep();
    @Test
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
                .setBirthDate("19","February","2001")
                .setSubjectInput("Maths")
                .setUploadPicture()
                .setState("NCR","Delhi")
                .setSubmit();
        registrationPageStep.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth","19 February,2001" )
                .verifyResult("Address", currentAddress);

    }
}