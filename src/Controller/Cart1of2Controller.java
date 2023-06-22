package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cart1of2Controller implements Initializable{
    
    @FXML
    Label namec1, namec2, namec3,
    named1, named2, named3,  
    names1, names2, names3;

    @FXML
    Label finalpricec1, finalpricec2, finalpricec3, finalpriced1, finalpriced2, finalpriced3, finalprices1, finalprices2, finalprices3;

    @FXML
    Label totall;

    @FXML
    Label totalwithshipping;

    @FXML
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    @FXML 
    VBox myvbox;

    @FXML 
    ScrollPane myscrollpane;

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

    @FXML
    TextField emailTF, numberTF, streetTF, zipTF, nameTF;

    @FXML
    Label mywarninglabel1, mywarninglabel2, mywarninglabel3, mywarninglabel4, mywarninglabel0, shippinglabel;
    

    @FXML
    Cart2of2Controller cart2of2Controller = null;

    @FXML
    OrderSummaryController orderSummaryController = null;


    @FXML
    Button gotoCart2;

    @FXML
    private ChoiceBox<String> districtchoices;

    private String[] choices = { "Binondo", "Ermita", "Intramuros", "Sampaloc", "Sta. Mesa", "Tondo",  };

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;


    @FXML
    private ChoiceBox<String> choicebox1, choicebox2, choicebox3, choicebox4, choicebox5, choicebox6, choicebox7, choicebox8, choicebox9;

    private String[] quantity = { "1", "2", "3" };

    static String totalWithShippingC2= "0";

    static String totalOS= "0";
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

        namec1.setText(ShopController.c1.getProductName());
        finalpricec1.setText(Double.toString(ShopController.c1.getProductPrice()));

        namec2.setText(ShopController.c2.getProductName());
        finalpricec2.setText(Double.toString(ShopController.c2.getProductPrice()));
        
        namec3.setText(ShopController.c3.getProductName());
        finalpricec3.setText(Double.toString(ShopController.c3.getProductPrice()));

        named1.setText(ShopController.d1.getProductName());
        finalpriced1.setText(Double.toString(ShopController.d1.getProductPrice()));

        named2.setText(ShopController.d2.getProductName());
        finalpriced2.setText(Double.toString(ShopController.d2.getProductPrice()));
        
        named3.setText(ShopController.d3.getProductName());
        finalpriced3.setText(Double.toString(ShopController.d3.getProductPrice()));
        
        names1.setText(ShopController.s1.getProductName());
        finalprices1.setText(Double.toString(ShopController.s1.getProductPrice()));

        names2.setText(ShopController.s2.getProductName());
        finalprices2.setText(Double.toString(ShopController.s2.getProductPrice()));

        names3.setText(ShopController.s3.getProductName());
        finalprices3.setText(Double.toString(ShopController.s3.getProductPrice()));

        // Set default choice in districtchoice box
        districtchoices.setValue("Binondo");

        //Insert choices array to districtchoice box
        districtchoices.getItems().addAll(choices);

        // Set default quantities in choicebox to 1
        choicebox1.setValue("1");
        choicebox2.setValue("1");
        choicebox3.setValue("1");
        choicebox4.setValue("1");
        choicebox5.setValue("1");
        choicebox6.setValue("1");
        choicebox7.setValue("1");
        choicebox8.setValue("1");
        choicebox9.setValue("1");


        // Insert quantity array to choicebox
        choicebox1.getItems().addAll(quantity);
        choicebox2.getItems().addAll(quantity);
        choicebox3.getItems().addAll(quantity);
        choicebox4.getItems().addAll(quantity);
        choicebox5.getItems().addAll(quantity);
        choicebox6.getItems().addAll(quantity);
        choicebox7.getItems().addAll(quantity);
        choicebox8.getItems().addAll(quantity);
        choicebox9.getItems().addAll(quantity);

        // Add event handler on all choiceboxes
        choicebox1.setOnAction(this::computeTotal);
        choicebox2.setOnAction(this::computeTotal);
        choicebox3.setOnAction(this::computeTotal);
        choicebox4.setOnAction(this::computeTotal);
        choicebox5.setOnAction(this::computeTotal);
        choicebox6.setOnAction(this::computeTotal);
        choicebox7.setOnAction(this::computeTotal);
        choicebox8.setOnAction(this::computeTotal);
        choicebox9.setOnAction(this::computeTotal);
   
    }
    public void addItem(Pane pane) {
        myvbox.getChildren().add(pane);
        shippinglabel.setVisible(true);
    }

    public void computeTotal(ActionEvent event) {

        double totalAmount = 0;
        double item1Amount = 0;
        double item2Amount = 0;
        double item3Amount = 0;
        double item4Amount = 0;
        double item5Amount = 0;
        double item6Amount = 0;
        double item7Amount = 0;
        double item8Amount = 0;
        double item9Amount = 0;

        ChoiceBox source = (ChoiceBox) event.getSource();

        // If product is chosen, compute item amount
        if (ShopController.c1.getProductStatus()) {

            double qty = Double.parseDouble(choicebox1.getValue());
            ShopController.c1.setProductQuantity(qty);
            item1Amount = ShopController.c1.getProductPrice() * qty;

            if (source == choicebox1) {
                item1Amount = ShopController.c1.getProductPrice() * qty;
            }
        }

        if (ShopController.c2.getProductStatus()) {

            double qty = Double.parseDouble(choicebox2.getValue());
            ShopController.c2.setProductQuantity(qty);
            item2Amount = ShopController.c2.getProductPrice() * qty;

            if (source == choicebox2) {
                item2Amount = ShopController.c2.getProductPrice() * qty;
            }
        }

        if (ShopController.c3.getProductStatus()) {

            double qty = Double.parseDouble(choicebox3.getValue());
            ShopController.c3.setProductQuantity(qty);
            item3Amount = ShopController.c3.getProductPrice() * qty;

            if (source == choicebox3) {
                item3Amount = ShopController.c3.getProductPrice() * qty;
            }
        }

        if (ShopController.d1.getProductStatus()) {

            double qty = Double.parseDouble(choicebox4.getValue());
            ShopController.d1.setProductQuantity(qty);
            item4Amount = ShopController.d1.getProductPrice() * qty;

            if (source == choicebox4) {
                item4Amount = ShopController.d1.getProductPrice() * qty;
            }
        }

        if (ShopController.d2.getProductStatus()) {

            double qty = Double.parseDouble(choicebox5.getValue());
            ShopController.d2.setProductQuantity(qty);
            item5Amount = ShopController.d2.getProductPrice() * qty;

            if (source == choicebox5) {
                item5Amount = ShopController.d2.getProductPrice() * qty;
            }
        }

        if (ShopController.d3.getProductStatus()) {

            double qty = Double.parseDouble(choicebox6.getValue());
            ShopController.d3.setProductQuantity(qty);
            item6Amount = ShopController.d3.getProductPrice() * qty;

            if (source == choicebox6) {
                item6Amount = ShopController.d3.getProductPrice() * qty;
            }
        }

        if (ShopController.s1.getProductStatus()) {

            double qty = Double.parseDouble(choicebox7.getValue());
            ShopController.s1.setProductQuantity(qty);
            item7Amount = ShopController.s1.getProductPrice() * qty;

            if (source == choicebox7) {
                item7Amount = ShopController.s1.getProductPrice() * qty;
            }
        }    

        if (ShopController.s2.getProductStatus()) {

            double qty = Double.parseDouble(choicebox8.getValue());
            ShopController.s2.setProductQuantity(qty);
            item8Amount = ShopController.s2.getProductPrice() * qty;

            if (source == choicebox8) {
                item8Amount = ShopController.s2.getProductPrice() * qty;
            }
        }   

        if (ShopController.s3.getProductStatus()) {

            double qty = Double.parseDouble(choicebox9.getValue());
            ShopController.s3.setProductQuantity(qty);
            item9Amount = ShopController.s3.getProductPrice() * qty;

            if (source == choicebox9) {
                item9Amount = ShopController.s3.getProductPrice() * qty;
            }
        }   

        // Compute total amount for all items chosen
        totalAmount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item9Amount;
        
        // Display total amount in total label
        totall.setText(Double.toString(totalAmount));
        totalOS = Double.toString(totalAmount);

        // Compute total amount plus shipping
        double totalWithShipping = totalAmount + 38.00;
        totalWithShippingC2 = Double.toString(totalWithShipping);

        //Display total amount with shipping fee in the "shipping" label
        totalwithshipping.setText(Double.toString(totalWithShipping));
    }

    public void getInitialAmount() {

        double totalAmount = 0.00;

        if (ShopController.c1.getProductStatus()) {
            totalAmount += ShopController.c1.getProductPrice();
        }

        if (ShopController.c2.getProductStatus()) {
            totalAmount += ShopController.c2.getProductPrice();
        }

        if (ShopController.c3.getProductStatus()) {
            totalAmount += ShopController.c3.getProductPrice();
        }

        if (ShopController.d1.getProductStatus()) {
            totalAmount += ShopController.d1.getProductPrice();
        }

        if (ShopController.d2.getProductStatus()) {
            totalAmount += ShopController.d2.getProductPrice();
        }

        if (ShopController.d3.getProductStatus()) {
            totalAmount += ShopController.d3.getProductPrice();
        }

        if (ShopController.s1.getProductStatus()) {
            totalAmount += ShopController.s1.getProductPrice();
        }

        if (ShopController.s2.getProductStatus()) {
            totalAmount += ShopController.s2.getProductPrice();
        }

        if (ShopController.s3.getProductStatus()) {
            totalAmount += ShopController.s3.getProductPrice();
        }

        totall.setText(Double.toString(totalAmount));
        double totalWithShipping = totalAmount + 38.00;
        totalwithshipping.setText(Double.toString(totalWithShipping));
    }

