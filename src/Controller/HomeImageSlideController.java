package Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeImageSlideController implements Initializable {

    @FXML
    ImageView image1, image2, image3, image4;

    @FXML
    Button aboutbutton, shopbutton, blogsbutton, blogsbutton1, shopnowbutton;

    @FXML
    Button cartbtn, profilebtn, signoutbtn;

    @FXML
    private ImageView imageView;

    private ScaleTransition transition;

    @FXML
    AboutController aboutController = null;

    @FXML
    ShopController shopController = null;

    @FXML
    Cart1of2Controller cart1of2Controller = null;

    @FXML
    ProfileController profileController = null;

    @FXML
    BlogController blogController = null;

    @FXML
    SigninController loginController = null;


    //IMAGE SLIDER CONTROL
    private int count = 0;
    
    public void slider() {
    new Thread(() -> {
        try {
            while (true) {
                switch (count) {
                    case 0:
                        Thread.sleep(5000);

                        TranslateTransition slider1 = new TranslateTransition();
                        slider1.setNode(image1);
                        slider1.setDuration(Duration.seconds(3));
                        slider1.setToX(0);
                        slider1.play();

                        slider1.setOnFinished(event1 -> {
                            TranslateTransition slider2 = new TranslateTransition();
                            slider2.setNode(image2);
                            slider2.setDuration(Duration.seconds(3));
                            slider2.setToX(-600);
                            slider2.play();

                            slider2.setOnFinished(event2 -> {
                                TranslateTransition slider3 = new TranslateTransition();
                                slider3.setNode(image3);
                                slider3.setDuration(Duration.seconds(3));
                                slider3.setToX(-600);
                                slider3.play();
                            });
                        });

                        TranslateTransition slider4 = new TranslateTransition();
                        slider4.setNode(image4);
                        slider4.setDuration(Duration.seconds(3));
                        slider4.setToX(-600);
                        slider4.play();

                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }).start();
}


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider();

        // Create a ScaleTransition to animate the image scale
        transition = new ScaleTransition(Duration.seconds(0.5), imageView);
        transition.setFromX(1.0); 
        transition.setFromY(1.0);  
        transition.setToX(1.1);  
        transition.setToY(1.1);    
    }
    
    //GO TO ABOUT CONTROL
    @FXML
    public void gotoAbout(ActionEvent event) throws IOException {
        
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/About.fxml"));
            Parent root = loader.load();
            aboutController = loader.getController();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    //GO TO SHOP PRODUCTS CONTROL
    @FXML
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
   
  //GO TO PROFILE CONTROL
  @FXML
   public void gotoProfile(ActionEvent event) throws IOException {
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Profile.fxml"));
          Parent root = loader.load();
          profileController = loader.getController();

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
          blogController = loader.getController();

           FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
   }

  //GO TO LOGIN CONTROL
  @FXML
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


            loginController = loader.getController();
            

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
    public void handleMouseEntered() {
        transition.play(); 
    }

    @FXML
    public void handleMouseExited() {
        transition.stop();       
        imageView.setScaleX(1.0); 
        imageView.setScaleY(1.0); 
    }
}
