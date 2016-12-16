package View.ManagerHomeView;

import Controller.Login.LoginController;
import Controller.ManagerHomeController.ManagerHomeController;
import Controller.ManagerHomeController.MenuItemEventObjectM;
import Controller.ManagerHomeController.MenuItemListenerM;
import Model.Objects.Employee;
import Model.Objects.User;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;


/**
 * Created by chris on 11/14/2016.
 */
public class ManagerHomeView {

    private static Stage stage;
    private static Scene scene;
    private static User currentUser;
    private BorderPane pane;
    private static MenuBar menuBar;
    private MenuItemListenerM menuItemListenerM;
    private MenuItem menuItem;
    private MenuItem viewTables, viewCustomer, viewEmployee, viewEntertainer, viewItem;
    private MenuItem addTable, addCustomer, addEmployee, addEntertainer, addItem;
    private Employee searchResult;
    private Employee searchManager;

    public ManagerHomeView(Stage stage) {
        ManagerHomeView.stage = stage;

        //Set Controller
        ManagerHomeController controller = new ManagerHomeController(this);

        //Root BorderPane
        pane = new BorderPane();

        StatusBar statusBar = new StatusBar();
        statusBar.setText(LoginController.getCurrentUser().getfName() + " " + LoginController.getCurrentUser().getlName());

        pane.setBottom(statusBar);

        menuBar = new MenuBar();
        menuBar.getStyleClass().add("menuBar");

        //Adding Menu items and setting ID's to pass to controller
        Menu view = new Menu("View");
        viewTables = new MenuItem("Tables");
        viewTables.setId("viewTables");
        viewCustomer = new MenuItem("Customer");
        viewCustomer.setId("viewCustomer");
        viewEntertainer = new MenuItem("Entertainer");
        viewEntertainer.setId("viewEntertainer");
        viewEmployee = new MenuItem("Employee");
        viewEmployee.setId("viewEmployee");
        viewItem = new MenuItem("Item");
        viewItem.setId("viewItem");
        view.getItems().addAll(viewCustomer, viewEntertainer,viewEmployee, viewTables, viewItem);

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



        menuBar.getMenus().addAll(view, add);

        //Action Events for each menuItem
        //ADD
        addCustomer.setOnAction(event -> {
            MenuItem menuItem = addCustomer;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        addEmployee.setOnAction(event -> {
            MenuItem menuItem = addEmployee;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        addEntertainer.setOnAction(event -> {
            MenuItem menuItem = addEntertainer;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        addItem.setOnAction(event -> {
            MenuItem menuItem = addItem;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        addTable.setOnAction(event -> {
            MenuItem menuItem = addTable;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        //VIEW
        viewCustomer.setOnAction(event -> {
            MenuItem menuItem = viewCustomer;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        viewEmployee.setOnAction(event -> {
            MenuItem menuItem = viewEmployee;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        viewEntertainer.setOnAction(event -> {
            MenuItem menuItem = viewEntertainer;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        viewItem.setOnAction(event -> {
            MenuItem menuItem = viewItem;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });
        viewTables.setOnAction(event -> {
            MenuItem menuItem = viewTables;
            MenuItemEventObjectM ev = new MenuItemEventObjectM(this, menuItem);
            if (menuItemListenerM != null) {
                menuItemListenerM.itemClicked(ev);
            }
        });

        pane.setTop(menuBar);
        scene = new Scene(pane, 1280, 720);
        scene.getStylesheets().add("View/EmployeeHomeView/EmployeeHomeView.css");
        stage.setScene(scene);
        stage.show();

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        ManagerHomeView.currentUser = currentUser;
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

    public static MenuBar getMenuBar() {
        return menuBar;
    }
    
    public void setMenuItemListener(MenuItemListenerM menuItemListener) {
        this.menuItemListenerM = menuItemListener;
    }




}
