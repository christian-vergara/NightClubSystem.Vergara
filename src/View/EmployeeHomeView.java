package View;

import Controller.MainController;
import Model.Employee;
import Model.User;
import Model.UserBag;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;


/**
 * Created by chris on 11/14/2016.
 */
public class EmployeeHomeView {

    private static Stage stage;
    private static Scene scene;
    private static StatusBar statusBar;
    private static User currentUser;
    private BorderPane pane;
    private MenuBar employeeMenuBar;

    public EmployeeHomeView(Stage stage) {
        this.stage = stage;

        //Root BorderPane
        pane = new BorderPane();

        employeeMenuBar = new MenuBar();
        employeeMenuBar.getStyleClass().add("menuBar");

        statusBar = new StatusBar();
        statusBar.setText("\tCustomers: " + "\t\tTables: "+ "\t\tEmployees: " + "\t\tEntertainers: " + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + MainController.getCurrentUser().getfName() + " " + MainController.getCurrentUser().getlName());

        pane.setBottom(statusBar);

        Menu file = new Menu("File");
        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        file.getItems().addAll(save, load);

        Menu view = new Menu("View");
        MenuItem viewTables = new MenuItem("Tables");
        MenuItem viewCustomer = new MenuItem("Customer");
        MenuItem viewEmployee = new MenuItem("Employee");
        MenuItem viewEntertainer = new MenuItem("Entertainer");
        MenuItem viewItem = new MenuItem("Item");
        view.getItems().addAll(viewCustomer, viewEmployee, viewEntertainer, viewTables, viewItem);

        Menu add = new Menu("Add");
        MenuItem addCustomer = new MenuItem("Customer");
        MenuItem addEmployee = new MenuItem("Employee");
        MenuItem addEntertainer = new MenuItem("Entertainer");
        MenuItem addItem = new MenuItem("Item");
        MenuItem addTable = new MenuItem("Table");
        add.getItems().addAll(addCustomer, addEmployee, addEntertainer, addTable, addItem);

        employeeMenuBar.getMenus().addAll(file, view, add);


        pane.setTop(employeeMenuBar);
        scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().add("View/EmployeeHomeView.css");
        stage.setScene(scene);
        stage.show();

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        EmployeeHomeView.currentUser = currentUser;
    }

    public static Stage getStage() {
        return stage;
    }


    public static Scene getScene() {
        return scene;
    }

    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    public MenuBar getEmployeeMenuBar() {
        return employeeMenuBar;
    }

    public void setEmployeeMenuBar(MenuBar employeeMenuBar) {
        this.employeeMenuBar = employeeMenuBar;
    }
}
