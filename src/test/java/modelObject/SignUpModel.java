package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SignUpModel {


    private String emailValue  = "carmentest" + System.currentTimeMillis() + "@gmail.com";
    private String passwordValue = "T3st1234!2025";
    private String expectedEmptyFormError = "Error: Please provide a valid email address.";
    private String expectedAlreadyRegisteredError = "Error: An account is already registered with your email address. Please login.";
    private String registeredEmail = "carmentest@gmail.com";
    private String registeredPassword = "T3st1234!2025";

    public SignUpModel(String relativeJsonPath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readerForUpdating(this).readValue(new File(relativeJsonPath));
            // Suprascrie emailValue cu unul generat dinamic
            this.emailValue = "carmentest" + System.currentTimeMillis() + "@gmail.com";
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la citirea JSON-ului: " + relativeJsonPath);
        }
    }


    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getExpectedEmptyFormError() {
        return expectedEmptyFormError;
    }

    public void setExpectedEmptyFormError(String expectedEmptyFormError) {
        this.expectedEmptyFormError = expectedEmptyFormError;
    }

    public String getExpectedAlreadyRegisteredError() {
        return expectedAlreadyRegisteredError;
    }

    public void setExpectedAlreadyRegisteredError(String expectedAlreadyRegisteredError) {
        this.expectedAlreadyRegisteredError = expectedAlreadyRegisteredError;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public void setRegisteredPassword(String registeredPassword) {
        this.registeredPassword = registeredPassword;
    }
}

