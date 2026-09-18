/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */

import com.mycompany.progwhatsapp.Login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for the Login class.
 */
public class LoginTest {

               private Login createValidUser() {
        return new Login(
  "Kyle",
        "Smith",
  "kyl_1",
                "Ch&&sec@ke99!",
        "+27838968976"
        );
    }

               public void validUsernameShouldBeAccepted() {
        Login user = createValidUser();

                   assertTrue(user.checkUserName());
    }

           public void invalidUsernameShouldBeRejected() {
        
               Login user = createValidUser();
        user.setUsername("kyle!!!!!!");

           assertFalse(user.checkUserName());
    }

        public void validPasswordShouldBeAccepted() {
 Login user = createValidUser();

        assertTrue(user.checkPasswordComplexity());
    }

    public void invalidPasswordShouldBeRejected() {
       
                 Login user = createValidUser();
        user.setPassword("password");

assertFalse(user.checkPasswordComplexity());
    }

    
    public void validCellPhoneShouldBeAccepted() {
        
Login user = createValidUser();

        assertTrue(user.checkCellPhoneNumber());
    }

    
    public void invalidCellPhoneShouldBeRejected() {
        Login user = createValidUser();
        user.setCellPhone("08966553");

        assertFalse(user.checkCellPhoneNumber());
    }


    public void validRegistrationShouldReturnSuccessMessage() {
        Login user = createValidUser();

        assertEquals(
                "User successfully registered.",
                user.registerUser()
        );

        assertTrue(user.isRegistered());
    }

    
    public void invalidUsernameShouldReturnCorrectRegistrationMessage() {
        Login user = createValidUser();
        user.setUsername("kyle!!!!!!");

        assertEquals(
                "Username is not correctly formatted; please ensure that your "
                + "username contains an underscore and is no more than five "
                + "characters in length.",
                user.registerUser()
        );

        assertFalse(user.isRegistered());
    }

    
                 public void invalidPasswordShouldReturnCorrectRegistrationMessage() {
        
                     Login user = createValidUser();
        user.setPassword("password");

        assertEquals(
                "Password is not correctly formatted; please ensure that the "
 + "password contains at least eight characters, a capital letter, "
                + "a number, and a special character.",
               
            user.registerUser()
        );

        assertFalse(user.isRegistered());
    }


    public void invalidCellPhoneShouldReturnCorrectRegistrationMessage() {
        Login user = createValidUser();
        user.setCellPhone("08966553");

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain "
                + "an international code.",
                user.registerUser()
        );

        assertFalse(user.isRegistered());
    }


    public void successfulLoginShouldReturnTrue() {
        Login user = createValidUser();

        assertTrue(user.loginUser(
                "kyl_1",
                "Ch&&sec@ke99!"
        ));
    }


                   public void failedLoginShouldReturnFalse() {
        Login user = createValidUser();

        assertFalse(user.loginUser(
               
            "wrong_username",
                "wrong_password"
        ));
    }


         public void successfulLoginShouldReturnWelcomeMessage() {
    Login user = createValidUser();

        boolean loginResult = user.loginUser(
              
            "kyl_1",
                "Ch&&sec@ke99!"
        );

        assertEquals(
               
            "Welcome Kyle, Smith it is great to see you again.",
                user.returnLoginStatus(loginResult)
        );
    }


    public void failedLoginShouldReturnErrorMessage() {
        Login user = createValidUser();

        boolean loginResult = user.loginUser(
               
            "wrong_username",
                "wrong_password"
        );

        assertEquals(
                "Username or password incorrect, please try again.",
                user.returnLoginStatus(loginResult)
        );
    }
}
