package Controller.ManagerHomeController;

import javafx.scene.control.MenuItem;

import java.util.EventObject;

/**
 * Created by chris on 12/10/2016.
 */
public class MenuItemEventObjectM extends EventObject{

    private MenuItem menuItem;

    public MenuItemEventObjectM(Object source) {
        super(source);
    }

    public MenuItemEventObjectM(Object source, MenuItem menuItem) {
        super(source);
        this.menuItem = menuItem;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
