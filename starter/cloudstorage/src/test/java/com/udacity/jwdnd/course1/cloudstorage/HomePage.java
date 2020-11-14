package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "logout-button")
    private WebElement logoutButton;

    @FindBy(id = "nav-notes-tab")
    private WebElement navNotes;

    @FindBy(id = "addNoteButton")
    private WebElement addNoteButton;

    @FindBy(id = "note-title")
    private WebElement titleText;

    @FindBy(id = "note-description")
    private WebElement descriptionText;

    @FindBy(id = "save-note")
    private WebElement saveNoteButton;

    @FindBy(id="delete_note")
    private WebElement deleteNoteButton;

    @FindBy(id="edit_note")
    private WebElement editNoteButton;


    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void logout() {
        this.logoutButton.click();
    }

    public void addNewNote() {
        String title = "1";
        String description = "This is test note description";
        try {
            this.navNotes.click();
            Thread.sleep(1000);
            this.addNoteButton.click();
            Thread.sleep(1000);
            this.titleText.sendKeys(title);
            this.descriptionText.sendKeys(description);
            Thread.sleep(1000);
            this.saveNoteButton.click();
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        };
    }

    public void deleteNote() {
        try {
            this.navNotes.click();
            Thread.sleep(1000);
            this.deleteNoteButton.click();
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        };
    }
    public void editNote() {
        try {
            this.navNotes.click();
            Thread.sleep(1000);
            this.editNoteButton.click();
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        };
    }
}
