package Controller.AddCustomerController;

import App.App;
import Model.Bags.UserBag;
import Model.Objects.Customer;
import Model.Objects.User;
import View.AddView.AddCustomerView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Studio on 12/12/2016.
 */
public class AddCustomerController {

    private AddCustomerView view;

    public AddCustomerController(AddCustomerView view) {
        this.view = view;

        view.setAddCustomerListener(new AddCustomerListener() {
            @Override
            public void btnClicked(AddCustomerEventObject eventObject) {
                Alert confirmAdd = new Alert(Alert.AlertType.CONFIRMATION);
                confirmAdd.setTitle("Confirm");
                confirmAdd.setHeaderText("Add New Customer");
                confirmAdd.setContentText("Would you like to add this Customer?");
                confirmAdd.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        User c = new Customer(eventObject.getfName(), eventObject.getlName(), eventObject.getUserName(), eventObject.getPass());
                        Alert success = new Alert(Alert.AlertType.INFORMATION);
                        success.setTitle("Success!");
                        success.setHeaderText("Customer Added!");
                        success.showAndWait();
                        view.getfNameField().clear();
                        view.getlNameField().clear();
                        view.getuNameField().clear();
                        view.getPassField().clear();
                        view.getUserIdField().setText(Integer.toString(User.getCount()));
                    }
                });


            }
        });



    }

}
