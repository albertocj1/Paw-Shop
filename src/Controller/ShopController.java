package Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.CatProduct1;
import Model.CatProduct2;
import Model.CatProduct3;
import Model.DogProduct1;
import Model.DogProduct2;
import Model.DogProduct3;
import Model.SmallPetProduct1;
import Model.SmallPetProduct2;
import Model.SmallPetProduct3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;




public class ShopController implements Initializable{
    
    @FXML
    Button homebutton, aboutbutton, shopbutton, blogsbutton, profilebtn, signoutbtn,
    addcartbtn1, addcartbtn2, addcartbtn3, addcartbtn4, addcartbtn5, addcartbtn6, addcartbtn7, addcartbtn8, addcartbtn9;

    @FXML
    Button c1button, c2button, c3button, d1button, d2button, d3button, s1button, s2button, s3button;

    @FXML
    Pane c1paneCart, c2paneCart, c3paneCart, d1paneCart, d2paneCart, d3paneCart, s1paneCart, s2paneCart, s3paneCart;

    @FXML
    Button dogcategory, catcategory, smallpetcategory, dogprod1, dogprod2, dogprod3, catprod1, catprod2, catprod3, smallpetprod1, smallpetprod2, smallpetprod3;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    ImageView imageView;

    Parent root;

    FXMLLoader loader;

    @FXML
    Label namec1, namec2, namec3, pricec1, pricec2, pricec3,
    named1, named2, named3, priced1, priced2, priced3,
    names1, names2, names3, prices1, prices2, prices3;

    @FXML
    Cart1of2Controller checkoutController = null;

    static CatProduct1 c1 = new CatProduct1();
  
    static CatProduct2 c2 = new CatProduct2();
    
    static CatProduct3 c3 = new CatProduct3();
  
    static DogProduct1 d1 = new DogProduct1();
  
    static DogProduct2 d2 = new DogProduct2();
   
    static DogProduct3 d3 = new DogProduct3();
    
    static SmallPetProduct1 s1 = new SmallPetProduct1();
    
    static SmallPetProduct2 s2 = new SmallPetProduct2();
   
