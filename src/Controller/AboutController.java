package Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Duration;



public class AboutController{

    @FXML
    Button authenticbutton, returnbutton, deliverybutton;

    @FXML
    ShopController shopController = null;

   
    @FXML
    private void initialize() {
        authenticbutton.setOnAction(event -> showAlertMessage("100% Authentic at Paw", "Shop with confidence knowing that all our products are 100% authentic."));
        returnbutton.setOnAction(event -> showAlertMessage("15 Days Return at Paw", "We offer a hassle-free 15-day return policy. If you're not satisfied with your purchase, you can return it within 15 days."));
        deliverybutton.setOnAction(event -> showAlertMessage("Guaranteed Delivery at Paw", "Experience guaranteed delivery with our reliable shipping services. We ensure your order reaches you on time."));
    }

    @FXML
    private void showAlertMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(title);
        alert.setContentText(message);

        Image icon = new Image(getClass().getResourceAsStream("/Images/info.png"));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(40);
        iconView.setFitHeight(40);
        alert.setGraphic(iconView);
        alert.showAndWait();
    }

    @FXML
    public void gotoHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Home.fxml"));
        Parent root = loader.load();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoAbout(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/About.fxml"));
        Parent root = loader.load();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void gotoShop(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to proceed? There is no going back!");


        Image icon = new Image(getClass().getResourceAsStream("/Images/cart.png"));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(50);
        iconView.setFitHeight(50);
        alert.setGraphic(iconView);

        try {
            File soundFile = new File("src/Images/bark.mp3");
            String soundUrl = soundFile.toURI().toURL().toString();
            AudioClip sound = new AudioClip(soundUrl);
            sound.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ShopProducts.fxml"));
           Parent root = loader.load();
           shopController = loader.getController();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
        
        }
    }

    public void gotoProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Profile.fxml"));
        Parent root = loader.load();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

     @FXML
    public void gotoBlog(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Webview.fxml"));
        Parent root = loader.load();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoLogin(ActionEvent event) throws IOException {
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Sign Out");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to sign out?");

        Image icon = new Image(getClass().getResourceAsStream("/Images/logout.png"));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(50);
        iconView.setFitHeight(50);
        confirmation.setGraphic(iconView);

        confirmation.showAndWait();

        if (confirmation.getResult() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Signin.fxml"));
            Parent root = loader.load();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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

    //go to viber
    @FXML
    void gotoVIBER(ActionEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://www.viber.com/en/?utm_source=invite&utm_Medium=share&utm_campaign=msgtest"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    //go to maps
    @FXML
    void gotoMAP(ActionEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://goo.gl/maps/FUXcxBuciYpN3BYs9"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
