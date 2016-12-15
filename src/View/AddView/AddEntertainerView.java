package View.AddView;

import Controller.AddEntertainerController.AddEntertainerController;
import Controller.AddEntertainerController.AddEntertainerEventObject;
import Controller.AddEntertainerController.AddEntertainerListener;
import Model.Objects.User;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by chris on 12/10/2016.
 */
public class AddEntertainerView {

    private TextField fNameField;
    private TextField lNameField;
    private TextField uNameField;
    private PasswordField passField;
    private TextField typeField;
    private TextField payField;
    private TextField userIdField;
    private Button addButton;
    private Stage stage;
    private AddEntertainerListener addEntertainerListener;

    public AddEntertainerView(Stage stage) {
        this.stage = stage;
        AddEntertainerController controller = new AddEntertainerController(this);

        BorderPane root = new BorderPane();
        root.setTop(EmployeeHomeView.getEmployeeMenuBar());

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setVgap(5);
        pane.setHgap(5);
        root.setCenter(pane);

        Label addEntertainer = new Label("Add Entertainer");
        addEntertainer.setStyle("-fx-font-size: 53");
        pane.add(addEntertainer, 0, 0, 4, 4);

        Label fNameLabel = new Label("First Name: ");
        fNameField = new TextField();
        pane.add(fNameLabel, 0, 5);
        pane.add(fNameField, 1, 5);

        Label lNameLabel = new Label("Last Name: ");
        lNameField = new TextField();
        pane.add(lNameLabel, 0, 6);
        pane.add(lNameField, 1, 6);

        Label uNameLabel = new Label("Username: ");
        uNameField = new TextField();
        pane.add(uNameLabel, 0, 7);
        pane.add(uNameField, 1, 7);

        Label passlabel = new Label("Password: ");
        passField = new PasswordField();
        pane.add(passlabel, 0, 8);
        pane.add(passField, 1, 8);

        Label typeLabel = new Label("Type: ");
        typeField = new TextField();
        pane.add(typeLabel, 0, 9);
        pane.add(typeField, 1, 9);

        Label payLabel = new Label("Pay: ");
        payField = new TextField();
        pane.add(payLabel, 0, 10);
        pane.add(payField, 1, 10);

        Label userIdLabel = new Label("User Id: ");
        userIdField = new TextField(Integer.toString(User.getCount()));
        userIdField.setEditable(false);
        pane.add(userIdLabel, 0, 11);
        pane.add(userIdField, 1, 11);

        addButton = new Button("Add Entertainer");
        pane.add(addButton, 0, 12);
        addButton.setOnAction(event -> {
            String fName = fNameField.getText();
            String lName = lNameField.getText();
            String uName = uNameField.getText();
            String pass = passField.getText();
            String type = typeField.getText();
            Double pay = Double.parseDouble(payField.getText());
            AddEntertainerEventObject eventObject = new AddEntertainerEventObject(this, fName, lName, uName, pass, type, pay);
            if (addEntertainerListener != null) {
                addEntertainerListener.btnClicked(eventObject);
            }
        });

        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
        stage.setScene(scene);
        stage.show();
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

    public TextField getTypeField() {
        return typeField;
    }

    public TextField getPayField() {
        return payField;
    }

    public TextField getUserIdField() {
        return userIdField;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddEntertainerListener(AddEntertainerListener addEntertainerListener) {
        this.addEntertainerListener = addEntertainerListener;
    }
}
