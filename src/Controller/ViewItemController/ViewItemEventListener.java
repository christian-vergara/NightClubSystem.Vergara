package Controller.ViewItemController;

import java.util.EventListener;

/**
 * Created by Studio on 12/13/2016.
 */
public interface ViewItemEventListener extends EventListener{

    void btnClicked(ViewItemEventObject eventObject);

    void btnClickedBeer(ViewBeerEventObject eventObject);

    void btnClickedWine(ViewWineEventObject eventObject);

    void btnClickedLiquor(ViewLiquorEventObject eventObject);

}
