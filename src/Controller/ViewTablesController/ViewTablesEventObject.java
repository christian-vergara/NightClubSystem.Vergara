package Controller.ViewTablesController;

import java.util.EventObject;

/**
 * Created by Studio on 12/12/2016.
 */
public class ViewTablesEventObject extends EventObject {

    private int tblNumber;
    private int tblCapacity;

    public ViewTablesEventObject(Object source){
        super(source);
    }

    public ViewTablesEventObject(Object source, int tblNumber, int tblCapacity ) {
        super(source);
        this.tblNumber = tblNumber;
        this.tblCapacity = tblCapacity;

    }

    public int getTblNumber() {
        return tblNumber;
    }

    public int getTblCapacity() {
        return tblCapacity;
    }
}
