package Model;

import java.util.EventListener;

/**
 * Created by chris on 11/9/2016.
 */
public interface MyEventListener extends EventListener {
    void btnClicked(MyEventObject ev);
}
