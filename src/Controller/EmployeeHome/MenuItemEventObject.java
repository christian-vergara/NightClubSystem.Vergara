package Controller.EmployeeHome;

import javafx.scene.control.MenuItem;

import java.util.EventListener;
import java.util.EventObject;

/**
 * Created by chris on 12/10/2016.
 */
public class MenuItemEventObject extends EventObject{

    private MenuItem menuItem;

    public MenuItemEventObject(Object source) {
        super(source);
    }

    public MenuItemEventObject(Object source, MenuItem menuItem) {
        super(source);
        this.menuItem = menuItem
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }
}
