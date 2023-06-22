package Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Cart2of2Controller implements Initializable {
    @FXML
    Label namec1, namec2, namec3, named1, named2, named3, names1, names2, names3;

    @FXML
    Label pricec1, pricec2, pricec3, priced1, priced2, priced3, prices1, prices2, prices3;

    @FXML
    Label finalpricec1, finalpricec2, finalpricec3, finalpriced1, finalpriced2, finalpriced3, finalprices1, finalprices2, finalprices3;

    @FXML
    Label qty1, qty2, qty3, qty4, qty5, qty6, qty7, qty8, qty9;

    @FXML
    Label totall, paytotal, subtotal;

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

    @FXML
    TextField cardname, cardnumber, cvv;

    @FXML
    Label cardnameWarningLabel, cardnumberWarningLabel, cvvWarningLabel;

    @FXML
    Label customerdistrict, customername, customerstreetaddress, customerzipcode, customernumber, customeremail;

    
    @FXML
    private ChoiceBox<String> monthChoiceBox;
    
    @FXML
    private ChoiceBox<String> yearChoiceBox;

    @FXML
    OrderSummaryController orderSummaryController = null;

    @FXML
        double item1Amount;
        double item2Amount;
        double item3Amount;
        double item4Amount; 
        double item5Amount;
        double item6Amount;
        double item7Amount;
        double item8Amount;
        double item9Amount; 

    @FXML
    private VBox myvbox;
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        monthChoiceBox.setValue("1");
        yearChoiceBox.setValue("2024");

        if (ShopController.c1.getProductStatus()) {
            namec1.setText(ShopController.c1.getProductName());
            qty1.setText(Double.toString(ShopController.c1.getProductQuantity()));
            pricec1.setText(Double.toString(ShopController.c1.getProductPrice()));
            finalpricec1.setText(Double.toString(ShopController.c1.getProductPrice() * ShopController.c1.getProductQuantity()));
            addItem(pane1);
            
            item1Amount = ShopController.c1.getProductPrice() * ShopController.c1.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane1);
        }
        

        if (ShopController.c2.getProductStatus()) {
            namec2.setText(ShopController.c2.getProductName());
            qty2.setText(Double.toString(ShopController.c2.getProductQuantity()));
            pricec2.setText(Double.toString(ShopController.c2.getProductPrice()));
            finalpricec2.setText(Double.toString(ShopController.c2.getProductPrice() * ShopController.c2.getProductQuantity()));
            addItem(pane2);

            item2Amount = ShopController.c2.getProductPrice() * ShopController.c2.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane2);
        }
        

        if (ShopController.c3.getProductStatus()) {
            namec3.setText(ShopController.c3.getProductName());
            qty3.setText(Double.toString(ShopController.c3.getProductQuantity()));
            pricec3.setText(Double.toString(ShopController.c3.getProductPrice()));
            finalpricec3.setText(Double.toString(ShopController.c3.getProductPrice() * ShopController.c3.getProductQuantity() ));
            addItem(pane3);
        
            item3Amount = ShopController.c3.getProductPrice() * ShopController.c3.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane3);
        }

        if (ShopController.d1.getProductStatus()) {
            named1.setText(ShopController.d1.getProductName());
            qty4.setText(Double.toString(ShopController.d1.getProductQuantity()));
            priced1.setText(Double.toString(ShopController.d1.getProductPrice()));
            finalpriced1.setText(Double.toString(ShopController.d1.getProductPrice()* ShopController.d1.getProductQuantity()));
            addItem(pane4);
            
            item4Amount = ShopController.d1.getProductPrice() * ShopController.d1.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane4);
        }

        if (ShopController.d2.getProductStatus()) {
            named2.setText(ShopController.d2.getProductName());
            qty5.setText(Double.toString(ShopController.d2.getProductQuantity()));
            priced2.setText(Double.toString(ShopController.d2.getProductPrice()));
            finalpriced2.setText(Double.toString(ShopController.d2.getProductPrice() * ShopController.d2.getProductQuantity()));
            addItem(pane5);
            
            item5Amount = ShopController.d2.getProductPrice() * ShopController.d2.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane5);
        }

        if (ShopController.d3.getProductStatus()) {
            named3.setText(ShopController.d3.getProductName());
            qty6.setText(Double.toString(ShopController.d3.getProductQuantity()));
            priced3.setText(Double.toString(ShopController.d3.getProductPrice()));
            finalpriced3.setText(Double.toString(ShopController.d3.getProductPrice() * ShopController.d3.getProductQuantity()));
            addItem(pane6);
            
            item6Amount = ShopController.d3.getProductPrice() * ShopController.d3.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane6);
        }

        if (ShopController.s1.getProductStatus()) {
            names1.setText(ShopController.s1.getProductName());
            qty7.setText(Double.toString(ShopController.s1.getProductQuantity()));
            prices1.setText(Double.toString(ShopController.s1.getProductPrice()));
            finalprices1.setText(Double.toString(ShopController.s1.getProductPrice() * ShopController.s1.getProductQuantity()));
            addItem(pane7);
            
            item7Amount = ShopController.s1.getProductPrice() * ShopController.s1.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane7);
        }

        if (ShopController.s2.getProductStatus()) {
            names2.setText(ShopController.s2.getProductName());
            qty8.setText(Double.toString(ShopController.s2.getProductQuantity()));
            prices2.setText(Double.toString(ShopController.s2.getProductPrice()));
            finalprices2.setText(Double.toString(ShopController.s2.getProductPrice()*ShopController.s2.getProductQuantity()));
            addItem(pane8);
            
            item8Amount = ShopController.s2.getProductPrice() * ShopController.s2.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane8);
        }

        if (ShopController.s3.getProductStatus()) {
            names3.setText(ShopController.s3.getProductName());
            qty9.setText(Double.toString(ShopController.s3.getProductQuantity()));
            prices3.setText(Double.toString(ShopController.s3.getProductPrice()));
            finalprices3.setText(Double.toString(ShopController.s3.getProductPrice()* ShopController.s3.getProductQuantity()));
            addItem(pane9);
            
            item9Amount = ShopController.s3.getProductPrice() * ShopController.s3.getProductQuantity();
        } else {
            myvbox.getChildren().remove(pane9);
        }

        double final_amount = item1Amount+ item2Amount+ item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item9Amount+ 38;
        totall.setText(Double.toString(final_amount));
        paytotal.setText(Double.toString(final_amount));


        //CHOICE BOX VALUES
        for (int i = 1; i <= 12; i++) {
            monthChoiceBox.getItems().add(String.valueOf(i));
            }

        
            int currentYear = LocalDate.now().getYear();
        for (int i = currentYear+1; i <= currentYear + 10; i++) {
            yearChoiceBox.getItems().add(String.valueOf(i));
        }
    }


    public void addItem(Pane pane) {
        if (!myvbox.getChildren().contains(pane)) {
            myvbox.getChildren().add(pane);
        }
    }

    public void setCustomerDetails(String name, String number, String email, String street, String zip, String selectedDistrict) {
        customername.setText(name);
        customernumber.setText(number);
        customerstreetaddress.setText(street);
        customerzipcode.setText(zip);
        customerdistrict.setText(selectedDistrict);
        customeremail.setText(email);

    }


    public void validateFields(ActionEvent event) {
        String cname = cardname.getText();
        String cnumber = cardnumber.getText();
        String cvvText = cvv.getText();

        boolean validationsPassed = true;

        if (cname.isEmpty()) {
            cardnameWarningLabel.setText("Card Name is required.");
            cardnameWarningLabel.setVisible(true);
            validationsPassed = false;
        } else {
           cardnameWarningLabel.setVisible(false);
        }

        if (!cnumber.matches("\\d{12}")) {
            cardnumberWarningLabel.setText("Card Number should have 12 digits.");
            cardnumberWarningLabel.setVisible(true);
            validationsPassed = false;
        } else {
           cardnumberWarningLabel.setVisible(false);
        }

        if (cvvText.isEmpty()) {
            cvvWarningLabel.setText("CVV is required.");
            cvvWarningLabel.setVisible(true);
            validationsPassed = false;
        } else if (!cvvText.matches("\\d{3}")) {
            cvvWarningLabel.setText("CVV should have 3 digits.");
            cvvWarningLabel.setVisible(true);
            validationsPassed = false;
        } else {
            cvvWarningLabel.setVisible(false);
        }


        if (validationsPassed) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("You will be paying for your purchase. Are you sure you want to proceed?");

            Image icon = new Image(getClass().getResourceAsStream("/Images/wallet2.png"));
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
                
                try {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/OrderSummary.fxml"));
                    Parent root = loader.load();
                    orderSummaryController = loader.getController();

                    orderSummaryController.setCustomerDetails(
                    customername.getText(),
                    customernumber.getText(),
                    customerstreetaddress.getText(),
                    customerzipcode.getText(),
                    customerdistrict.getText(),
                    customeremail.getText()
                    );
                    orderSummaryController.setCardDetails(cname, cnumber);

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void gotoLogin(ActionEvent event) throws IOException {
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Sign Out");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to sign out?");
        confirmation.showAndWait();

        if (confirmation.getResult() == ButtonType.OK) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Signin.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
}
