import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;


import java.io.File;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {
    @BeforeAll
    static void beforeall() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        // Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void afterAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void RegistrationTests() {


        /// strings
        String firstName = "Lexa";
        String lastName = "Gerasimov";
        String userMail = "Lexa@gera.ru";
        String userNumber = "79044444444";
        String currentAddress = "Gerasim 12/12";

        ///open
        open("/automation-practice-form");
        ///
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userMail);
        $("#userNumber").setValue(userNumber);
        $("#currentAddress").setValue(currentAddress);
        $("#gender-radio-1").click();

        $("#hobbies-checkbox-3").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-1").click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2001");
//<div class="react-datepicker__day react-datepicker__day--001 react-datepicker__day--weekend" February 1st, 2026"
//<div class="react-datepicker__day react-datepicker__day--001 react-datepicker__day--weekend react-datepicker__day--outside-month" March 1st, 2026"
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

       // $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#uploadPicture").uploadFromClasspath("img/1.jpg");

        $("#stateCity-wrapper").$(byText("NSR")).click();





    }
}