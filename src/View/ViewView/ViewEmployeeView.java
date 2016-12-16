package View.ViewView;

import App.App;
import Controller.Login.LoginController;
import Controller.ViewEmployeeController.ViewEmployeeController;
import Controller.ViewEmployeeController.ViewEmployeeEventObject;
import Controller.ViewEmployeeController.ViewEmployeeListener;
import Model.Objects.Employee;
import Model.Objects.User;
import View.EmployeeHomeView.EmployeeHomeView;
import View.ManagerHomeView.ManagerHomeView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by Studio on 12/13/2016.
 */
public class ViewEmployeeView {

    private TextField userIdField;
    private TextField leaveDateField;
    private Stage stage;
    private TextField fNameField, lNameField, uNameField, passField, rankField, payTypeField, payField,
            hiringDateField;
    private ViewEmployeeListener viewEmployeeListener;
    private Employee searchResult;
    private Employee search;

    public ViewEmployeeView(Stage stage) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Find Employee");
        dialog.setHeaderText("Enter User ID");

        Optional<String> result = dialog.showAndWait();

        if (App.getUserBag().findUser(Integer.parseInt(result.get())) != null) {
            this.stage = stage;
            search = (Employee) App.getUserBag().findUser(Integer.parseInt(result.get()));
            BorderPane root = new BorderPane();

            ViewEmployeeController controller = new ViewEmployeeController(this, search);

            searchResult = (Employee) LoginController.getCurrentUser();
            if (searchResult.getRank().equals("General")) {
                root.setTop(EmployeeHomeView.getEmployeeMenuBar());
            } else if(searchResult.getRank().equals("Manager") || searchResult.getRank().equals("Owner")){
                root.setTop(ManagerHomeView.getMenuBar());
            }


            GridPane pane = new GridPane();
            pane.setPadding(new Insets(5));
            pane.setHgap(5);
            pane.setVgap(5);

            Label newEmployee = new Label("Employee");
            newEmployee.setStyle("-fx-font-size: 53");
            pane.add(newEmployee, 0, 0, 4, 4);

            Label fNameLabel = new Label("First Name: ");
            fNameField = new TextField(search.getfName());
            pane.add(fNameLabel, 0, 5);
            pane.add(fNameField, 1, 5);

            Label lNameLabel = new Label("Last Name: ");
            lNameField = new TextField(search.getlName());
            pane.add(lNameLabel, 0, 6);
            pane.add(lNameField, 1, 6);

            Label uNameLabel = new Label("Username: ");
            uNameField = new TextField(search.getUserName());
            pane.add(uNameLabel, 0, 7);
            pane.add(uNameField, 1, 7);

            Label passLabel = new Label("Password: ");
            passField = new TextField(search.getPassword());
            pane.add(passLabel, 0, 8);
            pane.add(passField, 1, 8);

            Label rankLabel = new Label("Rank: ");
            rankField = new TextField(search.getRank());
            pane.add(rankLabel, 0, 9);
            pane.add(rankField, 1, 9);

            Label payTypeLabel = new Label("Pay Type: ");
            payTypeField = new TextField(search.getPayType());
            pane.add(payTypeLabel, 0, 10);
            pane.add(payTypeField, 1, 10);

            Label payLabel = new Label("Pay: ");
            payField = new TextField(Double.toString(search.getPay()));
            pane.add(payLabel, 0, 11);
            pane.add(payField, 1, 11);

            Label hiringDateLabel = new Label("Hiring Date: ");
            hiringDateField = new TextField(search.getHiringDate());
            pane.add(hiringDateLabel, 0, 12);
            pane.add(hiringDateField, 1, 12);

            Label leaveDateLabel = new Label("Leave Date: ");
            leaveDateField = new TextField(search.getLeaveDate());
            pane.add(leaveDateLabel, 0, 13);
            pane.add(leaveDateField, 1, 13);

            Label userIdLabel = new Label("User ID: ");
            userIdField = new TextField(Integer.toString(search.getUserId()));
            userIdField.setEditable(false);
            pane.add(userIdLabel, 0, 14);
            pane.add(userIdField, 1, 14);

            Button addButton = new Button("Update Employee");
            pane.add(addButton, 0, 15);
            addButton.setOnAction(event -> {
                String fName = fNameField.getText();
                String lName = lNameField.getText();
                String uName = uNameField.getText();
                String pass = passField.getText();
                String rank = rankField.getText();
                String payType = payTypeField.getText();
                Double pay = Double.parseDouble(payField.getText());
                String hiringDate = hiringDateField.getText();
                String leaveDate = leaveDateField.getText();
                ViewEmployeeEventObject eventObject = new ViewEmployeeEventObject(this, fName, lName, uName, pass, rank
                        , payType, pay, hiringDate, leaveDate);
                if (viewEmployeeListener != null) {
                    viewEmployeeListener.btnClicked(eventObject);
                }

        });

            root.setCenter(pane);
            Scene scene = new Scene(root, 1280, 720);
            scene.getStylesheets().addAll("View/AddView/AddStyleSheet.css");
            stage.setScene(scene);
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect ID");
            alert.setHeaderText("Please enter a valid ID");
            alert.showAndWait();
        }

    }

    public TextField getUserIdField() {
        return userIdField;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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

    public TextField getPassField() {
        return passField;
    }

    public void setPassField(TextField passField) {
        this.passField = passField;
    }

    public TextField getRankField() {
        return rankField;
    }

    public void setRankField(TextField rankField) {
        this.rankField = rankField;
    }

    public TextField getPayTypeField() {
        return payTypeField;
    }

    public void setPayTypeField(TextField payTypeField) {
        this.payTypeField = payTypeField;
    }

    public TextField getPayField() {
        return payField;
    }

    public void setPayField(TextField payField) {
        this.payField = payField;
    }

    public TextField getHiringDateField() {
        return hiringDateField;
    }

    public void setHiringDateField(TextField hiringDateField) {
        this.hiringDateField = hiringDateField;
    }

    public ViewEmployeeListener getViewEmployeeListener() {
        return viewEmployeeListener;
    }

    public void setViewEmployeeListener(ViewEmployeeListener viewEmployeeListener) {
        this.viewEmployeeListener = viewEmployeeListener;
    }

}
