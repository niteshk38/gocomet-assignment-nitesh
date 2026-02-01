package com.gocomet.tests.login;

import com.gocomet.framework.base.BaseTest;
import com.gocomet.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPass extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                loginPage.getMessage().contains("You logged into a secure area"),
                "Valid login failed"
        );
    }
}
