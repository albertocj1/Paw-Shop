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

public class ShopSmallPetController {

    @FXML
    Button DogCategory, CatCategory, closeButton;

    @FXML
    Button smallpetprod1, smallpetprod2, smallpetprod3;

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
    public void gotoCatCategory(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/View/ShopCat.fxml")); 
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //GO TO PRODUCTS CONTROL

    @FXML
    public void gotoSmallPetProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct1.fxml")); 
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
    public void gotoSmallPetProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct2.fxml")); 
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
    public void gotoSmallPetProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct3.fxml")); 
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
    