    static SmallPetProduct3 s3 = new SmallPetProduct3();
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {

          c1.setProductName("Whiskas Junior Ocean Fish");
          namec1.setText(c1.getProductName());
  
          c1.setProductPrice(349);
          pricec1.setText(Double.toString(c1.getProductPrice()));


          c2.setProductName("SmartHeart Adult Chicken");
          namec2.setText(c2.getProductName());
        
          c2.setProductPrice(299);
          pricec2.setText(Double.toString(c2.getProductPrice()));


          c3.setProductName("Ciao Jelly Tuna with Cuttle");
          namec3.setText(c3.getProductName());
         
          c3.setProductPrice(100);
          pricec3.setText(Double.toString(c3.getProductPrice()));

          d1.setProductName("Pedigree Grilled Steak");
          named1.setText(d1.getProductName());
         
          d1.setProductPrice(1518);
          priced1.setText(Double.toString(d1.getProductPrice()));


          d2.setProductName("Bil-Jac Picky No More");
          named2.setText(d2.getProductName());
         
          d2.setProductPrice(1200);
          priced2.setText(Double.toString(d2.getProductPrice()));


          d3.setProductName("CESAR Simply Crafted ");
          named3.setText(d3.getProductName());
          
          d3.setProductPrice(437);
          priced3.setText(Double.toString(d3.getProductPrice()));          


          s1.setProductName("HOPERAN Wooden Hamster");
          names1.setText(s1.getProductName());
          
          s1.setProductPrice(13859);
          prices1.setText(Double.toString(s1.getProductPrice()));


          s2.setProductName("Vitakraft Small Animal");
          names2.setText(s2.getProductName());
          
          s2.setProductPrice(1374.0);
          prices2.setText(Double.toString(s2.getProductPrice()));


          s3.setProductName("Freshwater Aquarium Test");
          names3.setText(s3.getProductName());
         
          s3.setProductPrice(1294.0);
          prices3.setText(Double.toString(s3.getProductPrice()));


        try {
            loader = new FXMLLoader(getClass().getResource("/view/Cart1of2.fxml"));
            root = loader.load();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());


        //---------C1 HOVER CART---------//
        c1button.setOnMouseEntered(event -> {
            if (!c1paneCart.isVisible()) {
            c1paneCart.setVisible(true);
            }
        });

        c1button.setOnMouseExited(event -> {
            if (c1paneCart.isVisible()) {
            c1paneCart.setVisible(false);
            }
        });
        c1paneCart.setOnMouseEntered(event -> {
            c1paneCart.setVisible(true);
        });

        c1paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(c1button, event)) {
                c1paneCart.setVisible(false);
            }
        });

        //---------C2 HOVER CART---------//
        c2button.setOnMouseEntered(event -> {
            if (!c2paneCart.isVisible()) {
            c2paneCart.setVisible(true);
            }
        });

        c2button.setOnMouseExited(event -> {
            if (c2paneCart.isVisible()) {
            c2paneCart.setVisible(false);
            }
        });
        c2paneCart.setOnMouseEntered(event -> {
            c2paneCart.setVisible(true);
        });

        c2paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(c2button, event)) {
                c2paneCart.setVisible(false);
            }
        });


        //---------C3 HOVER CART---------//
        c3button.setOnMouseEntered(event -> {
            if (!c3paneCart.isVisible()) {
            c3paneCart.setVisible(true);
            }
        });

        c3button.setOnMouseExited(event -> {
            if (c3paneCart.isVisible()) {
            c3paneCart.setVisible(false);
            }
        });
        c3paneCart.setOnMouseEntered(event -> {
            c3paneCart.setVisible(true);
        });

        c3paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(c3button, event)) {
                c3paneCart.setVisible(false);
            }
        });

        //---------D1 HOVER CART---------//
         d1button.setOnMouseEntered(event -> {
            if (!d1paneCart.isVisible()) {
            d1paneCart.setVisible(true);
            }
        });

        d1button.setOnMouseExited(event -> {
            if (d1paneCart.isVisible()) {
            d1paneCart.setVisible(false);
            }
        });
        d1paneCart.setOnMouseEntered(event -> {
            d1paneCart.setVisible(true);
        });

        d1paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(d1button, event)) {
                d1paneCart.setVisible(false);
            }
        });

        //---------D2 HOVER CART---------//
         d2button.setOnMouseEntered(event -> {
            if (!d2paneCart.isVisible()) {
            d2paneCart.setVisible(true);
            }
        });

        d2button.setOnMouseExited(event -> {
            if (d2paneCart.isVisible()) {
            d2paneCart.setVisible(false);
            }
        });
        d2paneCart.setOnMouseEntered(event -> {
            d2paneCart.setVisible(true);
        });

        d2paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(d2button, event)) {
                d2paneCart.setVisible(false);
            }
        });

        //---------D3 HOVER CART---------//
         d3button.setOnMouseEntered(event -> {
            if (!d3paneCart.isVisible()) {
            d3paneCart.setVisible(true);
            }
        });

        d3button.setOnMouseExited(event -> {
            if (d3paneCart.isVisible()) {
            d3paneCart.setVisible(false);
            }
        });
        d3paneCart.setOnMouseEntered(event -> {
            d3paneCart.setVisible(true);
        });

        d3paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(d3button, event)) {
                d3paneCart.setVisible(false);
            }
        });

        //---------S1 HOVER CART---------//
         s1button.setOnMouseEntered(event -> {
            if (!s1paneCart.isVisible()) {
            s1paneCart.setVisible(true);
            }
        });

        s1button.setOnMouseExited(event -> {
            if (s1paneCart.isVisible()) {
            s1paneCart.setVisible(false);
            }
        });
        s1paneCart.setOnMouseEntered(event -> {
            s1paneCart.setVisible(true);
        });

        s1paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(s1button, event)) {
                s1paneCart.setVisible(false);
            }
        });
        
        //---------S2 HOVER CART---------//
         s2button.setOnMouseEntered(event -> {
            if (!s2paneCart.isVisible()) {
            s2paneCart.setVisible(true);
            }
        });

        s2button.setOnMouseExited(event -> {
            if (s2paneCart.isVisible()) {
            s2paneCart.setVisible(false);
            }
        });
        s2paneCart.setOnMouseEntered(event -> {
            s2paneCart.setVisible(true);
        });

        s2paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(s2button, event)) {
                s2paneCart.setVisible(false);
            }
        });

         //---------S3 HOVER CART---------//
         s3button.setOnMouseEntered(event -> {
            if (!s3paneCart.isVisible()) {
            s3paneCart.setVisible(true);
            }
        });

        s3button.setOnMouseExited(event -> {
            if (s3paneCart.isVisible()) {
            s3paneCart.setVisible(false);
            }
        });
        s3paneCart.setOnMouseEntered(event -> {
            s3paneCart.setVisible(true);
        });

        s3paneCart.setOnMouseExited(event -> {
            if (!isMouseHovering(s3button, event)) {
                s3paneCart.setVisible(false);
            }
        }); 
    }

    private boolean isMouseHovering(Node node, MouseEvent event) {
    Bounds bounds = node.localToScene(node.getBoundsInLocal());
    return bounds.contains(event.getSceneX(), event.getSceneY());

    }
    @FXML
    private void handleButton1(ActionEvent event) {
        anchorPane1.setVisible(true);
        anchorPane2.setVisible(false);
    }
    @FXML
    private void handleButton2(ActionEvent event) {
        anchorPane1.setVisible(false);
        anchorPane2.setVisible(true);
    }

    public void buy(ActionEvent event) throws IOException {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add to Cart");
            alert.setHeaderText(null);
            alert.setContentText("Item successfully added to cart, thank you!");

            Image icon = new Image(getClass().getResourceAsStream("/Images/added.png"));
            ImageView iconView = new ImageView(icon);
            iconView.setFitWidth(50);
            iconView.setFitHeight(50);
            alert.setGraphic(iconView);

            Button sourceButton = (Button) event.getSource();

        
        if (sourceButton.equals(addcartbtn1)) {
            if (c1.getProductStatus()) {
                showItemAlreadyAddedAlert();
                c1paneCart.setVisible(false);
            } else {
                c1.setProductStatus(true);
                ShopController.c1.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane1);
                c1paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn2) {
            if (c2.getProductStatus()) {
                showItemAlreadyAddedAlert();
                c2paneCart.setVisible(false);
            } else {
                c2.setProductStatus(true);
                ShopController.c2.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane2);
                c2paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn3) {
            if (c3.getProductStatus()) {
                showItemAlreadyAddedAlert();
                c3paneCart.setVisible(false);
                } else {
                c3.setProductStatus(true);
                ShopController.c3.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane3);
                c3paneCart.setVisible(false);
                alert.showAndWait();
            }
        }
        else if (sourceButton == addcartbtn4) {
            if (d1.getProductStatus()) {
                showItemAlreadyAddedAlert();
                d1paneCart.setVisible(false);
                } else {
                d1.setProductStatus(true);
                ShopController.d1.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane4);
                d1paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn5) {
            if (d2.getProductStatus()) {
                showItemAlreadyAddedAlert();
                d2paneCart.setVisible(false);
                } else {
                d2.setProductStatus(true);
                ShopController.d2.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane5);
                d2paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn6) {
            if (d3.getProductStatus()) {
                showItemAlreadyAddedAlert();
                d3paneCart.setVisible(false);
                } else {
                d3.setProductStatus(true);
                ShopController.d3.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane6);
                d3paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn7) {
            if (s1.getProductStatus()) {
                showItemAlreadyAddedAlert();
                s1paneCart.setVisible(false);
                } else {
                s1.setProductStatus(true);
                ShopController.s1.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane7);
                s1paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn8) {
            if (s2.getProductStatus()) {
                showItemAlreadyAddedAlert();
                s2paneCart.setVisible(false);
                } else {
                s2.setProductStatus(true);
                ShopController.s2.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane8);
                s2paneCart.setVisible(false);
                alert.showAndWait();
            }
        }

        else if (sourceButton == addcartbtn9) {
            if (s3.getProductStatus()) {
                showItemAlreadyAddedAlert();
                s3paneCart.setVisible(false);
                } else {
                s3.setProductStatus(true);
                ShopController.s3.setProductQuantity(1);
                checkoutController.addItem(checkoutController.pane9);
                s3paneCart.setVisible(false);
                alert.showAndWait();
            }  
        }
    }
    //GO TO CATEGORIES CONTROL

    @FXML
    public void gotoDogCategory(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ShopDog.fxml")); 
        Stage newStage = new Stage();

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }
    
    @FXML
    public void gotoCatCategory(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ShopCat.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoSmallPetCategory(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ShopSmallPet.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }
    //GO TO PRODUCTS CONTROL

    @FXML
    public void gotoDogProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/DogProduct1.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoDogProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/DogProduct2.fxml")); 
        Stage newStage = new Stage();

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoDogProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/DogProduct3.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoCatProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct1.fxml")); 
        Stage newStage = new Stage();

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoCatProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct2.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoCatProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/CatProduct3.fxml")); 
        Stage newStage = new Stage();

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoSmallPetProd1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct1.fxml")); 
        Stage newStage = new Stage();
        
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoSmallPetProd2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct2.fxml")); 
        Stage newStage = new Stage();

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }

    @FXML
    public void gotoSmallPetProd3(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/SmallProduct3.fxml")); 
        Stage newStage = new Stage();

        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }
   
    @FXML
    public void gotoCart(ActionEvent event) throws IOException {
        if (!isAnyItemAdded()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Empty Cart");
        alert.setHeaderText(null);
        alert.setContentText("You have no items in your cart.");

        Image icon = new Image(getClass().getResourceAsStream("/Images/noitem.png"));
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
        alert.showAndWait();
        return;
    }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to go to Cart? There is no going back!");

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
            
            checkoutController.getInitialAmount();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    private boolean isAnyItemAdded() {
        if (c1.getProductStatus() || c2.getProductStatus() || c3.getProductStatus() ||
                d1.getProductStatus() || d2.getProductStatus() || d3.getProductStatus() ||
                s1.getProductStatus() || s2.getProductStatus() || s3.getProductStatus()) {
            return true;
        }
        return false;
    }
    public void showItemAlreadyAddedAlert() {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Item Already Added");
        alert1.setHeaderText(null);
        alert1.setContentText("Item already added in cart.");

        Image icon = new Image(getClass().getResourceAsStream("/Images/itemcart.png"));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(50);
        iconView.setFitHeight(50);
        alert1.setGraphic(iconView);

        alert1.showAndWait();
    }
}
