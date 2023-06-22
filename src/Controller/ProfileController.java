package Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import Model.User;
import Model.UserRepository;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProfileController {
    @FXML
    ImageView imageView;

    @FXML
    StackPane stackPane;

    @FXML
    Label usernameLabel, nameLabel, emailLabel, numberLabel;

    @FXML
    Button save, edit;

    @FXML
    Button nextimage;

    @FXML
    ShopController shopController = null;

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<Integer> dayComboBox;

    @FXML
    private ComboBox<Integer> yearComboBox;

    BlogController blogController = null;

    private UserRepository userRepository;

    public void initialize() {

        userRepository = UserRepository.getInstance();
        ArrayList<User> userList = userRepository.getUserList();

        if (!userList.isEmpty()) {
            User user = userList.get(0); 
            updateLabels(user);
        }
    }

    private void updateLabels(User user) {
        usernameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
        numberLabel.setText(user.getNumber());
        nameLabel.setText(user.getName());
    }


    //STACK PANE CONTROL
    private int currentPictureIndex = 0;

    private final Image[] pictures = { 
        new Image("Images/avatar1.png"),
        new Image("Images/avatar2.png"),
        new Image("Images/avatar3.png"),
        new Image("Images/avatar4.png")
    };

    @FXML
    private void nextimage(ActionEvent event) {

        if (currentPictureIndex >= 0 && currentPictureIndex < pictures.length) {
            ImageView previousImageView = (ImageView) stackPane.getChildren().get(currentPictureIndex);
            previousImageView.setVisible(false);
        }
        currentPictureIndex = (currentPictureIndex + 3) % pictures.length;
    
        ImageView nextImageView = (ImageView) stackPane.getChildren().get(currentPictureIndex);
        nextImageView.setVisible(true);
    }
    
    public void gotoHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/About.fxml"));
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

    @FXML
    public void gotoBlog(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Webview.fxml"));
          Parent root = loader.load();
          blogController = loader.getController();

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

    public void setProfileData(ArrayList<String> profileData) {
    if (profileData.size() >= 4) {
        String username = profileData.get(0);
        String name = profileData.get(1);
        String email = profileData.get(2);
        String number = profileData.get(3);

        usernameLabel.setText(username);
        nameLabel.setText(name);
        emailLabel.setText(email);
        numberLabel.setText(number);
    }
}


}
