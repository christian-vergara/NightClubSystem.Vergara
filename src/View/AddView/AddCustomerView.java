package View.AddView;

import Controller.Login.LoginController;
import Model.Bags.TableBag;
import View.EmployeeHomeView.EmployeeHomeView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by chris on 12/10/2016.
 */
public class AddCustomerView {

    private Stage stage;
    private MenuBar employeeMenuBar = EmployeeHomeView.getEmployeeMenuBar();

    public AddCustomerView(Stage stage) {
        this.stage = stage;

        BorderPane pane = new BorderPane();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Label customerLabel = new Label("Customer");
        customerLabel.setStyle("-fx-font-size: 53");
        gridPane.add(customerLabel,0,0,4,4);

        Label fNameLabel = new Label("First Name: ");
        TextField fNameField = new TextField();
        gridPane.add(fNameLabel, 0, 5);
        gridPane.add(fNameField, 1, 5);

        Label lNameLabel = new Label("Last Name: ");
        TextField lNameField = new TextField();
        gridPane.add(lNameLabel, 0, 6);
        gridPane.add(lNameField, 1 ,6);

        Label uNameLabel = new Label("Username: ");
        TextField uNameField = new TextField();
        gridPane.add(uNameLabel, 0, 7);
        gridPane.add(uNameField, 1, 7);

        pane.setTop(employeeMenuBar);
        pane.setCenter(gridPane);
        Scene scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().add("View/AddView/AddCustomerStyle.css");
        stage.setScene(scene);
        stage.show();
    }
}
