package View.EmployeeHomeView;

import Controller.Main.MainController;
import Model.Objects.User;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;

import java.util.EventListener;


/**
 * Created by chris on 11/14/2016.
 */
public class EmployeeHomeView {

    private static Stage stage;
    private static Scene scene;
    private static User currentUser;
    private BorderPane pane;
    private MenuBar employeeMenuBar;
    private EventListener menuItemListener;

    private MenuItem viewTables, viewCustomer, viewEmployee, viewEntertainer, viewItem;
    private MenuItem addTable, addCustomer, addEmployee, addEntertainer, addItem;

    public EmployeeHomeView(Stage stage) {
        EmployeeHomeView.stage = stage;

        //Root BorderPane
        pane = new BorderPane();

        employeeMenuBar = new MenuBar();
        employeeMenuBar.getStyleClass().add("menuBar");

        StatusBar statusBar = new StatusBar();
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
        scene.getStylesheets().add("View/EmployeeHomeView/EmployeeHomeView.css");
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

    public void setMenuItemListener(EventListener manuItemListener) {
        this.menuItemListener = menuItemListener;
    }

    public MenuItem getViewTables() {
        return viewTables;
    }

    public MenuItem getViewCustomer() {
        return viewCustomer;
    }

    public MenuItem getViewEmployee() {
        return viewEmployee;
    }

    public MenuItem getViewEntertainer() {
        return viewEntertainer;
    }

    public MenuItem getViewItem() {
        return viewItem;
    }

    public MenuItem getAddTable() {
        return addTable;
    }

    public MenuItem getAddCustomer() {
        return addCustomer;
    }

    public MenuItem getAddEmployee() {
        return addEmployee;
    }

    public MenuItem getAddEntertainer() {
        return addEntertainer;
    }

    public MenuItem getAddItem() {
        return addItem;
    }
}
