package com.gocomet.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(id = "flash")
    private WebElement message;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {

        if (user == null || pass == null) {
            throw new IllegalArgumentException("Username or Password is null");
        }

        wait.until(ExpectedConditions.visibilityOf(username)).clear();
        username.sendKeys(user);

        wait.until(ExpectedConditions.visibilityOf(password)).clear();
        password.sendKeys(pass);

        loginBtn.click();
    }

    public String getMessage() {
        return wait.until(
                ExpectedConditions.textToBePresentInElement(message, "")
        ) ? message.getText() : "";
    }

}
