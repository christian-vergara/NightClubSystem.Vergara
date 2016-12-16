package Controller.ManagerHomeController;

import View.AddView.*;
import View.ManagerHomeView.ManagerHomeView;
import View.ViewView.*;
import javafx.scene.control.MenuItem;

/**
 * Created by chris on 12/10/2016.
 */
public class ManagerHomeController {

    private ManagerHomeView view;
    private MenuItem menuItem;

    public ManagerHomeController(ManagerHomeView view) {

        this.view = view;
        view.setMenuItemListener(new MenuItemListenerM() {

            //Change scene based on what item is clicked
            @Override
            public void itemClicked(MenuItemEventObjectM ev) {
                switch (ev.getMenuItem().getId()) {
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
                    case "viewEmployee":
                        ViewEmployeeView viewEmployeeView = new ViewEmployeeView(App.App.getPrimaryStage());
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
                    case "addEmployee":
                        AddEmployeeView addEmployeeView = new AddEmployeeView(App.App.getPrimaryStage());
                        break;
                }
            }

        });

    }


}



