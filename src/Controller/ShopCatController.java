package Controller;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.Node;

public class ShopCatController {

    @FXML
    Button DogCategory, SmallPetCategory, closeButton;

    @FXML
    Button catprod1, catprod2, catprod3;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    //GO TO CATEGORIES CONTROL
    @FXML
    public void gotoDogCategory(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/View/ShopDog.fxml")); 
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void gotoSmallPetCategory(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/View/ShopSmallPet.fxml")); 
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //GO TO PRODUCTS CONTROL

    @FXML
    public void gotoCatProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct1.fxml")); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void gotoCatProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct2.fxml")); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    public void gotoCatProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct3.fxml")); 
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }
    @FXML
     private void closeScene(ActionEvent event) {
        Button closeButton = (Button) event.getSource();
        Stage currentStage = (Stage) closeButton.getScene().getWindow();
        currentStage.close();
    }
}
    