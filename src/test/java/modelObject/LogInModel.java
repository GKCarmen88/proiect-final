package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LogInModel {


    private String usernameName;
    private String passwordName;
    private String lostPasswordText;
    private String checkboxName;
    private int timeoutSeconds;
    private String invalidEmail;
    private String invalidPassword;
    private String validEmail;
    private String validPassword;
    private int expectedInputFieldCount;



//o comentez sa vad daca merge cu varianta de jos
//    public LogInModel(String relativeJsonPath, int expectedInputFieldCount) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.readerForUpdating(this)
//                    .readValue(new File(relativeJsonPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Eroar reading the JSON file: " + relativeJsonPath);
//        }
//
//    }

    public LogInModel(String relativeJsonPath, int expectedInputFieldCount) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this)
                    .readValue(new File(relativeJsonPath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading the JSON file: " + relativeJsonPath);
        }
        this.expectedInputFieldCount = expectedInputFieldCount;
    }


    public int getExpectedInputFieldCount() {
        return expectedInputFieldCount;
    }

    public void setExpectedInputFieldCount(int count) {
        this.expectedInputFieldCount = count;
    }

    public String getUsernameName() {
        return usernameName;
    }

    public void setUsernameName(String usernameName) {
        this.usernameName = usernameName;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    public String getLostPasswordText() {
        return lostPasswordText;
    }

    public void setLostPasswordText(String lostPasswordText) {
        this.lostPasswordText = lostPasswordText;
    }

    public int getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(int timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    public String getValidEmail() {
        return validEmail;
    }

    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    public String getValidPassword() {
        return validPassword;
    }

    public void setValidPassword(String validPassword) {
        this.validPassword = validPassword;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public void setInvalidPassword(String invalidPassword) {
        this.invalidPassword = invalidPassword;
    }

    public String getCheckboxName() {
        return checkboxName;
    }

    public void setCheckboxName(String checkboxName) {
        this.checkboxName = checkboxName;
    }
}

