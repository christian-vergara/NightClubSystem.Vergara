package View.ViewView;

import App.App;
import Controller.Login.LoginController;
import Controller.ViewCustomerController.ViewCustomerController;
import Controller.ViewCustomerController.ViewCustomerEventObject;
import Controller.ViewCustomerController.ViewCustomerListener;
import Model.Objects.Customer;
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
 * Created by chris on 12/10/2016.
 */
public class ViewCustomerView {

    private TextField userIdField;
    private Stage stage;
    private MenuBar employeeMenuBar = EmployeeHomeView.getEmployeeMenuBar();
    private ViewCustomerListener viewCustomerListener;
    private TextField fNameField, lNameField, uNameField;
    private PasswordField passField;
    private User searchResult;


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

    public User getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(User searchResult) {
        this.searchResult = searchResult;
    }

    public ViewCustomerView(Stage stage) {
        this.stage = stage;


        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Find Customer");
        dialog.setHeaderText("Enter User ID");

        Optional<String> result = dialog.showAndWait();

        if (App.getUserBag().findUser(Integer.parseInt(result.get())) != null) {
            searchResult = (Customer) App.getUserBag().findUser(Integer.parseInt(result.get()));

            ViewCustomerController controller = new ViewCustomerController(this);

            BorderPane pane = new BorderPane();
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(5));
            gridPane.setHgap(5);
            gridPane.setVgap(5);

            Label customerLabel = new Label("Customer");
            customerLabel.setStyle("-fx-font-size: 53");
            gridPane.add(customerLabel, 0, 0, 4, 4);

            Label fNameLabel = new Label("First Name: ");
            fNameField = new TextField(searchResult.getfName());
            gridPane.add(fNameLabel, 0, 5);
            gridPane.add(fNameField, 1, 5);

            Label lNameLabel = new Label("Last Name: ");
            lNameField = new TextField(searchResult.getlName());
            gridPane.add(lNameLabel, 0, 6);
            gridPane.add(lNameField, 1, 6);

            Label uNameLabel = new Label("Username: ");
            uNameField = new TextField(searchResult.getUserName());
            gridPane.add(uNameLabel, 0, 7);
            gridPane.add(uNameField, 1, 7);

            Label passLabel = new Label("Password: ");
            passField = new PasswordField();
            passField.setText(searchResult.getPassword());
            gridPane.add(passLabel, 0, 8);
            gridPane.add(passField, 1, 8);

            Label userIdLabel = new Label("User Id: ");
            userIdField = new TextField(Integer.toString(searchResult.getUserId()));
            userIdField.setEditable(false);
            gridPane.add(userIdLabel, 0, 9);
            gridPane.add(userIdField, 1, 9);


            Button updateButton = new Button("Update Customer");
            gridPane.add(updateButton, 0, 10);

            updateButton.setOnAction(event -> {
                String fName = fNameField.getText();
                String lName = lNameField.getText();
                String userName = uNameField.getText();
                String pass = passField.getText();
                ViewCustomerEventObject ev = new ViewCustomerEventObject(this, fName, lName, userName, pass);
                if (viewCustomerListener != null) {
                    viewCustomerListener.btnClicked(ev);
                }
            });

            Employee searchResult = (Employee) LoginController.getCurrentUser();
            if (searchResult.getRank().equals("General")) {
                pane.setTop(EmployeeHomeView.getEmployeeMenuBar());
            } else if(searchResult.getRank().equals("Manager") || searchResult.getRank().equals("Owner")){
                pane.setTop(ManagerHomeView.getMenuBar());
            }
            pane.setCenter(gridPane);
            Scene scene = new Scene(pane, 1280, 720);
            scene.getStylesheets().add("View/AddView/AddStyleSheet.css");
            stage.setScene(scene);
            stage.show();
        }
    }

        public void setViewCustomerListener(ViewCustomerListener viewCustomerListener) {
            this.viewCustomerListener = viewCustomerListener;
        }



    }

