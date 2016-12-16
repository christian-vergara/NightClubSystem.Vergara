package Model.Bags;

import Model.Objects.Table;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Studio on 12/12/2016.
 */
public class TableBag implements Serializable{

    protected List<Table> tableList = new ArrayList<>(1);

    public void addTable(Table table) {
        tableList.add(table);
    }

    public void removeTable(Table table) {
        tableList.remove(table);
    }


    public Table findTable(int tblNumber) {
        for(int i = 0;i < tableList.size();i++){
            if (tableList.get(i).getTblNbr() == tblNumber) {
                return tableList.get(i);
            }
        }
        return null;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public Table getTables(int index){
        return tableList.get(index);
    }
}
