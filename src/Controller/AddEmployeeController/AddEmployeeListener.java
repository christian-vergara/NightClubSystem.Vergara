package Controller.AddEmployeeController;

import java.util.EventListener;

/**
 * Created by Studio on 12/13/2016.
 */
public interface AddEmployeeListener extends EventListener {

    void btnClicked(AddEmployeeEventObject eventObject);

}
