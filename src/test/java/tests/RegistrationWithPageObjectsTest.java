package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

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
        String userNumber = "79044444444";
        String currentAddress = "Gerasim 12/12";
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailUser(userMail)
                .setUserNumber(userNumber)
                .setCurrentAddress(currentAddress);

        $("#gender-radio-1").click();

        $("#hobbies-checkbox-3").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-1").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2001");
//<div class="react-datepicker__day react-datepicker__day--001 react-datepicker__day--weekend" February 1st, 2026"
//<div class="react-datepicker__day react-datepicker__day--001 react-datepicker__day--weekend react-datepicker__day--outside-month" March 1st, 2026"
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        // $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName),text(currentAddress),text(userMail));






    }
}