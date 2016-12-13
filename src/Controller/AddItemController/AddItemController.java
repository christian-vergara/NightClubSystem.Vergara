package Controller.AddItemController;

import Model.Objects.Item;
import View.AddView.AddItemView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/13/2016.
 */
public class AddItemController {
    public AddItemController(AddItemView addItemView) {

        addItemView.setAddItemEventListener(new AddItemEventListener() {
            @Override
            public void btnClicked(AddItemEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Item");
                confirmAdd.setContentText("Would you like to add this Item?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        Item i = new Item(eventObject.getType(), eventObject.getName(), eventObject.getDescription(), eventObject.getPrice());
                        addItemView.getNameField().clear();
                        addItemView.getDescriptionField().clear();
                        addItemView.getPriceField().clear();
                    }
                });
            }

        });
    }
}

