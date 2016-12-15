package View.ViewView;

import App.App;
import Controller.ViewEntertainerController.ViewEntertainerController;
import Controller.ViewEntertainerController.ViewEntertainerEventObject;
import Controller.ViewEntertainerController.ViewEntertainerListener;
import Model.Objects.Entertainer;
import Model.Objects.User;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by chris on 12/10/2016.
 */
public class ViewEntertainerView {
    private TextField fNameField;
    private TextField lNameField;
    private TextField uNameField;
    private PasswordField passField;
    private TextField typeField;
    private TextField payField;
    private TextField userIdField;
    private Stage stage;
    private User searchResult;
    private Entertainer searchEntertainer;
    private ViewEntertainerListener viewEntertainerListener;

    public ViewEntertainerView(Stage stage) {
        this.stage = stage;

        this.stage = stage;

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Find Entertainer");
        dialog.setHeaderText("Enter User ID");

        Optional<String> result = dialog.showAndWait();

        if (App.getUserBag().findUser(Integer.parseInt(result.get())) != null) {
            searchResult = App.getUserBag().findUser(Integer.parseInt(result.get()));
            searchEntertainer = (Entertainer) searchResult;

            ViewEntertainerController controller = new ViewEntertainerController(this, searchEntertainer);

            BorderPane root = new BorderPane();
            root.setTop(EmployeeHomeView.getEmployeeMenuBar());

            GridPane pane = new GridPane();
            pane.setPadding(new Insets(5));
            pane.setVgap(5);
            pane.setHgap(5);
            root.setCenter(pane);

            Label addEntertainer = new Label("Entertainer");
            addEntertainer.setStyle("-fx-font-size: 53");
            pane.add(addEntertainer, 0, 0, 4, 4);

            Label fNameLabel = new Label("First Name: ");
            fNameField = new TextField(searchResult.getfName());
            pane.add(fNameLabel, 0, 5);
            pane.add(fNameField, 1, 5);

            Label lNameLabel = new Label("Last Name: ");
            lNameField = new TextField(searchResult.getlName());
            pane.add(lNameLabel, 0, 6);
            pane.add(lNameField, 1, 6);

            Label uNameLabel = new Label("Username: ");
            uNameField = new TextField(searchResult.getUserName());
            pane.add(uNameLabel, 0, 7);
            pane.add(uNameField, 1, 7);

            Label passlabel = new Label("Password: ");
            passField = new PasswordField();
            getPassField().setText(searchResult.getPassword());
            pane.add(passlabel, 0, 8);
            pane.add(passField, 1, 8);

            Label typeLabel = new Label("Type: ");
            typeField = new TextField(searchResult.getType());
            pane.add(typeLabel, 0, 9);
            pane.add(typeField, 1, 9);

            Label payLabel = new Label("Pay: ");
            payField = new TextField(Double.toString(searchEntertainer.getPay()));
            pane.add(payLabel, 0, 10);
            pane.add(payField, 1, 10);

            Label userIdLabel = new Label("User Id: ");
            userIdField = new TextField(Integer.toString(User.getCount()));
            userIdField.setEditable(false);
            pane.add(userIdLabel, 0, 11);
            pane.add(userIdField, 1, 11);

            Button updateButton = new Button("Update Entertainer");
            pane.add(updateButton, 0, 12);
            updateButton.setOnAction(event -> {
                String fName = fNameField.getText();
                String lName = lNameField.getText();
                String uName = uNameField.getText();
                String pass = passField.getText();
                String type = typeField.getText();
                Double pay = Double.parseDouble(payField.getText());
                ViewEntertainerEventObject eventObject = new ViewEntertainerEventObject(this, fName, lName, uName, pass, type, pay);
                if (viewEntertainerListener != null) {
                    viewEntertainerListener.btnClicked(eventObject);
                }
            });

            Scene scene = new Scene(root, 1280, 720);
            scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
            stage.setScene(scene);
            stage.show();
        }
    }

    public TextField getfNameField() {
        return fNameField;
    }

    public void setfNameField(TextField fNameField) {
        this.fNameField = fNameField;
    }

    public TextField getlNameField() {
        return lNameField;
    }

    public void setlNameField(TextField lNameField) {
        this.lNameField = lNameField;
    }

    public TextField getuNameField() {
        return uNameField;
    }

    public void setuNameField(TextField uNameField) {
        this.uNameField = uNameField;
    }

    public PasswordField getPassField() {
        return passField;
    }

    public void setPassField(PasswordField passField) {
        this.passField = passField;
    }

    public TextField getTypeField() {
        return typeField;
    }

    public void setTypeField(TextField typeField) {
        this.typeField = typeField;
    }

    public TextField getPayField() {
        return payField;
    }

    public void setPayField(TextField payField) {
        this.payField = payField;
    }

    public TextField getUserIdField() {
        return userIdField;
    }

    public void setUserIdField(TextField userIdField) {
        this.userIdField = userIdField;
    }

    public void setViewEntertainerListener(ViewEntertainerListener viewEntertainerListener) {
        this.viewEntertainerListener = viewEntertainerListener;
    }

    public User getSearchResult() {
        return searchResult;
    }
}
