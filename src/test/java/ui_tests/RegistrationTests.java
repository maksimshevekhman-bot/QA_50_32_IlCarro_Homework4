package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        String uniqueEmail = "user" + System.currentTimeMillis() + "@mail.com";

        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email(uniqueEmail)
                .password("Qwerty123!")
                .build();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnSignUp();

        RegistrationPage regPage = new RegistrationPage(getDriver());
        regPage.fillRegistrationForm(user);
        regPage.submit();

        Assert.assertTrue(regPage.isSuccessDisplayed(), "Registration was successful");
    }
}