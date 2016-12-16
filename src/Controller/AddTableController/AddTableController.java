package Controller.AddTableController;

import Model.Bags.TableBag;
import Model.Objects.Table;
import View.AddView.AddTableView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.EventObject;

/**
 * Created by Studio on 12/12/2016.
 */
public class AddTableController {

    private AddTableView view;

    public AddTableController(AddTableView view){

        this.view = view;

        view.setAddTableListener(eventObject -> {
            Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAdd.setTitle("Confirm");
            confirmAdd.setHeaderText("Add New Table");
            confirmAdd.setContentText("Would you like to add this table?");
            confirmAdd.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    new Table(eventObject.getTblNumber(), eventObject.getTblCapacity());
                    view.getTblCapacityField().clear();
                    view.getTblNumberField().clear();
                    Alert success = new Alert(Alert.AlertType.INFORMATION);
                    success.setTitle("Added!");
                    success.setHeaderText("Table Added!");
                    success.showAndWait();
                }
            });

        });


    }

}