//----------------------
    //CART VALIDATIONS

    public void gotoCart2of2(ActionEvent event) throws IOException {
        
        
        String name = nameTF.getText();
        String number = numberTF.getText();
        String email = emailTF.getText();
        String street = streetTF.getText();
        String zip = zipTF.getText();
        String selectedDistrict = districtchoices.getValue();
        
        
        boolean validationsPassed = true;


        if (name.isEmpty()) {
            mywarninglabel0.setText("Name should not be blank.");
            mywarninglabel0.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel0.setVisible(false);
        }


        if (!isValidEmail(email)) {
            mywarninglabel1.setText("Email should end with '@gmail.com'.");
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

        if (!isValidStreet(street)) {
            mywarninglabel3.setText("Street should contain the block and 'street' or 'st'.");
            mywarninglabel3.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel3.setVisible(false);
        }

        if (!isValidZip(zip)) {
            mywarninglabel4.setText("Zip should contain exactly 4 digits.");
            mywarninglabel4.setVisible(true);
            validationsPassed = false;
        } else {
            mywarninglabel4.setVisible(false);
        }



    if (validationsPassed) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Cart2of2.fxml"));
            Parent root = loader.load();
            cart2of2Controller = loader.getController();

            cart2of2Controller.setCustomerDetails(name, number, email, street, zip, selectedDistrict);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    private boolean isValidNumber(String number) {
        return number.matches("^\\d{11}$");
    }

    private boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    private boolean isValidStreet(String street) {
        return street.matches("^(?i)(?=.*\\b(street|st\\b))(?=.*\\b\\d+\\b).*$");
    }


    private boolean isValidZip(String zip) {
        return zip.matches("^\\d{4}$");
    }



    public void gotoLogin(ActionEvent event) throws IOException {
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Sign Out");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Are you sure you want to sign out? All your Added Products will be removed.");
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
