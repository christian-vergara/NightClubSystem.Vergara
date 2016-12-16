package Controller.ViewEmployeeController;

import java.util.EventListener;

/**
 * Created by Studio on 12/13/2016.
 */
public interface ViewEmployeeListener extends EventListener {

    void btnClicked(ViewEmployeeEventObject eventObject);

}
