package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectsTestFakerStep extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    @Test
    void succesfullRegistration() {

        /// strings
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userMail = faker.internet().emailAddress();
        String userNumber = faker.number().digits(10);
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
        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth","19 February,2001" )
                .verifyResult("Address", currentAddress);

    }
    @Test
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
        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userMail)
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth","19 February,2001" )
                .verifyResult("Address", currentAddress);

    }
}