package Controller.AddTableController;

import Model.Objects.Table;

import java.util.EventObject;

/**
 * Created by Studio on 12/12/2016.
 */
public class AddTableEventObject extends EventObject {

    private int tblNumber;
    private int tblCapacity;

    public AddTableEventObject(Object source){
        super(source);
    }

    public AddTableEventObject(Object source, int tblNumber, int tblCapacity ) {
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
