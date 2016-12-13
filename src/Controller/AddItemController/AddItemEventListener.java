package Controller.AddItemController;

import java.util.EventListener;

/**
 * Created by Studio on 12/13/2016.
 */
public interface AddItemEventListener extends EventListener{

    void btnClicked(AddItemEventObject eventObject);

}
