package Controller.CustomerHomeController;

import java.util.EventObject;

/**
 * Created by Studio on 12/16/2016.
 */
public class CustomerHomeEventObject extends EventObject {

    private int ticketAmount;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomerHomeEventObject(Object source) {
        super(source);
    }

}
