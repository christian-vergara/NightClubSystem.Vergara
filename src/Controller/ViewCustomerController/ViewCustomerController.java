package Controller.ViewCustomerController;

import Model.Objects.Customer;
import Model.Objects.User;
import View.AddView.AddCustomerView;
import View.ViewView.ViewCustomerView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/12/2016.
 */
public class ViewCustomerController {

    private ViewCustomerView view;

    public ViewCustomerController(ViewCustomerView view) {
        this.view = view;

        view.setViewCustomerListener(new ViewCustomerListener() {
            @Override
            public void btnClicked(ViewCustomerEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Update Customer");
                confirmAdd.setContentText("Would you like to update this Customer?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        view.getSearchResult().setfName(eventObject.getfName());
                        view.getSearchResult().setlName(eventObject.getlName());
                        view.getSearchResult().setUserName(eventObject.getUserName());
                        view.getSearchResult().setPassword(eventObject.getPass());
                        Alert confirm = new Alert(Alert.AlertType.INFORMATION);
                        confirm.setTitle("Success!");
                        confirm.setHeaderText("Customer Updated!");
                        confirm.showAndWait();
                    }
                });


            }
        });



    }

}
