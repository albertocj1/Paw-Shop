package Controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.User;
import Model.UserRepository;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignupController {

    @FXML
    private TextField usernameTF, numberTF, emailTF, nameTF;

    @FXML
    private PasswordField passwordPF;

    @FXML
    private Button signupBT;

    @FXML
    private Label mywarninglabel1, mywarninglabel2, mywarninglabel3, mywarninglabel4;

    private UserRepository userRepository;


    Parent root;

    FXMLLoader loader;

    @FXML
    SigninController signinController = null;
    
    public void initialize() {
        userRepository = UserRepository.getInstance();
    }

    public void signup(ActionEvent event) throws IOException {
        String username = usernameTF.getText();
        String number = numberTF.getText();
        String email = emailTF.getText();
        String password = passwordPF.getText();
        String name = nameTF.getText();
        
        boolean validationsPassed = true;

        if (!isValidUsername(username)) {
            mywarninglabel1.setText("Username should contain both letters and numbers.");
            mywarninglabel1.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel1.setVisible(false);
        }
        
        if (!isValidNumber(number)) {
            mywarninglabel2.setText("Number should contain exactly 11 digits.");
            mywarninglabel2.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel2.setVisible(false);
        }
        
        if (!isValidEmail(email)) {
            mywarninglabel3.setText("Email should end with '@gmail.com'.");
            mywarninglabel3.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel3.setVisible(false);
        }
        
        if (!isValidPassword(password)) {
            mywarninglabel4.setText("Password should contain one number and special character.");
            mywarninglabel4.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel4.setVisible(false);
        }

        if (validationsPassed) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Signin.fxml"));
            Parent root = loader.load();
            signinController = loader.getController();

            User newUser = new User(username, email, number, name, password);
            User user = new User(username, email, number, name, password);
            userRepository.addUser(user);
            
            signinController.setSignupUser(newUser);

            

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }   

    private boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).+$");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean isValidNumber(String number) {
        return number.matches("^\\d{11}$");
    }

    private boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[^a-zA-Z\\d\\s]).+$");
    }

      //go to fb
    @FXML
    void gotoFB(ActionEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.facebook.com/people/Paw/100093524298470/"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //go to gmail
    @FXML
    void gotoGMAIL(ActionEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?fs=1&to=pawpetshop.ph@gmail.com&su=SUBJECT&body=BODY&bcc=pawpetshop.ph@gmail.com&tf=cm"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //go to ig
    @FXML
    void gotoIG(ActionEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.instagram.com/pawpetshop_ph/"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
