package View.AddView;

import Controller.AddCustomerController.AddCustomerController;
import Controller.AddCustomerController.AddCustomerEventObject;
import Controller.AddCustomerController.AddCustomerListener;
import Controller.Login.LoginController;
import Model.Bags.TableBag;
import Model.Objects.User;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by chris on 12/10/2016.
 */
public class AddCustomerView {

    private final TextField userIdField;
    private Stage stage;
    private MenuBar employeeMenuBar = EmployeeHomeView.getEmployeeMenuBar();
    private AddCustomerListener addCustomerListener;
    private TextField fNameField, lNameField, uNameField;
    private PasswordField passField;

    public AddCustomerView(Stage stage) {
        this.stage = stage;
        AddCustomerController controller = new AddCustomerController(this);

        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Label customerLabel = new Label("Customer");
        customerLabel.setStyle("-fx-font-size: 53");
        gridPane.add(customerLabel,0,0,4,4);

        Label fNameLabel = new Label("First Name: ");
        fNameField = new TextField();
        gridPane.add(fNameLabel, 0, 5);
        gridPane.add(fNameField, 1, 5);

        Label lNameLabel = new Label("Last Name: ");
        lNameField = new TextField();
        gridPane.add(lNameLabel, 0, 6);
        gridPane.add(lNameField, 1 ,6);

        Label uNameLabel = new Label("Username: ");
        uNameField = new TextField();
        gridPane.add(uNameLabel, 0, 7);
        gridPane.add(uNameField, 1, 7);

        Label passLabel = new Label("Password: ");
        passField = new PasswordField();
        gridPane.add(passLabel, 0, 8);
        gridPane.add(passField, 1, 8);

        Label userIdLabel = new Label("User Id: ");
        userIdField = new TextField(Integer.toString(User.getUserId()));
        userIdField.setEditable(false);
        gridPane.add(userIdLabel, 0, 9);
        gridPane.add(userIdField, 1, 9);


        Button addButton = new Button("Add Customer");
        gridPane.add(addButton, 0, 10);

        addButton.setOnAction(event -> {
            String fName = fNameField.getText();
            String lName = lNameField.getText();
            String userName = uNameField.getText();
            String pass = passField.getText();
            AddCustomerEventObject ev = new AddCustomerEventObject(this, fName, lName, userName, pass);
            if (addCustomerListener != null) {
                addCustomerListener.btnClicked(ev);
            }
        });

        pane.setTop(employeeMenuBar);
        pane.setCenter(gridPane);
        Scene scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
        stage.setScene(scene);
        stage.show();
    }

    public void setAddCustomerListener(AddCustomerListener addCustomerListener) {
        this.addCustomerListener = addCustomerListener;
    }

    public TextField getfNameField() {
        return fNameField;
    }

    public TextField getlNameField() {
        return lNameField;
    }

    public TextField getuNameField() {
        return uNameField;
    }

    public PasswordField getPassField() {
        return passField;
    }

    public TextField getUserIdField() {
        return userIdField;
    }
}
