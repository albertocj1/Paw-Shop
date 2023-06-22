package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EmailReceiptController {
    
    @FXML
    Label userEmail, date, time, orderID, orderTotal, shipName, number, street, district, zip, dearname, cardname,cardnumber;

    @FXML
    Label orderdateLabel, ordertimeLabel;

    @FXML
    Cart2of2Controller cart2of2Controller = null;

    OrderSummaryController orderSummaryController =null;

    public void initialize() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        date.setText(currentDate.format(dateFormatter));

    
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        time.setText(currentTime.format(timeFormatter));
    }

    public void setUserEmail(String email) {
        userEmail.setText(email);
    }

    public void setOrderID(String orderID) {
        this.orderID.setText(orderID);
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal.setText(orderTotal);
    }

    public void setShippingDetails(String shipName, String number, String street, String district, String zip) {
        this.shipName.setText(shipName);
        this.number.setText(number);
        this.street.setText(street);
        this.district.setText(district);
        this.zip.setText(zip);
    }

        public void setDearName(String name) {
        dearname.setText(name + ",");
    }

    public void setCardDetails(String name, String number) {
        cardname.setText(name);
        cardnumber.setText(number);
    }

    public void setOrderDetails(String orderDate, String orderTime) {
        orderdateLabel.setText(orderDate);
        ordertimeLabel.setText(orderTime);
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
    
}
