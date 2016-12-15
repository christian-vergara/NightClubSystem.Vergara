package Controller.ViewCustomerController;

import java.util.EventListener;

/**
 * Created by Studio on 12/12/2016.
 */
public interface ViewCustomerListener extends EventListener {

    void btnClicked(ViewCustomerEventObject eventObject);

}
