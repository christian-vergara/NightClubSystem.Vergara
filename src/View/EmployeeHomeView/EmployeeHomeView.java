package View.EmployeeHomeView;

import App.App;
import Controller.EmployeeHome.EmployeeHomeController;
import Controller.EmployeeHome.MenuItemEventObject;
import Controller.EmployeeHome.MenuItemListener;
import Controller.Login.LoginController;
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
    private static MenuBar employeeMenuBar;
    private MenuItemListener menuItemListener;
    private MenuItem menuItem;
    private MenuItem viewTables, viewCustomer, viewEmployee, viewEntertainer, viewItem;
    private MenuItem addTable, addCustomer, addEmployee, addEntertainer, addItem;


    public EmployeeHomeView(Stage stage) {
        EmployeeHomeView.stage = stage;

        //Set Controller
        EmployeeHomeController controller = new EmployeeHomeController(this);

        //Root BorderPane
        pane = new BorderPane();

        StatusBar statusBar = new StatusBar();
        statusBar.setText(LoginController.getCurrentUser().getfName() + " " + LoginController.getCurrentUser().getlName());

        pane.setBottom(statusBar);

        employeeMenuBar = new MenuBar();
        employeeMenuBar.getStyleClass().add("menuBar");

        //Adding Menu items and setting ID's to pass to controller
        Menu view = new Menu("View");
        viewTables = new MenuItem("Tables");
        viewTables.setId("viewTables");
        viewCustomer = new MenuItem("Customer");
        viewCustomer.setId("viewCustomer");
        viewEntertainer = new MenuItem("Entertainer");
        viewEntertainer.setId("viewEntertainer");
        viewItem = new MenuItem("Item");
        viewItem.setId("viewItem");
        view.getItems().addAll(viewCustomer, viewEntertainer, viewTables, viewItem);

        Menu add = new Menu("Add");
        addCustomer = new MenuItem("Customer");
        addCustomer.setId("addCustomer");
        addEmployee = new MenuItem("Employee");
        addEmployee.setId("addEmployee");
        addEntertainer = new MenuItem("Entertainer");
        addEntertainer.setId("addEntertainer");
        addItem = new MenuItem("Item");
        addItem.setId("addItem");
        addTable = new MenuItem("Table");
        addTable.setId("addTable");
        add.getItems().addAll(addCustomer, addEmployee, addEntertainer, addTable, addItem);



        employeeMenuBar.getMenus().addAll(view, add);

        //Action Events for each menuItem
        //ADD
        addCustomer.setOnAction(event -> {
            MenuItem menuItem = addCustomer;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        addEmployee.setOnAction(event -> {
            MenuItem menuItem = addEmployee;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        addEntertainer.setOnAction(event -> {
            MenuItem menuItem = addEntertainer;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        addItem.setOnAction(event -> {
            MenuItem menuItem = addItem;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        addTable.setOnAction(event -> {
            MenuItem menuItem = addTable;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        //VIEW
        viewCustomer.setOnAction(event -> {
            MenuItem menuItem = viewCustomer;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
   /*     viewEmployee.setOnAction(event -> {
            MenuItem menuItem = viewEmployee;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        }); */
        viewEntertainer.setOnAction(event -> {
            MenuItem menuItem = viewEntertainer;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        viewItem.setOnAction(event -> {
            MenuItem menuItem = viewItem;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });
        viewTables.setOnAction(event -> {
            MenuItem menuItem = viewTables;
            MenuItemEventObject ev = new MenuItemEventObject(this, menuItem);
            if (menuItemListener != null) {
                menuItemListener.itemClicked(ev);
            }
        });

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

    public static MenuBar getEmployeeMenuBar() {
        return employeeMenuBar;
    }
    
    public void setMenuItemListener(MenuItemListener menuItemListener) {
        this.menuItemListener = menuItemListener;
    }




}
