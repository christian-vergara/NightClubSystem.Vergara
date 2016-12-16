package Controller.AddItemController;

import Model.Objects.Beer;
import Model.Objects.Item;
import Model.Objects.Liquor;
import Model.Objects.Wine;
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

            @Override
            public void btnClickedBeer(AddBeerEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Beer");
                confirmAdd.setContentText("Would you like to add this Beer?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        Item b = new Beer(eventObject.getType(), eventObject.getName(), eventObject.getDescription(), eventObject.getPrice(), eventObject.getBrand(), eventObject.getOrigin(), eventObject.getAlcVol() );
                        addItemView.getNameField().clear();
                        addItemView.getDescriptionField().clear();
                        addItemView.getPriceField().clear();
                        addItemView.getBrandField().clear();
                        addItemView.getOriginField().clear();
                        addItemView.getAlcVolField().clear();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Added!");
                        alert.setHeaderText("Item has been added!");
                        alert.showAndWait();
                    }
                });
            }

            @Override
            public void btnClickedWine(AddWineEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Wine");
                confirmAdd.setContentText("Would you like to add this Wine?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        Item w = new Wine(eventObject.getType(), eventObject.getName(), eventObject.getDescription(), eventObject.getPrice(), eventObject.getBrand(), eventObject.getOrigin(), eventObject.getColor(), eventObject.getAlcVol() );
                        addItemView.getNameField().clear();
                        addItemView.getDescriptionField().clear();
                        addItemView.getPriceField().clear();
                        addItemView.getBrandField().clear();
                        addItemView.getOriginField().clear();
                        addItemView.getColorField().clear();
                        addItemView.getAlcVolField().clear();
                    }
                });
            }

            @Override
            public void btnClickedLiquor(AddLiquorEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Liquor");
                confirmAdd.setContentText("Would you like to add this Liquor?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        Item l = new Liquor(eventObject.getType(), eventObject.getName(), eventObject.getDescription(), eventObject.getPrice(), eventObject.getBrand(), eventObject.getOrigin(), eventObject.getAlcVol() );
                        addItemView.getNameField().clear();
                        addItemView.getDescriptionField().clear();
                        addItemView.getPriceField().clear();
                        addItemView.getBrandField().clear();
                        addItemView.getOriginField().clear();
                        addItemView.getAlcVolField().clear();
                    }
                });

            }
        });

    }
}

