package View.CustomerHomeView;

import Controller.CustomerHomeController.CustomerHomeController;
import Controller.CustomerHomeController.CustomerHomeEventListener;
import Controller.CustomerHomeController.CustomerHomeEventObject;
import Model.Objects.Customer;
import Model.Objects.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * Created by Studio on 12/16/2016.
 */
public class CustomerHomeView {

    public CustomerHomeEventListener customerHomeEventListener;
    Stage stage;
    Button button;
    private Customer current;

    public CustomerHomeView(Stage stage) {
        this.stage = stage;

        BorderPane root = new BorderPane();
        VBox pane = new VBox(5);
        pane.setPadding(new Insets(5));
        pane.setAlignment(Pos.CENTER);

        CustomerHomeController controller = new CustomerHomeController(this);


        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setStyle("-fx-font-size: 72");
        pane.getChildren().add(welcomeLabel);


        button = new Button("Purchase Tickets");
        pane.getChildren().add(button);
        button.prefHeight(5);
        button.prefWidth(7);

        button.setOnAction(event -> {
            CustomerHomeEventObject ev = new CustomerHomeEventObject(this);
            customerHomeEventListener.btnClicked(ev);
        });


        root.setCenter(pane);
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add("View/EmployeeHomeView/EmployeeHomeView.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setCustomerHomeEventListener(CustomerHomeEventListener customerHomeEventListener) {
        this.customerHomeEventListener = customerHomeEventListener;
    }

    public Controller.CustomerHomeController.CustomerHomeEventListener getCustomerHomeEventListener() {
        return customerHomeEventListener;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setCurrent(Customer current) {
        this.current = current;
    }

    public Customer getCurrent() {
        return current;
    }
}
