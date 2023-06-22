    package Controller;

    import java.io.IOException;
    import java.net.URL;
    import java.util.Random;
    import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.Alert.AlertType;
    import javafx.scene.control.ButtonType;
    import javafx.scene.control.Label;
    import javafx.scene.control.TextField;
    import javafx.scene.layout.Pane;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
    import java.time.LocalTime;
    import java.time.format.DateTimeFormatter;

    public class OrderSummaryController implements Initializable {
        
        @FXML
        Label namec1, namec2, namec3, named1, named2, named3, names1, names2, names3;

        @FXML
        Label finalpricec1, finalpricec2, finalpricec3, finalpriced1, finalpriced2, finalpriced3, finalprices1, finalprices2, finalprices3;

        @FXML
        Label qty1, qty2, qty3, qty4, qty5, qty6, qty7, qty8, qty9;

        @FXML
        Label totall, paytotal, paytotal1, orderID, shipping;

        @FXML
        Label customerdistrict, customername, customerstreetaddress, customerzipcode, customernumber, customeremail, cardnameLabel, cardnumberLabel;

        @FXML
        Button gotoHome, showTeam, emailreceipt;

        @FXML
        Label ordertime;

        @FXML
        Label orderdate;

        @FXML
        TextField emailTF;

        @FXML
        Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

        @FXML
        VBox myvbox;

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
        TeamController teamController = null;


        @Override
        public void initialize(URL location, ResourceBundle resources) {

            if (ShopController.c1.getProductStatus()) {
                namec1.setText(ShopController.c1.getProductName());
                qty1.setText(Double.toString(ShopController.c1.getProductQuantity()));
                finalpricec1.setText(Double.toString(ShopController.c1.getProductPrice() * ShopController.c1.getProductQuantity()));
                addItem(pane1);
                
                item1Amount = ShopController.c1.getProductPrice() * ShopController.c1.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane1);
            }
            

            if (ShopController.c2.getProductStatus()) {
                namec2.setText(ShopController.c2.getProductName());
                qty2.setText(Double.toString(ShopController.c2.getProductQuantity()));
                finalpricec2.setText(Double.toString(ShopController.c2.getProductPrice() * ShopController.c2.getProductQuantity()));
                addItem(pane2);

                item2Amount = ShopController.c2.getProductPrice() * ShopController.c2.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane2);
            }
            

            if (ShopController.c3.getProductStatus()) {
                namec3.setText(ShopController.c3.getProductName());
                qty3.setText(Double.toString(ShopController.c3.getProductQuantity()));
                finalpricec3.setText(Double.toString(ShopController.c3.getProductPrice() * ShopController.c3.getProductQuantity() ));
                addItem(pane3);
            
                item3Amount = ShopController.c3.getProductPrice() * ShopController.c3.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane3);
            }

            if (ShopController.d1.getProductStatus()) {
                named1.setText(ShopController.d1.getProductName());
                qty4.setText(Double.toString(ShopController.d1.getProductQuantity()));
                finalpriced1.setText(Double.toString(ShopController.d1.getProductPrice()* ShopController.d1.getProductQuantity()));
                addItem(pane4);
                
                item4Amount = ShopController.d1.getProductPrice() * ShopController.d1.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane4);
            }

            if (ShopController.d2.getProductStatus()) {
                named2.setText(ShopController.d2.getProductName());
                qty5.setText(Double.toString(ShopController.d2.getProductQuantity()));
                finalpriced2.setText(Double.toString(ShopController.d2.getProductPrice() * ShopController.d2.getProductQuantity()));
                addItem(pane5);
                
                item5Amount = ShopController.d2.getProductPrice() * ShopController.d2.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane5);
            }

            if (ShopController.d3.getProductStatus()) {
                named3.setText(ShopController.d3.getProductName());
                qty6.setText(Double.toString(ShopController.d3.getProductQuantity()));
                finalpriced3.setText(Double.toString(ShopController.d3.getProductPrice() * ShopController.d3.getProductQuantity()));
                addItem(pane6);
                
                item6Amount = ShopController.d3.getProductPrice() * ShopController.d3.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane6);
            }

            if (ShopController.s1.getProductStatus()) {
                names1.setText(ShopController.s1.getProductName());
                qty7.setText(Double.toString(ShopController.s1.getProductQuantity()));
                finalprices1.setText(Double.toString(ShopController.s1.getProductPrice() * ShopController.s1.getProductQuantity()));
                addItem(pane7);
                
                item7Amount = ShopController.s1.getProductPrice() * ShopController.s1.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane7);
            }

            if (ShopController.s2.getProductStatus()) {
                names2.setText(ShopController.s2.getProductName());
                qty8.setText(Double.toString(ShopController.s2.getProductQuantity()));
                finalprices2.setText(Double.toString(ShopController.s2.getProductPrice()*ShopController.s2.getProductQuantity()));
                addItem(pane8);
                
                item8Amount = ShopController.s2.getProductPrice() * ShopController.s2.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane8);
            }

            if (ShopController.s3.getProductStatus()) {
                names3.setText(ShopController.s3.getProductName());
                qty9.setText(Double.toString(ShopController.s3.getProductQuantity()));
                finalprices3.setText(Double.toString(ShopController.s3.getProductPrice()* ShopController.s3.getProductQuantity()));
                addItem(pane9);
                
                item9Amount = ShopController.s3.getProductPrice() * ShopController.s3.getProductQuantity();
            } else {
                myvbox.getChildren().remove(pane9);
            }

            double final_amount = item1Amount+ item2Amount+ item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item9Amount;
            double final_amountwithshipping = item1Amount+ item2Amount+ item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item9Amount+ 38;
            totall.setText(Double.toString(final_amount));
            paytotal.setText(Double.toString(final_amountwithshipping));
            paytotal1.setText(Double.toString(final_amountwithshipping));

            String randomOrderID = generateRandomOrderID();
            orderID.setText(randomOrderID);

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            orderdate.setText(currentDate.format(dateFormatter));

        
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
            ordertime.setText(currentTime.format(timeFormatter));

        }

        public void addItem(Pane pane) {
            if (!myvbox.getChildren().contains(pane)) {
                myvbox.getChildren().add(pane);
            }
        }

        public void setCustomerDetails(String name, String number, String street, String zip, String selectedDistrict, String email) {
            customername.setText(name);
            customernumber.setText(number);
            customerstreetaddress.setText(street);
            customerzipcode.setText(zip);
            customerdistrict.setText(selectedDistrict);
            customeremail.setText(email);
        }

        public void setCardDetails(String cname, String cnumber) {
            String cardName = cname;
            String cardNumber = cnumber;

            cardnameLabel.setText(cardName);
            cardnumberLabel.setText(cardNumber);
        }   

        private String generateRandomOrderID() {
            Random random = new Random();
            int orderIDLength = 8;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < orderIDLength; i++) {
                int digit = random.nextInt(10);
                sb.append(digit);
            }

            return sb.toString();
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
        public void gotoTeam(ActionEvent event) throws IOException {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Team.fxml"));
            Parent root = loader.load();
            teamController = loader.getController();

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), root);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
         
        public void gotoEmail(ActionEvent event) throws IOException {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/EmailReceipt.fxml"));
            Parent root = loader.load();

             EmailReceiptController emailReceiptController = loader.getController();
                
                
                emailReceiptController.setUserEmail(customeremail.getText());
                emailReceiptController.setOrderID(orderID.getText());
                emailReceiptController.setOrderTotal(paytotal1.getText());
                emailReceiptController.setShippingDetails(customername.getText(), customernumber.getText(), customerstreetaddress.getText(), customerdistrict.getText(), customerzipcode.getText());
                emailReceiptController.setDearName(customername.getText());
                emailReceiptController.setCardDetails(cardnameLabel.getText(), cardnumberLabel.getText());
            
                String orderDate = orderdate.getText();
                String orderTime = ordertime.getText();
                emailReceiptController.setOrderDetails(orderDate, orderTime);


            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }   