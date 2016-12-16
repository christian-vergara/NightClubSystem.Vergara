package View.AddView;

import Controller.AddEmployeeController.AddEmployeeController;
import Controller.AddEmployeeController.AddEmployeeEventObject;
import Controller.AddEmployeeController.AddEmployeeListener;
import Controller.Login.LoginController;
import Model.Objects.Employee;
import Model.Objects.User;
import View.EmployeeHomeView.EmployeeHomeView;
import View.ManagerHomeView.ManagerHomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Studio on 12/13/2016.
 */
public class AddEmployeeView {


    private final TextField userIdField;
    private Stage stage;
    private TextField fNameField, lNameField, uNameField, passField, rankField, payTypeField, payField,
    hiringDateField;
    private AddEmployeeListener addEmployeeListener;

    public AddEmployeeView(Stage stage) {

        this.stage = stage;
        AddEmployeeController controller = new AddEmployeeController(this);

        BorderPane root = new BorderPane();
        Employee searchResult = (Employee) LoginController.getCurrentUser();
        if (searchResult.getRank().equals("General")) {
            root.setTop(EmployeeHomeView.getEmployeeMenuBar());
        } else if(searchResult.getRank().equals("Manager") || searchResult.getRank().equals("Owner")){
            root.setTop(ManagerHomeView.getMenuBar());
        }
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5));
        pane.setHgap(5);
        pane.setVgap(5);


        Label newEmployee = new Label("New Employee");
        newEmployee.setStyle("-fx-font-size: 53");
        pane.add(newEmployee, 0, 0, 4, 4);

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

        Label passLabel = new Label("Password: ");
        passField = new TextField();
        pane.add(passLabel, 0, 8);
        pane.add(passField, 1, 8);

        Label rankLabel = new Label("Rank: ");
        rankField = new TextField();
        pane.add(rankLabel, 0, 9);
        pane.add(rankField, 1, 9);

        Label payTypeLabel = new Label("Pay Type: ");
        payTypeField = new TextField();
        pane.add(payTypeLabel, 0, 10);
        pane.add(payTypeField, 1, 10);

        Label payLabel = new Label("Pay: ");
        payField = new TextField();
        pane.add(payLabel, 0, 11);
        pane.add(payField, 1, 11);

        Label hiringDateLabel = new Label("Hiring Date: ");
        hiringDateField = new TextField();
        pane.add(hiringDateLabel, 0, 12);
        pane.add(hiringDateField, 1, 12);

        Label userIdLabel = new Label("User ID: ");
        userIdField = new TextField(Integer.toString(User.getCount()));
        userIdField.setEditable(false);
        pane.add(userIdLabel, 0, 13);
        pane.add(userIdField, 1, 13);

        Button addButton = new Button("Add Employee");
        pane.add(addButton, 0, 14);
        addButton.setOnAction(event -> {
            String fName = fNameField.getText();
            String lName = lNameField.getText();
            String uName = uNameField.getText();
            String pass = passField.getText();
            String rank = rankField.getText();
            String payType = payTypeField.getText();
            Double pay = Double.parseDouble(payField.getText());
            AddEmployeeEventObject eventObject = new AddEmployeeEventObject(this, fName, lName, uName, pass, rank
                    , payType, pay, "NA");
            if (addEmployeeListener != null) {
                addEmployeeListener.btnClicked(eventObject);
            }
        });


        root.setCenter(pane);
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().addAll("View/AddView/AddStyleSheet.css");
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

    public TextField getPassField() {
        return passField;
    }

    public TextField getRankField() {
        return rankField;
    }

    public TextField getPayTypeField() {
        return payTypeField;
    }

    public TextField getPayField() {
        return payField;
    }

    public TextField getHiringDateField() {
        return hiringDateField;
    }

    public TextField getUserIdField() {
        return userIdField;
    }

    public void setAddEmployeeListener(AddEmployeeListener addEmployeeListener) {
        this.addEmployeeListener = addEmployeeListener;
    }

}
