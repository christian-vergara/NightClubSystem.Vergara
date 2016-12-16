package Controller.CustomerHomeController;

import java.util.EventListener;

/**
 * Created by Studio on 12/16/2016.
 */
public interface CustomerHomeEventListener extends EventListener {

    void btnClicked(CustomerHomeEventObject customerHomeEventObject);

}
