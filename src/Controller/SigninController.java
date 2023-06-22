package Controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import Model.User;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SigninController {

    @FXML
    TextField mytextfield;

    @FXML
    PasswordField mypasswordfield;

    @FXML
    Button mybutton;

    @FXML
    Label mywarninglabel;

    @FXML
    HomeImageSlideController homeImageSlideController = null;


   static User signupUser;

    public static void setSignupUser(User user) {
        signupUser = user;
    }

    public void signin(ActionEvent event) throws IOException {
        String username = mytextfield.getText();
        String password = mypasswordfield.getText();

        if (signupUser != null && username.equals(signupUser.getUsername()) && password.equals(signupUser.getPassword())) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Home.fxml"));
            Parent root = loader.load();
            homeImageSlideController = loader.getController();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            mywarninglabel.setVisible(true);
        }
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
