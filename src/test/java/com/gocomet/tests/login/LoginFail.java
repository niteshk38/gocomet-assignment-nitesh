package com.gocomet.tests.login;

import com.gocomet.framework.base.BaseTest;
import com.gocomet.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFail extends BaseTest {

    @Test
    public void loginWithInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong", "wrong");

        Assert.assertTrue(
                loginPage.getMessage().contains("Your username is invalid"),
                "Invalid login error message not shown"
        );
    }
}
