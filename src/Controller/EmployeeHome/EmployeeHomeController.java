package Controller.EmployeeHome;

import Controller.Main.MyEventListener;
import View.AddView.AddCustomerView;
import View.AddView.AddEntertainerView;
import View.AddView.AddItemView;
import View.AddView.AddTableView;
import View.EmployeeHomeView.EmployeeHomeView;
import View.ViewView.ViewCustomerView;
import View.ViewView.ViewEntertainerView;
import View.ViewView.ViewItemView;
import View.ViewView.ViewTablesView;
import javafx.scene.control.MenuItem;

/**
 * Created by chris on 12/10/2016.
 */
public class EmployeeHomeController {

    private EmployeeHomeView view;
    private MyEventListener menuItemListener;
    private MenuItem menuItem;

    public EmployeeHomeController(MenuItem menuItem, EmployeeHomeView view) {
        this.view = view;
        this.menuItem = menuItem;
        view.setMenuItemListener(new MenuItemListener() {

            @Override
            public void itemClicked(MenuItemEventObject eventObject) {

            }

        });

        switch (menuItem.getId()) {
            case "viewCustomer":
                ViewCustomerView viewCustomerView = new ViewCustomerView(App.App.getPrimaryStage());
                        break;
            case "viewEntertainer":
                ViewEntertainerView viewEntertainerView = new ViewEntertainerView(App.App.getPrimaryStage());
                        break;
            case "viewTables":
                ViewTablesView viewTablesView = new ViewTablesView(App.App.getPrimaryStage());
                        break;
            case "viewItem":
                ViewItemView viewItemView = new ViewItemView(App.App.getPrimaryStage());
                        break;
            case "addCustomer":
                AddCustomerView addCustomerView = new AddCustomerView(App.App.getPrimaryStage());
                        break;
            case "addEntertainer":
                AddEntertainerView addEntertainerView = new AddEntertainerView(App.App.getPrimaryStage());
                        break;
            case "addTable":
                AddTableView addTableView = new AddTableView(App.App.getPrimaryStage());
                        break;
            case "addItem":
                AddItemView addItemView = new AddItemView(App.App.getPrimaryStage());
                        break;
        }
    }

}
