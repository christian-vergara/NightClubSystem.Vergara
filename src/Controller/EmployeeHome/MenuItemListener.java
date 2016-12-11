package Controller.EmployeeHome;

import java.util.EventListener;

/**
 * Created by chris on 12/10/2016.
 */
public interface MenuItemListener extends EventListener {
    void itemClicked(MenuItemEventObject ev);

}
