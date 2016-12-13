package Controller.AddCustomerController;

import View.AddView.AddCustomerView;

import java.util.EventListener;
import java.util.EventObject;

/**
 * Created by Studio on 12/12/2016.
 */
public interface AddCustomerListener extends EventListener {

    void btnClicked(AddCustomerEventObject eventObject);

}
