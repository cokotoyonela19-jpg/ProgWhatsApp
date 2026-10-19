/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progwhatsapp;

/**
 *
 * @author user
 */
import java.util.Objects;
import com.mycompany.progwhatsapp.Login;
/**
 * Stores registration details and provides registration and login validation.
 */
public class Login {

    private static final String USERNAME_ERROR
            = "Username is not correctly formatted; please ensure that your username "
            + "contains an underscore and is no more than five characters in length.";

    private static final String PASSWORD_ERROR
            = "Password is not correctly formatted; please ensure that the password "
            + "contains at least eight characters, a capital letter, a number, "
            + "and a special character.";

    private static final String CELL_PHONE_ERROR
            = "Cell phone number is incorrectly formatted or does not contain "
            + "an international code.";

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhone;

    private boolean registered;
    private boolean lastLoginSuccessful;

    /**
     * Default constructor.
     */
    public Login() {
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.cellPhone = "";
    }

    /**
     * Constructor used to create a user with registration details.
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param username the user's username
     * @param password the user's password
     * @param cellPhone the user's cellphone number
     */
    public Login(String firstName, String lastName, String username,
            String password, String cellPhone) {

        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setCellPhone(cellPhone);
    }

    /**
     * Checks whether the username contains an underscore and is no longer
     * than five characters.
     *
     * @return true if the username is correctly formatted
     */
    public boolean checkUserName() {
        return username.contains("_")
                && username.length() <= 5;
    }

    /**
     * Checks whether the password meets the required complexity rules:
     * at least eight characters, a capital letter, a number and a special
     * character.
     *
     * @return true if the password is correctly formatted
     */
    public boolean checkPasswordComplexity() {
        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^A-Za-z0-9\\s].*");
    }

    /**
     * Checks whether the cellphone number starts with an international code
     * and contains no more than ten digits after the country code.
     *
     * Regex syntax reference:
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html
     *
     * @return true if the cellphone number is correctly formatted
     */
    public boolean checkCellPhoneNumber() {
        String cellPhoneRegex = "^\\+\\d{1,3}\\d{1,10}$";
        return cellPhone.matches(cellPhoneRegex);
    }

    /**
     * Validates all registration details.
     *
     * @return the appropriate registration message
     */
    public String registerUser() {
        registered = false;

        if (!checkUserName()) {
            return USERNAME_ERROR;
        }

        if (!checkPasswordComplexity()) {
            return PASSWORD_ERROR;
        }

        if (!checkCellPhoneNumber()) {
            return CELL_PHONE_ERROR;
        }

        registered = true;
        return "User successfully registered.";
    }

    /**
     * Compares entered login details with the stored registration details.
     *
     * @param enteredUsername the username entered during login
     * @param enteredPassword the password entered during login
     * @return true if the login details match
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        lastLoginSuccessful = Objects.equals(username, enteredUsername)
                && Objects.equals(password, enteredPassword);

        return lastLoginSuccessful;
    }

    /**
     * Returns the correct login status message.
     *
     * @param loginStatus the result of the login attempt
     * @return a welcome or error message
     */
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";
        }

        return "Username or password incorrect, please try again.";
    }

    /**
     * Returns the result of the most recent login attempt.
     *
     * @return true if the last login was successful
     */
    public boolean loginUser() {
        return lastLoginSuccessful;
    }

    /**
     * Returns the status message for the most recent login attempt.
     *
     * @return the latest login status message
     */
    public String returnLoginStatus() {
        return returnLoginStatus(lastLoginSuccessful);
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setFirstName(String firstName) {
        this.firstName = cleanValue(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = cleanValue(lastName);
    }

    public void setUsername(String username) {
        this.username = cleanValue(username);
    }

    public void setPassword(String password) {
        this.password = cleanValue(password);
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cleanValue(cellPhone);
    }

    private String cleanValue(String value) {
        return value == null ? "" : value.trim();
    }
    
}
