package Controller.ViewTablesController;

import Model.Bags.TableBag;
import Model.Objects.Table;
import View.AddView.AddTableView;
import View.ViewView.ViewTablesView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/12/2016.
 */
public class ViewTablesController {

    private ViewTablesView view;

    public ViewTablesController(ViewTablesView view, Table table){

        this.view = view;

        view.setViewTablesListener(new ViewTablesListener() {
            @Override
            public void btnClicked(ViewTablesEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Update Table");
                confirmAdd.setContentText("Would you like to update this table?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        table.setTblCapacity(eventObject.getTblCapacity());
                        table.setTblNbr(eventObject.getTblNumber());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Updated!");
                        success.setHeaderText("Table Successfully Updated!");
                        success.showAndWait();
                    }
                });

            }
        });


    }

}
