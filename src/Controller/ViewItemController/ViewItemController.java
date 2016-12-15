package Controller.ViewItemController;

import Model.Objects.Beer;
import Model.Objects.Item;
import Model.Objects.Liquor;
import Model.Objects.Wine;
import View.AddView.AddItemView;
import View.ViewView.ViewItemView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/13/2016.
 */
public class ViewItemController {

    private Item item;
    private Item beerItem;
    private Item wineItem;
    private Item liquorItem;
    private ViewItemView viewItemView;

    public ViewItemController(ViewItemView viewItemView, Item item) {

        this.item = item;
        this.viewItemView = viewItemView;

        viewItemView.setViewItemEventListener(new ViewItemEventListener() {

            @Override
            public void btnClicked(ViewItemEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Item");
                confirmAdd.setContentText("Would you like to add this Item?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        item.setName(eventObject.getName());
                        item.setDescription(eventObject.getDescription());
                        item.setPrice(eventObject.getPrice());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Updated!");
                        success.setHeaderText("Item was succesfully updated!");
                        success.showAndWait();
                    }
                });
            }

            @Override
            public void btnClickedBeer(ViewBeerEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Update Beer");
                confirmAdd.setContentText("Would you like to update this Beer?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        item.setName(eventObject.getName());
                        item.setDescription(eventObject.getDescription());
                        item.setPrice(eventObject.getPrice());
                        ((Beer) item).setOrigin(eventObject.getOrigin());
                        ((Beer) item).setBrand(eventObject.getBrand());
                        ((Beer) item).setAlcVol(eventObject.getAlcVol());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Updated!");
                        success.setHeaderText("Item was succesfully updated!");
                        success.showAndWait();
                    }
                });
            }

            @Override
            public void btnClickedWine(ViewWineEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Update Wine");
                confirmAdd.setContentText("Would you like to update this Wine?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        item.setName(eventObject.getName());
                        item.setDescription(eventObject.getDescription());
                        item.setPrice(eventObject.getPrice());
                        ((Wine) item).setBrand(eventObject.getBrand());
                        ((Wine) item).setAlcVol(eventObject.getAlcVol());
                        ((Wine) item).setOrigin(eventObject.getOrigin());
                        ((Wine) item).setColor(eventObject.getOrigin());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Updated!");
                        success.setHeaderText("Item was succesfully updated!");
                        success.showAndWait();
                    }
                });
            }

            @Override
            public void btnClickedLiquor(ViewLiquorEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Update Liquor");
                confirmAdd.setContentText("Would you like to update this Liquor?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        item.setName(eventObject.getName());
                        item.setDescription(eventObject.getDescription());
                        item.setPrice(eventObject.getPrice());
                        ((Liquor) item).setBrand(eventObject.getBrand());
                        ((Liquor) item).setOrigin(eventObject.getOrigin());
                        ((Liquor) item).setAlcVol(eventObject.getAlcVol());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Updated!");
                        success.setHeaderText("Item was succesfully updated!");
                        success.showAndWait();
                    }
                });

            }
        });

    }
}

